package io.github.zhdotm.ohzh.pipeline;

/**
 * 管道
 *
 * @param <Input>>  管道输入
 * @param <Output>> 管道输出
 * @author zhihao.mao
 */

public interface IPipeline<Input, TempOutput, Output> {

    /**
     * 获取头部阀门
     *
     * @return 头部阀门
     */
    IValve<Input, TempOutput, Output> getHead();

    /**
     * 设置头部阀门
     *
     * @param head 头部阀门
     */
    void setHead(IValve<Input, TempOutput, Output> head);

    /**
     * 获取尾部阀门
     *
     * @return 尾部阀门
     */
    IValve<Input, TempOutput, Output> getTail();

    /**
     * 设置尾部阀门
     *
     * @param tail 尾部阀门
     */
    void setTail(IValve<Input, TempOutput, Output> tail);

    /**
     * 添加阀门
     *
     * @param valve 阀门
     */
    default void addValve(IValve<Input, TempOutput, Output> valve) {
        IValve<Input, TempOutput, Output> head = getHead();
        if (head == null) {
            setHead(valve);
            setTail(valve);
            return;
        }
        IValve<Input, TempOutput, Output> tail = getTail();
        tail.setNext(valve);
        setTail(valve);
    }

    /**
     * 执行
     *
     * @param input 输入
     * @return 输出
     */
    default Output invoke(Input input) {
        IValve<Input, TempOutput, Output> head = getHead();

        return head.invoke(input, null);
    }

}
