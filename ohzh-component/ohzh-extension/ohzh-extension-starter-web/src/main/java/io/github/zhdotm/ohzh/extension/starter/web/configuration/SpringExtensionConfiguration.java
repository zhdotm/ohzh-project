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

    private final SpringExtensionRepository extensionRepository;
    private final IExtensionRegister extensionRegister;
    private final IExtensionExecutor extensionExecutor;
    private final SpringExtensionProcessor springExtensionProcessor;

    public SpringExtensionConfiguration() {
        extensionRepository = SpringExtensionRepository.getInstance();
        extensionRegister = ExtensionRegister.getInstance(extensionRepository);
        extensionExecutor = ExtensionExecutor.getInstance(extensionRegister);
        springExtensionProcessor = SpringExtensionProcessor.getInstance(extensionRepository);
    }

    @Bean
    public SpringExtensionProcessor springExtensionProcessor() {

        return springExtensionProcessor;
    }

    @Bean
    public SpringExtensionRepository extensionRepository() {

        return extensionRepository;
    }

    @Bean
    public IExtensionRegister extensionRegister() {

        return extensionRegister;
    }

    @Bean
    public IExtensionExecutor extensionExecutor() {

        return extensionExecutor;
    }

}
