package io.github.zhdotm.ohzh.interceptor.core.annotation;

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
    InterceptPoint[] points() default {};
}
