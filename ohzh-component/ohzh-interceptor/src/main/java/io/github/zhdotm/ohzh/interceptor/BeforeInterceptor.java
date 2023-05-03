package io.github.zhdotm.ohzh.interceptor;

/**
 * 前置处理器
 *
 * @param <Input> 输入
 * @author zhihao.mao
 */

@FunctionalInterface
public interface BeforeInterceptor<Input> {

    /**
     * 排序
     *
     * @return 排序
     */
    default Integer order() {

        return Integer.MAX_VALUE;
    }

    /**
     * 执行前处理
     *
     * @param input 输入
     * @return 输入
     */
    Input before(Input input);

}
