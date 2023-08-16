package io.github.zhdotm.ohzh.idempotent.jdbc.handler;

import cn.hutool.core.util.ObjectUtil;
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
        String key = idempotentPoint.getKey();
        String methodName = idempotentPoint.getMethodName();
        String insertSql = jdbcIdempotentProperties.getInsertSql();
        try {
            jdbcTemplate.update(insertSql, bizId, key, methodName);
            return true;
        } catch (DuplicateKeyException e) {
            log.debug("获取锁失败: bizId[{}], key[{}], methodName[{}]", bizId, key, methodName);
            return false;
        }
    }

    @Override
    public void unlock(IdempotentPoint idempotentPoint) {

    }

    @Override
    public Object handlerFail(IdempotentPoint idempotentPoint) {
        Class<?> returnType = idempotentPoint.getReturnType();
        if (ObjectUtil.isEmpty(returnType)) {

            return null;
        }
        String bizId = idempotentPoint.getBizId();
        String key = idempotentPoint.getKey();
        String selectSql = jdbcIdempotentProperties.getSelectSql();
        ReturnObj returnObj = jdbcTemplate.queryForObject(selectSql, ReturnObj.class, bizId, key);
        if (ObjectUtil.isEmpty(returnObj)) {

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
        String bizId = idempotentPoint.getBizId();
        String key = idempotentPoint.getKey();
        String deleteSql = jdbcIdempotentProperties.getDeleteSql();
        jdbcTemplate.update(deleteSql, bizId, key);

        throw throwable;
    }

}
