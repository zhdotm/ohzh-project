package io.github.zhdotm.ohzh.ddd.domain.aggregate.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


/**
 * 实体注解（原型）
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public @interface DomainEntity {

    /**
     * 实体名称
     *
     * @return 实体名称
     */
    String name() default "";

    /**
     * 实体编码
     *
     * @return 实体编码
     */
    String code();

    /**
     * 实体描述
     *
     * @return 实体描述
     */
    String description() default "";
}
