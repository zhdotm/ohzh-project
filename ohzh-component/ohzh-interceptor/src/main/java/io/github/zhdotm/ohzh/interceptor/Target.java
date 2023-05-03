package io.github.zhdotm.ohzh.interceptor;


/**
 * 处理请求的目标接口
 *
 * @param <Input>  入参
 * @param <Output> 出参
 * @author zhihao.mao
 */

@FunctionalInterface
public interface Target<Input, Output> {

    /**
     * 执行请求
     *
     * @param request 请求
     * @return 响应
     */
    Output execute(Input request);

}
