package io.github.zhdotm.ohzh.idempotent.core.handler;

import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentPoint;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * 幂等处理器
 *
 * @author zhihao.mao
 */

public interface IIdempotentHandler {

    /**
     * 名称
     *
     * @return 名称
     */
    String getName();

    /**
     * 尝试获取锁
     *
     * @param idempotentPoint 幂等点
     * @return 成功/失败
     */
    Boolean tryLock(IdempotentPoint idempotentPoint);

    /**
     * 解锁
     *
     * @param idempotentPoint 幂等点
     */
    void unlock(IdempotentPoint idempotentPoint);

    /**
     * 处理获取锁成功逻辑
     *
     * @param idempotentPoint 幂等点
     */
    void lockSuccess(IdempotentPoint idempotentPoint);

    /**
     * 处理获取锁失败逻辑
     *
     * @param idempotentPoint 幂等点
     */
    void lockFail(IdempotentPoint idempotentPoint);

    /**
     * 处理完成
     *
     * @param idempotentPoint 幂等点
     * @param result          业务逻辑处理结果
     */
    void handleComplete(IdempotentPoint idempotentPoint, Object result);

    /**
     * 处理异常
     *
     * @param idempotentPoint 幂等点
     * @param throwable       抛出的异常
     */
    void handleException(IdempotentPoint idempotentPoint, Throwable throwable);

    /**
     * 幂等处理
     *
     * @param idempotentPoint 幂等点
     */
    @SneakyThrows
    default void handle(IdempotentPoint idempotentPoint) {
        if (ObjectUtil.isEmpty(idempotentPoint)) {

            return;
        }
        if (tryLock(idempotentPoint)) {
            lockSuccess(idempotentPoint);
            try {
                Object target = idempotentPoint.getTarget();
                Method method = idempotentPoint.getMethod();
                Object[] args = idempotentPoint.getArgs();
                Object result = method.invoke(target, args);
                handleComplete(idempotentPoint, result);
            } catch (Throwable throwable) {
                handleException(idempotentPoint, throwable);
            } finally {
                unlock(idempotentPoint);
            }
        } else {
            lockFail(idempotentPoint);
        }
    }

}
