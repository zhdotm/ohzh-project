package io.github.zhdotm.ohzh.pipeline.core;

/**
 * 管道阀门
 *
 * @param <Input>  输入
 * @param <Output> 输出
 * @author zhihao.mao
 */

@FunctionalInterface
public interface IValve<Input, Output> {

    /**
     * 抽水
     *
     * @param input   输入
     * @param context 阀门上下文
     * @return 输出
     */
    Output drawOff(IValveContext<Input, Output> context, Input input);

}
