package io.github.zhdotm.ohzh.pipeline;

/**
 * 管道阀门
 *
 * @param <Input>      输入
 * @param <TempOutput> 临时输出
 * @param <Output>     输出
 * @author zhihao.mao
 */

public interface IValve<Input, TempOutput, Output> {

    /**
     * 获取下一个管道阀门
     *
     * @return 下一个管道阀门
     */
    IValve<Input, TempOutput, Output> getNext();

    /**
     * 设置下一个管道阀门
     *
     * @param valve 下一个管道阀门
     */
    void setNext(IValve<Input, TempOutput, Output> valve);

    /**
     * 执行阀门过滤
     *
     * @param input      输入
     * @param tempOutput 临时输出
     * @return 输出
     */
    Output invoke(Input input, TempOutput tempOutput);

}
