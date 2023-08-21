package io.github.zhdotm.ohzh.idempotent.redis.handler;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.idempotent.core.exception.IdempotentException;
import io.github.zhdotm.ohzh.idempotent.core.exception.IdempotentExceptionEnum;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.point.IdempotentPoint;
import io.github.zhdotm.ohzh.idempotent.redis.configuration.RedisIdempotentProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhihao.mao
 */

@Slf4j
@AllArgsConstructor
public class RedisIdempotentHandler implements IIdempotentHandler {

    @Getter
    private final String name;

    private final RedissonClient redissonClient;

    private final RedisIdempotentProperties redisIdempotentProperties;

    private final ThreadLocal<RLock> rLockThreadLocal = new ThreadLocal<>();

    @Override
    public void handleExpire(IdempotentPoint idempotentPoint) {
        //不用处理，利用redis自己的过期机制
    }

    @SneakyThrows
    @Override
    public Boolean tryLock(IdempotentPoint idempotentPoint) {
        RLock lock = redissonClient.getLock(redisIdempotentProperties.getLockKeyPrefix() + idempotentPoint.getKey());
        boolean isLocked = lock.tryLock();
        if (isLocked) {
            rLockThreadLocal.set(lock);
        }

        return isLocked;
    }

    @Override
    public void unlock(IdempotentPoint idempotentPoint) {
        RLock lock = rLockThreadLocal.get();
        if (ObjectUtil.isNotEmpty(lock)) {
            lock.unlock();
        }
        rLockThreadLocal.remove();
    }

    @Override
    public Object handleLockFail(IdempotentPoint idempotentPoint) {
        String key = idempotentPoint.getKey();
        RMapCache<String, Object> cache = getCache(idempotentPoint);
        Set<String> keySet = cache.keySet();
        if (!keySet.contains(key)) {
            String repeatedRequestMessage = idempotentPoint.getRepeatedRequestMessage();
            if (StrUtil.isBlank(repeatedRequestMessage)) {
                repeatedRequestMessage = IdempotentExceptionEnum.REPEATED_REQUEST.getMessage();
            }

            throw new IdempotentException(IdempotentExceptionEnum.REPEATED_REQUEST.getCode(), repeatedRequestMessage);
        }

        return cache.get(key);
    }

    @SneakyThrows
    @Override
    public Object handleLockSuccess(IdempotentPoint idempotentPoint) {
        String key = idempotentPoint.getKey();
        RMapCache<String, Object> cache = getCache(idempotentPoint);
        Set<String> keySet = cache.keySet();
        if (!keySet.contains(key)) {
            Object target = idempotentPoint.getTarget();
            Method method = idempotentPoint.getMethod();
            Object[] args = idempotentPoint.getArgs();
            Object result = method.invoke(target, args);
            cache.put(key, result, idempotentPoint.getExpire(), TimeUnit.SECONDS);
        }

        return cache.get(key);
    }

    @SneakyThrows
    @Override
    public Object handleException(IdempotentPoint idempotentPoint, Throwable throwable) {
        RMapCache<String, Object> cache = getCache(idempotentPoint);
        String key = idempotentPoint.getKey();
        cache.remove(key);

        throw throwable;
    }

    private RMapCache<String, Object> getCache(IdempotentPoint idempotentPoint) {
        String bizId = idempotentPoint.getBizId();

        return redissonClient.getMapCache(redisIdempotentProperties.getCacheKeyPrefix() + bizId);
    }

}
