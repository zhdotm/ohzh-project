package io.github.zhdotm.ohzh.idempotent.core.handler;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentPoint;
import lombok.SneakyThrows;

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
    default String getName() {

        return StrUtil.lowerFirst(ClassUtil.getClassName(this, Boolean.TRUE));
    }

    /**
     * 处理过期幂等点
     *
     * @param idempotentPoint 幂等点
     */
    void handleExpire(IdempotentPoint idempotentPoint);

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
     * 处理获取锁失败逻辑
     *
     * @param idempotentPoint 幂等点
     * @return 执行结果
     */
    Object handleLockFail(IdempotentPoint idempotentPoint);

    /**
     * 处理获取锁成功且业务执行成功逻辑
     *
     * @param idempotentPoint 幂等点
     * @return 执行结果
     */
    Object handleLockSuccess(IdempotentPoint idempotentPoint);

    /**
     * 处理异常
     *
     * @param idempotentPoint 幂等点
     * @param throwable       抛出的异常
     * @return 执行结果
     */
    Object handleException(IdempotentPoint idempotentPoint, Throwable throwable);

    /**
     * 幂等处理
     *
     * @param idempotentPoint 幂等点
     * @return 执行结果
     */
    @SneakyThrows
    default Object handle(IdempotentPoint idempotentPoint) {
        handleExpire(idempotentPoint);
        
        if (tryLock(idempotentPoint)) {
            try {

                return handleLockSuccess(idempotentPoint);
            } catch (Throwable throwable) {

                return handleException(idempotentPoint, throwable);
            } finally {

                unlock(idempotentPoint);
            }
        }

        return handleLockFail(idempotentPoint);
    }

}
