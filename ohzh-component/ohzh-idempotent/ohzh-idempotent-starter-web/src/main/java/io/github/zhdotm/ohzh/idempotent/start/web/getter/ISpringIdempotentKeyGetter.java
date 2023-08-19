package io.github.zhdotm.ohzh.idempotent.start.web.getter;

import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author zhihao.mao
 */

public interface ISpringIdempotentKeyGetter extends IIdempotentKeyGetter, BeanNameGenerator {

    @Override
    default String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        return getName();
    }

}
