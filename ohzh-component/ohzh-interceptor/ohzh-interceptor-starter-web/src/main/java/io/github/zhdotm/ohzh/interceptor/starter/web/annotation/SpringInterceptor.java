package io.github.zhdotm.ohzh.interceptor.starter.web.annotation;

import io.github.zhdotm.ohzh.interceptor.core.annotation.InterceptPoint;
import io.github.zhdotm.ohzh.interceptor.core.annotation.Interceptor;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 拦截器注解
 *
 * @author zhihao.mao
 */

@Component
@Interceptor
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpringInterceptor {

    /**
     * 拦截器名称
     *
     * @return 拦截器名称
     */
    @AliasFor(annotation = Component.class, attribute = "value")
    String name();

    /**
     * 拦截点
     *
     * @return 拦截点
     */
    @AliasFor(annotation = Interceptor.class, attribute = "points")
    InterceptPoint[] points() default {};
}
