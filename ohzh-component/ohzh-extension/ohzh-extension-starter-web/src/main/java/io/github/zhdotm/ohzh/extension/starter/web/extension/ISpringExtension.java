package io.github.zhdotm.ohzh.extension.starter.web.extension;

import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * spring拓展
 *
 * @author zhihao.mao
 */

public interface ISpringExtension extends IExtension, BeanNameGenerator {

    @Override
    default String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {

        return getCode();
    }

    @Override
    default Extension getExtensionAnnotation() {

        return AnnotatedElementUtils.getMergedAnnotation(this.getClass(), Extension.class);
    }
    
}
