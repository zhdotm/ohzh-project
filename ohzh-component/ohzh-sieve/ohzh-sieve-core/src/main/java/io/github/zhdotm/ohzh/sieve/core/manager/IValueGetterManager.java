package io.github.zhdotm.ohzh.sieve.core.manager;

import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetter;

/**
 * @author zhihao.mao
 */

public interface IValueGetterManager {

    /**
     * 添加值获取器
     *
     * @param valueGetter 值获取器
     */
    void putValueGetter(IValueGetter valueGetter);

    /**
     * 获取值获取器
     *
     * @param valueGetterName 值获取器名称
     * @return 值获取器
     */
    IValueGetter getValueGetter(String valueGetterName);

    /**
     * 移除值获取器
     *
     * @param valueGetterName 值获取器名称
     */
    void removeValueGetter(String valueGetterName);

    /**
     * 移除值获取器
     *
     * @param valueGetter 值获取器
     */
    void removeValueGetter(IValueGetter valueGetter);
}