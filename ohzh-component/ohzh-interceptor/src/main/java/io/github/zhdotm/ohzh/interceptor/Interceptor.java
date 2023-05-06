package io.github.zhdotm.ohzh.interceptor;

import java.lang.annotation.*;

/**
 * 拦截器注解
 *
 * @author zhihao.mao
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Interceptor {

    /**
     * 拦截点注解
     *
     * @return 拦截点注解
     */
    InterceptPoint[] points();

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({})
    @interface InterceptPoint {

        /**
         * 类
         *
         * @return 类
         */
        Class<?> type();

        /**
         * 方法名称
         *
         * @return 方法名称
         */
        String method();

        /**
         * 参数类型
         *
         * @return 参数类型
         */
        Class<?>[] args();
    }
}
