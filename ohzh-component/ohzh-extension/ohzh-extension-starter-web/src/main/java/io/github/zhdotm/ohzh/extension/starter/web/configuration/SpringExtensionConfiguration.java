package io.github.zhdotm.ohzh.extension.starter.web.configuration;

import io.github.zhdotm.ohzh.extension.core.executor.IExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.executor.impl.ExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.register.IExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.register.impl.ExtensionRegister;
import io.github.zhdotm.ohzh.extension.starter.web.processor.SpringExtensionProcessor;
import io.github.zhdotm.ohzh.extension.starter.web.repository.SpringExtensionRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 拓展配置
 *
 * @author zhihao.mao
 */

@EnableAutoConfiguration
public class SpringExtensionConfiguration {

    @Bean
    public static SpringExtensionProcessor springExtensionProcessor() {

        return SpringExtensionProcessor.getInstance(SpringExtensionRepository.getInstance());
    }

    @Bean
    public SpringExtensionRepository extensionRepository() {

        return SpringExtensionRepository.getInstance();
    }

    @Bean
    public IExtensionRegister extensionRegister() {

        return ExtensionRegister.getInstance(SpringExtensionRepository.getInstance());
    }

    @Bean
    public IExtensionExecutor extensionExecutor() {

        return ExtensionExecutor.getInstance(ExtensionRegister.getInstance());
    }

}
