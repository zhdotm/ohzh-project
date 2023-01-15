package io.github.zhdotm.ohzh.ddd.domain.aggregate.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 聚合根
 * <p>
 * 聚合根是实体，有实体的特点，具有全局唯一标识，有独立的生命周期。
 * 一个聚合只有一个聚合根，聚合根在聚合内对实体和值对象采用直接对象引用的方式进行组织和协调，
 * 聚合根与聚合根之间通过 ID 关联的方式实现聚合之间的协同。
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public @interface AggregateRoot {

    /**
     * 聚合根名称
     *
     * @return 聚合根名称
     */
    String name() default "";

    /**
     * 聚合根编码
     *
     * @return 聚合根编码
     */
    @AliasFor(annotation = Component.class, attribute = "value")
    String code();

    /**
     * 聚合根描述
     *
     * @return 聚合根描述
     */
    String description() default "";

}
