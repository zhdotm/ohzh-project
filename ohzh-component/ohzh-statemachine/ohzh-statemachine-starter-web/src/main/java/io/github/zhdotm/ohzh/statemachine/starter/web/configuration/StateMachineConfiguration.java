package io.github.zhdotm.ohzh.statemachine.starter.web.configuration;

import io.github.zhdotm.ohzh.statemachine.starter.web.processor.StateMachineProcessor;
import io.github.zhdotm.ohzh.statemachine.starter.web.runner.StateMachineRunner;
import io.github.zhdotm.ohzh.statemachine.starter.web.support.StateMachineSupport;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author zhihao.mao
 */

@EnableAutoConfiguration
public class StateMachineConfiguration {

    @Bean
    public static StateMachineProcessor stateMachineProcessor() {

        return new StateMachineProcessor();
    }

    @Bean
    public static StateMachineSupport stateMachineSupport() {

        return new StateMachineSupport();
    }

    @Bean
    public StateMachineRunner stateMachineRunner() {

        return new StateMachineRunner();
    }

}
