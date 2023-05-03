package io.github.zhdotm.ohzh.interceptor;

/**
 * 拦截器接口
 *
 * @param <Input>  入参
 * @param <Output> 出参
 * @author zhihao.mao
 */

public interface Interceptor<Input, Output> extends BeforeInterceptor<Input>, AfterInterceptor<Input, Output> {

    /**
     * 排序
     *
     * @return 排序
     */
    @Override
    default Integer order() {

        return Integer.MAX_VALUE;
    }

}
