package io.github.zhdotm.ohzh.idempotent.core.manager;

import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;

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
}
