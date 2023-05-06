package io.github.zhdotm.ohzh.interceptor;

/**
 * 拦截器
 *
 * @author zhihao.mao
 */

public interface IInterceptor {

    /**
     * 排序号
     *
     * @return 排序号
     */
    default Integer order() {

        return Integer.MAX_VALUE;
    }

    /**
     * 拦截
     *
     * @param interceptPointInvocation 拦截点调用信息
     * @return 调用结果
     */
    Object intercept(InterceptPointInvocation interceptPointInvocation);

    /**
     * 装配
     *
     * @param target 装配对象
     * @return 装配拦截器后的对象
     */
    Object assemble(Object target);

}
