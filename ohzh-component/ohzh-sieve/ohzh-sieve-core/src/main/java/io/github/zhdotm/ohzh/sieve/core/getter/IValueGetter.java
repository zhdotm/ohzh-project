package io.github.zhdotm.ohzh.sieve.core.getter;

import java.util.Collection;

/**
 * 值获取器
 *
 * @author zhihao.mao
 */

public interface IValueGetter {

    /**
     * 获取值
     *
     * @param <T> 值类型
     * @return 值
     */
    <T> Collection<T> get();

}
