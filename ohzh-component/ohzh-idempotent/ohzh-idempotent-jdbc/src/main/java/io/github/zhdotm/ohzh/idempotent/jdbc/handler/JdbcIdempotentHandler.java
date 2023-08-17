package io.github.zhdotm.ohzh.idempotent.jdbc.handler;

import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.idempotent.core.exception.IdempotentException;
import io.github.zhdotm.ohzh.idempotent.core.exception.IdempotentExceptionEnum;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentPoint;
import io.github.zhdotm.ohzh.idempotent.core.serializer.Serializer;
import io.github.zhdotm.ohzh.idempotent.jdbc.configuration.JdbcIdempotentProperties;
import io.github.zhdotm.ohzh.idempotent.jdbc.model.ReturnObj;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 利用数据库的唯一索引做幂等
 *
 * @author zhihao.mao
 */

@Slf4j
@AllArgsConstructor
public class JdbcIdempotentHandler implements IIdempotentHandler {

    private final JdbcTemplate jdbcTemplate;

    private final Serializer serializer;

    private final JdbcIdempotentProperties jdbcIdempotentProperties;

    @Override
    public Boolean tryLock(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();
        String methodName = idempotentPoint.getMethodName();
        String key = idempotentPoint.getKey();
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            throw new IdempotentException(IdempotentExceptionEnum.TRANSACTION_IS_NOT_ACTIVE.getCode(), IdempotentExceptionEnum.TRANSACTION_IS_NOT_ACTIVE.getMessage(bizId, methodName, key));
        }

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
    public Object handlerFail(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();
        String methodName = idempotentPoint.getMethodName();
        String key = idempotentPoint.getKey();
        String selectSql = jdbcIdempotentProperties.getSelectSql();

        ReturnObj returnObj = jdbcTemplate.queryForObject(selectSql, ReturnObj.class, bizId, key);
        if (ObjectUtil.isEmpty(returnObj)) {

            throw new IdempotentException(IdempotentExceptionEnum.EXEC_IS_NOT_DONE.getCode(), IdempotentExceptionEnum.EXEC_IS_NOT_DONE.getMessage(bizId, methodName, key));
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

    @Override
    public Object handleSuccess(IdempotentPoint idempotentPoint, Object result) {
        String bizId = idempotentPoint.getBizId();
        String key = idempotentPoint.getKey();
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
