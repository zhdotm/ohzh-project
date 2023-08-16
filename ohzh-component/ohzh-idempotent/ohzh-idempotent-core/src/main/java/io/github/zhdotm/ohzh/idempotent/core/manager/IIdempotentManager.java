package io.github.zhdotm.ohzh.idempotent.core.manager;

import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.idempotent.core.annotation.Idempotent;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentInfo;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentPoint;

import java.lang.reflect.Method;

/**
 * @author zhihao.mao
 */

public interface IIdempotentManager {

    /**
     * 添加处理器
     *
     * @param handler 处理器
     */
    void putHandler(IIdempotentHandler handler);

    /**
     * 获取处理器
     *
     * @param handlerName 处理器名称
     * @return 处理器
     */
    IIdempotentHandler getHandler(String handlerName);

    /**
     * 移除处理器
     *
     * @param handlerName 处理器名称
     */
    void removeHandler(String handlerName);

    /**
     * 移除处理器
     *
     * @param handler 处理器
     */
    default void removeHandler(IIdempotentHandler handler) {
        if (ObjectUtil.isEmpty(handler)) {

            return;
        }

        removeHandler(handler.getName());
    }

    /**
     * 添加键获取器
     *
     * @param keyGetter 键获取器
     */
    void putKeyGetter(IIdempotentKeyGetter keyGetter);

    /**
     * 获取键获取器
     *
     * @param keyGetterName 键获取器名称
     * @return 键获取器
     */
    IIdempotentKeyGetter getKeyGetter(String keyGetterName);

    /**
     * 移除键获取器
     *
     * @param keyGetterName 键获取器名称
     */
    void removeKeyGetter(String keyGetterName);

    /**
     * 移除键获取器
     *
     * @param keyGetter 键获取器
     */
    default void removeKeyGetter(IIdempotentKeyGetter keyGetter) {
        if (ObjectUtil.isEmpty(keyGetter)) {

            return;
        }

        removeKeyGetter(keyGetter.getName());
    }

    /**
     * 创建幂等信息
     *
     * @param idempotent 幂等注解
     * @param target     目标
     * @param method     方法
     * @param args       参数
     * @return 幂等信息
     */
    default IdempotentInfo createIdempotentInfo(Idempotent idempotent, Object target, Method method, Object[] args) {
        String keyGetterName = idempotent.keyGetterName();
        IIdempotentKeyGetter iIdempotentKeyGetter = getKeyGetter(keyGetterName);
        String handlerName = idempotent.handlerName();
        IIdempotentHandler iIdempotentHandler = getHandler(handlerName);
        IdempotentPoint idempotentPoint = IdempotentPoint.create(idempotent.bizId(),
                target,
                method,
                args,
                idempotent.keyExpressionText(),
                iIdempotentKeyGetter,
                idempotent.lockTimeoutMilli());

        return IdempotentInfo.create(idempotentPoint, iIdempotentHandler);
    }

}
