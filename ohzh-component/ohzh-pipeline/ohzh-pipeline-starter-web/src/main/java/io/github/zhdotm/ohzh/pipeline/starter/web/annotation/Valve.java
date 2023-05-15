package io.github.zhdotm.ohzh.pipeline.starter.web.annotation;

import java.lang.annotation.*;

/**
 * 阀门
 *
 * @author zhihao.mao
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Valve {

    Pipeline pipeline();

    String id();

    int order() default Integer.MAX_VALUE;
}
