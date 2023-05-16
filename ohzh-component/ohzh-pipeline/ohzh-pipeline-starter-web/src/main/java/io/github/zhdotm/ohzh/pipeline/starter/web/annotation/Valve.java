package io.github.zhdotm.ohzh.pipeline.starter.web.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 阀门
 *
 * @author zhihao.mao
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Valve {

    /**
     * 管道名称
     *
     * @return 管道名称
     */
    String pipelineName();

    /**
     * 阀门名称
     *
     * @return 阀门名称
     */
    @AliasFor(annotation = Component.class, attribute = "value")
    String name();

    /**
     * 排序号
     *
     * @return 排序号
     */
    int order() default Integer.MAX_VALUE;
}
