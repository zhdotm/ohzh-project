package io.github.zhdotm.ohzh.idempotent.start.web.handler;

import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author zhihao.mao
 */

public interface ISpringIdempotentHandler extends IIdempotentHandler, BeanNameGenerator {

    @Override
    default String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        return getName();
    }

}
