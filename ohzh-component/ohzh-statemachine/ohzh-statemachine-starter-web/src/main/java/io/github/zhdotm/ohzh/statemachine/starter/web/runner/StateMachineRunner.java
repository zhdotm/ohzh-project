package io.github.zhdotm.ohzh.statemachine.starter.web.runner;

import io.github.zhdotm.ohzh.statemachine.core.domain.IStateMachine;
import io.github.zhdotm.ohzh.statemachine.core.domain.ITransition;
import io.github.zhdotm.ohzh.statemachine.core.support.StateMachineFactory;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.machine.IStateMachineBuilder;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ISpringTransition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;
import io.github.zhdotm.ohzh.statemachine.starter.web.support.StateMachineSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhihao.mao
 */

@Slf4j
public class StateMachineRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, List<ITransition<String, String, String, String>>> stateMachineIdTransitionsMap = getStateMachineIdTransitionsMap();

        stateMachineIdTransitionsMap.forEach((stateMachineId, transitions) -> {
            IStateMachineBuilder<String, String, String, String, String> stateMachineBuilder = StateMachineFactory.create();
            stateMachineBuilder.transitions(transitions);
            IStateMachine<String, String, String, String, String> stateMachine = stateMachineBuilder.build(stateMachineId);

            StateMachineSupport.registerStateMachine(stateMachine);
        });
    }

    private Map<String, List<ITransition<String, String, String, String>>> getStateMachineIdTransitionsMap() {
        Map<String, List<ITransition<String, String, String, String>>> stateMachineIdTransitionsMap = new HashMap<>();

        ConfigurableListableBeanFactory beanFactory = StateMachineSupport.getBeanFactory();
        Map<String, Object> beansWithAnnotation = beanFactory.getBeansWithAnnotation(StateMachineTransition.class);
        for (Object bean : beansWithAnnotation.values()) {
            ISpringTransition transitionAdapter = (ISpringTransition) bean;
            String stateMachineId = transitionAdapter.getStateMachineId();
            List<ITransition<String, String, String, String>> transitions = stateMachineIdTransitionsMap.getOrDefault(stateMachineId, new ArrayList<>());
            ITransition<String, String, String, String> transition = transitionAdapter.getTransition();
            transitions.add(transition);
            stateMachineIdTransitionsMap.put(stateMachineId, transitions);
        }

        return stateMachineIdTransitionsMap;
    }

}
