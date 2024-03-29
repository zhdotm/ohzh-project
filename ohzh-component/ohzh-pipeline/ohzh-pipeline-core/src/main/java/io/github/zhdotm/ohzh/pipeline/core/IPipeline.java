package io.github.zhdotm.ohzh.pipeline.core;

/**
 * 管道
 *
 * @param <Input>>  管道输入
 * @param <Output>> 管道输出
 * @author zhihao.mao
 */

public interface IPipeline<Input, Output> extends IAttributeMap {

    /**
     * 获取管道名称
     *
     * @return 管道名称
     */
    String getName();

    /**
     * 获取头部阀门
     *
     * @return 头部阀门
     */
    IValve<Input, Output> getFirstValve();

    /**
     * 获取尾部阀门
     *
     * @return 尾部阀门
     */
    IValve<Input, Output> getLastValve();

    /**
     * 获取阀门
     *
     * @param name 阀门名称
     * @return 阀门
     */
    IValve<Input, Output> getValve(String name);

    /**
     * 移除阀门
     *
     * @param name 阀门名称
     */
    void removeValve(String name);

    /**
     * 添加头部阀门
     *
     * @param name  阀门名称
     * @param valve 阀门
     */
    void addFirstValve(String name, IValve<Input, Output> valve);

    /**
     * 移除首个阀门
     */
    void removeFirstValve();

    /**
     * 添加尾部阀门
     *
     * @param name  阀门名称
     * @param valve 阀门
     */
    void addLastValve(String name, IValve<Input, Output> valve);

    /**
     * 移除最后一个阀门
     */
    void removeLastValve();

    /**
     * 抽水
     *
     * @param input 输入
     * @return 输出
     */
    Output drawOff(Input input);

}
