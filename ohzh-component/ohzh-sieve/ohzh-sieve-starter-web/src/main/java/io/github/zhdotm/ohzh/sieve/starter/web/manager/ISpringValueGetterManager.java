package io.github.zhdotm.ohzh.sieve.starter.web.manager;

import io.github.zhdotm.ohzh.sieve.core.manager.IValueGetterManager;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author zhihao.mao
 */

public interface ISpringValueGetterManager extends IValueGetterManager, BeanNameGenerator {

    String NAME = "springValueGetterManager";

    @Override
    default String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        return NAME;
    }

}
