package io.github.zhdotm.ohzh.sieve.starter.web.getter;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.sieve.core.getter.value.ISieveValueGetter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author zhihao.mao
 */

public interface ISpringSieveValueGetter extends ISieveValueGetter, BeanNameGenerator {

    @Override
    default String getName() {

        return StrUtil.lowerFirst(ClassUtil.getClassName(this, Boolean.TRUE));
    }

    @Override
    default String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        return getName();
    }

}
