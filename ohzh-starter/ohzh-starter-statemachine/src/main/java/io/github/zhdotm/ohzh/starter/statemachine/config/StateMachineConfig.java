package io.github.zhdotm.ohzh.starter.statemachine.config;

import io.github.zhdotm.ohzh.starter.statemachine.config.properties.StateMachineConfigProperties;
import io.github.zhdotm.ohzh.starter.statemachine.processor.StateMachineBeanPostProcessor;
import io.github.zhdotm.ohzh.starter.statemachine.runner.StateMachineApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 状态机配置
 *
 * @author zhihao.mao
 */
@Configuration
@ComponentScan(basePackages = {"io.github.zhdotm.ohzh.starter.statemachine.config"})
@ConfigurationPropertiesScan(basePackageClasses = StateMachineConfigProperties.class)
public class StateMachineConfig {

    @Bean
    public StateMachineBeanPostProcessor stateMachineBeanPostProcessor() {

        return new StateMachineBeanPostProcessor();
    }

    @Bean
    public StateMachineApplicationRunner stateMachineApplicationRunner(StateMachineConfigProperties stateMachineConfigProperties) {

        return new StateMachineApplicationRunner(stateMachineConfigProperties);
    }
}
