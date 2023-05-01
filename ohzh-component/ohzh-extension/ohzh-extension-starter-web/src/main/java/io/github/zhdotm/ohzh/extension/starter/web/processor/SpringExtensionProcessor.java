package io.github.zhdotm.ohzh.extension.starter.web.processor;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.extension.starter.web.annotation.SpringExtension;
import io.github.zhdotm.ohzh.extension.starter.web.exception.SpringExtensionException;
import io.github.zhdotm.ohzh.extension.starter.web.exception.SpringExtensionExceptionEnum;
import io.github.zhdotm.ohzh.extension.starter.web.extension.ISpringExtension;
import io.github.zhdotm.ohzh.extension.starter.web.repository.SpringExtensionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.function.Supplier;

/**
 * spring拓展后置处理器
 *
 * @author zhihao.mao
 */

public class SpringExtensionProcessor implements BeanPostProcessor {

    private static SpringExtensionProcessor springExtensionProcessor;

    private final SpringExtensionRepository springExtensionRepository;

    private SpringExtensionProcessor(SpringExtensionRepository springExtensionRepository) {
        this.springExtensionRepository = springExtensionRepository;
    }

    public static synchronized SpringExtensionProcessor getInstance(SpringExtensionRepository springExtensionRepository) {
        if (ObjectUtil.isEmpty(springExtensionProcessor)) {
            springExtensionProcessor = new SpringExtensionProcessor(springExtensionRepository);
        }

        return springExtensionProcessor;
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (AnnotationUtil.hasAnnotation(bean.getClass(), SpringExtension.class)) {
            Assert.isTrue(bean instanceof ISpringExtension, (Supplier<Throwable>) () -> new SpringExtensionException(SpringExtensionExceptionEnum.ANNOTATION_SPRINGEXTENSION_ILLEGAL.getCode(), SpringExtensionExceptionEnum.ANNOTATION_SPRINGEXTENSION_ILLEGAL.getMessage(beanName)));
            ISpringExtension springExtension = (ISpringExtension) bean;
            springExtensionRepository.innerPut(springExtension);
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
