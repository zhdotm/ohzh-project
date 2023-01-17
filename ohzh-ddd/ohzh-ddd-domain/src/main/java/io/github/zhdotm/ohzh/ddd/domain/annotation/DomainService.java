package io.github.zhdotm.ohzh.ddd.domain.annotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 领域服务
 * <p>
 * 跨实体的业务逻辑代码在领域服务中实现
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public @interface DomainService {

    /**
     * 领域服务名称
     *
     * @return 领域服务名称
     */
    String name() default "";

    /**
     * 领域服务编码
     *
     * @return 领域服务编码
     */
    @AliasFor(annotation = Service.class, attribute = "value")
    String code();

    /**
     * 聚合根描述
     *
     * @return 领域服务描述
     */
    String description() default "";

}
