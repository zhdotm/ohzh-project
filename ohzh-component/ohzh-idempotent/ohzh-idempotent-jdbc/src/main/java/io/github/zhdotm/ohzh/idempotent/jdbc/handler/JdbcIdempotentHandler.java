package io.github.zhdotm.ohzh.idempotent.jdbc.handler;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.idempotent.core.exception.IdempotentException;
import io.github.zhdotm.ohzh.idempotent.core.exception.IdempotentExceptionEnum;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.point.IdempotentPoint;
import io.github.zhdotm.ohzh.idempotent.core.serializer.Serializer;
import io.github.zhdotm.ohzh.idempotent.jdbc.configuration.JdbcIdempotentProperties;
import io.github.zhdotm.ohzh.idempotent.jdbc.model.ReturnObj;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 利用数据库的唯一索引做幂等
 *
 * @author zhihao.mao
 */

@Slf4j
@AllArgsConstructor
public class JdbcIdempotentHandler implements IIdempotentHandler {

    @Getter
    private final String name;

    private final JdbcTemplate jdbcTemplate;

    private final Serializer serializer;

    private final JdbcIdempotentProperties jdbcIdempotentProperties;

    @Override
    public void handleExpire(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();
        String methodName = idempotentPoint.getMethodName();
        String key = idempotentPoint.getKey();
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            throw new IdempotentException(IdempotentExceptionEnum.TRANSACTION_IS_NOT_ACTIVE.getCode(), IdempotentExceptionEnum.TRANSACTION_IS_NOT_ACTIVE.getMessage());
        }

        Long expire = idempotentPoint.getExpire();
        if (ObjectUtil.isNotEmpty(expire) && expire > 0) {
            String deleteSql = jdbcIdempotentProperties.getDeleteSql();
            jdbcTemplate.update(deleteSql, bizId, key, DateUtil.formatLocalDateTime(LocalDateTime.now().plusSeconds(-expire)));
        }
    }

    @Override
    public Boolean tryLock(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();
        String methodName = idempotentPoint.getMethodName();
        String key = idempotentPoint.getKey();

        String insertSql = jdbcIdempotentProperties.getInsertSql();
        try {
            jdbcTemplate.update(insertSql, bizId, key, methodName);

            return Boolean.TRUE;
        } catch (DuplicateKeyException e) {
            log.debug("获取锁失败: bizId[{}], key[{}], methodName[{}]", bizId, key, methodName);

            return Boolean.FALSE;
        }
    }

    @Override
    public void unlock(IdempotentPoint idempotentPoint) {

    }

    @Override
    public Object handleLockFail(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();
        String key = idempotentPoint.getKey();

        //查询已有的执行结果
        String selectSql = jdbcIdempotentProperties.getSelectSql();
        ReturnObj returnObj = jdbcTemplate.queryForObject(selectSql, (resultSet, i) -> ReturnObj.create(resultSet), bizId, key);
        //由于数据库临键锁的原因，理论上走不到这一步
        if (ObjectUtil.isEmpty(returnObj)) {
            String repeatedRequestMessage = idempotentPoint.getRepeatedRequestMessage();
            if (StrUtil.isBlank(repeatedRequestMessage)) {
                repeatedRequestMessage = IdempotentExceptionEnum.REPEATED_REQUEST.getMessage();
            }

            throw new IdempotentException(IdempotentExceptionEnum.REPEATED_REQUEST.getCode(), repeatedRequestMessage);
        }

        Class<?> returnType = idempotentPoint.getReturnType();
        if (ObjectUtil.isEmpty(returnType)) {

            return null;
        }

        byte[] returnObjBlob = returnObj.getReturnObjBlob();
        if (ObjectUtil.isEmpty(returnObjBlob)) {

            return null;
        }

        return serializer.deserialize(returnObjBlob, returnType);
    }

    @SneakyThrows
    @Override
    public Object handleLockSuccess(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();
        String key = idempotentPoint.getKey();
        Object target = idempotentPoint.getTarget();
        Method method = idempotentPoint.getMethod();
        Object[] args = idempotentPoint.getArgs();
        Object result = method.invoke(target, args);
        byte[] returnObjBlob = null;
        if (ObjectUtil.isNotEmpty(result)) {
            returnObjBlob = serializer.serialize(result);
        }
        String updateSql = jdbcIdempotentProperties.getUpdateSql();
        jdbcTemplate.update(updateSql, returnObjBlob, bizId, key);

        return result;
    }

    @SneakyThrows
    @Override
    public Object handleException(IdempotentPoint idempotentPoint, Throwable throwable) {
        //由事务控制idempotent记录的原子性
        throw throwable;
    }

}
