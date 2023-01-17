package io.github.zhdotm.ohzh.ddd.domain.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 仓储注解
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface DomainRepository {

    /**
     * 仓储名称
     *
     * @return 仓储名称
     */
    String name() default "";

    /**
     * 仓储编码
     *
     * @return 仓储编码
     */
    String code();

    /**
     * 仓储描述
     *
     * @return 仓储描述
     */
    String description() default "";

}
