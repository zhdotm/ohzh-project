package io.github.zhdotm.ohzh.pipeline.starter.web.annotation;

import java.lang.annotation.*;

/**
 * 管道
 *
 * @author zhihao.mao
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Pipeline {

    String name() default "";

    String code();

    String description() default "";
}
