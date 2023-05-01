package io.github.zhdotm.ohzh.extension.starter.web.configuration;

import io.github.zhdotm.ohzh.extension.core.executor.IExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.executor.impl.ExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.register.IExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.register.impl.ExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.repository.IExtensionRepository;
import io.github.zhdotm.ohzh.extension.starter.web.processor.SpringExtensionProcessor;
import io.github.zhdotm.ohzh.extension.starter.web.repository.SpringExtensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拓展配置
 *
 * @author zhihao.mao
 */

@Configuration
public class SpringExtensionConfiguration {

    @Bean
    public SpringExtensionRepository extensionRepository() {

        return SpringExtensionRepository.getInstance();
    }

    @Bean
    @ConditionalOnBean(value = SpringExtensionRepository.class)
    public IExtensionRegister extensionRegister(@Autowired IExtensionRepository extensionRepository) {

        return ExtensionRegister.getInstance(extensionRepository);
    }

    @Bean
    @ConditionalOnBean(value = IExtensionRegister.class)
    public IExtensionExecutor extensionExecutor(@Autowired IExtensionRegister extensionRegister) {

        return ExtensionExecutor.getInstance(extensionRegister);
    }

    @Bean
    @ConditionalOnBean(value = SpringExtensionRepository.class)
    public SpringExtensionProcessor springExtensionProcessor(@Autowired SpringExtensionRepository extensionRepository) {

        return SpringExtensionProcessor.getInstance(extensionRepository);
    }
}
