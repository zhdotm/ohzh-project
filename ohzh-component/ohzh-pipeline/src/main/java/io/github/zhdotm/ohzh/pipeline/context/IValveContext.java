package io.github.zhdotm.ohzh.pipeline.context;

import io.github.zhdotm.ohzh.pipeline.IPipeline;
import io.github.zhdotm.ohzh.pipeline.util.IAttributeMap;
import io.github.zhdotm.ohzh.pipeline.valve.IValve;

import java.util.Collection;
import java.util.Map;

/**
 * 阀门上下文
 *
 * @author zhihao.mao
 */

public interface IValveContext<Input, Output> extends IAttributeMap {

    /**
     * 获取阀门名称
     *
     * @return 阀门名称
     */
    String getName();

    /**
     * 获取管道
     *
     * @return 管道
     */
    IPipeline<Input, Output> getPipeline();

    /**
     * 获取阀门
     *
     * @return 阀门
     */
    IValve<Input, Output> getValve();

    /**
     * 获取上一个管道阀门
     *
     * @return 上一个管道阀门
     */
    IValveContext<Input, Output> getBefore();

    /**
     * 设置上一个管道阀门
     *
     * @param before 上一个管道阀门
     */
    void setBefore(IValveContext<Input, Output> before);

    /**
     * 获取下一个管道阀门
     *
     * @return 下一个管道阀门
     */
    IValveContext<Input, Output> getNext();

    /**
     * 设置下一个管道阀门
     *
     * @param next 下一个管道阀门
     */
    void setNext(IValveContext<Input, Output> next);

    /**
     * 设置属性
     *
     * @param key   key
     * @param value value
     * @param <V>   value类型
     */
    @Override
    default <V> void setAttr(String key, V value) {

        getPipeline().setAttr(key, value);
    }

    /**
     * 移除属性
     *
     * @param key key
     */
    @Override
    default void removeAttr(String key) {

        getPipeline().removeAttr(key);
    }

    /**
     * 清理所有属性
     */
    @Override
    default void clearAttrs() {

        getPipeline().clearAttrs();
    }

    /**
     * 获取属性
     *
     * @param key key
     * @param <V> value 类型
     * @return value
     */
    @Override
    default <V> V getAttr(String key) {

        return getPipeline().getAttr(key);
    }

    /**
     * 获取所有属性键
     *
     * @return 所有属性键
     */
    @Override
    default Collection<String> getAttrKeys() {

        return getPipeline().getAttrKeys();
    }

    /**
     * 获取所有属性
     *
     * @return 所有属性
     */
    @Override
    default Map<String, ?> getAttrs() {

        return getPipeline().getAttrs();
    }

    /**
     * 传播
     *
     * @param input 输入
     * @return 输出
     */
    default Output fireDrawOff(Input input) {
        IValveContext<Input, Output> nextValveContext = getNext();
        IValve<Input, Output> nextValve = nextValveContext.getValve();

        return nextValve.drawOff(nextValveContext, input);
    }

}
