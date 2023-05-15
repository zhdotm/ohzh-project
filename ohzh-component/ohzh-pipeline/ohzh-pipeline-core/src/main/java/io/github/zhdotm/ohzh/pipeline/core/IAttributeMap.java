package io.github.zhdotm.ohzh.pipeline.core;

import java.util.Collection;
import java.util.Map;

/**
 * 属性
 *
 * @author zhihao.mao
 */

public interface IAttributeMap {

    /**
     * 设置属性
     *
     * @param key   key
     * @param value value
     * @param <V>   value 类型
     */
    <V> void setAttr(String key, V value);

    /**
     * 获取属性值
     *
     * @param key key
     * @param <V> value 类型
     * @return value
     */
    <V> V getAttr(String key);

    /**
     * 获取所有属性键
     *
     * @return 所有属性键
     */
    Collection<String> getAttrKeys();

    /**
     * 获取所有属性
     *
     * @return 所有属性
     */
    Map<String, ?> getAttrs();

    /**
     * 移除属性
     *
     * @param key key
     */
    void removeAttr(String key);

    /**
     * 清理所有属性
     */
    void clearAttrs();
}
