package io.github.zhdotm.ohzh.interceptor;

/**
 * 后置处理器
 *
 * @param <Input>  输入
 * @param <Output> 输出
 * @author zhihao.mao
 */

@FunctionalInterface
public interface IAfterInterceptor<Input, Output> {

    /**
     * 排序
     *
     * @return 排序
     */
    default Integer order() {

        return Integer.MAX_VALUE;
    }

    /**
     * 执行后处理
     *
     * @param input  输入
     * @param output 输出
     * @return 输出
     */
    Output after(Input input, Output output);

}
