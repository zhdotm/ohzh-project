package io.github.zhdotm.ohzh.statemachine.starter.web.configuration;

import io.github.zhdotm.ohzh.statemachine.starter.web.configuration.properties.StateMachineProperties;
import io.github.zhdotm.ohzh.statemachine.starter.web.mq.consumer.rocketmq.RocketMQEventConsumer;
import io.github.zhdotm.ohzh.statemachine.starter.web.mq.producer.rocketmq.RocketMQEventProducer;
import io.github.zhdotm.ohzh.statemachine.starter.web.processor.StateMachineProcessor;
import io.github.zhdotm.ohzh.statemachine.starter.web.runner.StateMachineRunner;
import io.github.zhdotm.ohzh.statemachine.starter.web.support.StateMachineSupport;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author zhihao.mao
 */

@EnableAutoConfiguration
@Import(StateMachineProperties.class)
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

    @ConditionalOnProperty(prefix = "ohzh.statemachine", name = "scope", havingValue = "remote")
    @Bean
    public RocketMQEventProducer eventProducer() {

        return new RocketMQEventProducer();
    }

    @ConditionalOnProperty(prefix = "ohzh.statemachine", name = "scope", havingValue = "remote")
    @Bean
    public RocketMQEventConsumer eventConsumer() {

        return new RocketMQEventConsumer();
    }

}
