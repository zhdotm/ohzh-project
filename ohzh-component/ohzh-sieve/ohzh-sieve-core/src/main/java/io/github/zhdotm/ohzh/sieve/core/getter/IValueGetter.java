package io.github.zhdotm.ohzh.sieve.core.getter;

import java.util.Collection;
import java.util.List;

/**
 * 值获取器
 *
 * @author zhihao.mao
 */

public interface IValueGetter {

    /**
     * 获取值获取器名称
     *
     * @return 值获取器名称
     */
    String getName();

    /**
     * 获取值
     *
     * @return 值
     */
    List<String> get();

}
