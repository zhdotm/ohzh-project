package io.github.zhdotm.ohzh.starter.statemachine.runner;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import io.github.zhdotm.ohzh.infrastructure.statemachine.builder.EventBuilder;
import io.github.zhdotm.ohzh.infrastructure.statemachine.builder.StateBuilder;
import io.github.zhdotm.ohzh.infrastructure.statemachine.builder.StateMachineBuilder;
import io.github.zhdotm.ohzh.infrastructure.statemachine.builder.TransitionBuilder;
import io.github.zhdotm.ohzh.infrastructure.statemachine.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.*;
import io.github.zhdotm.ohzh.starter.statemachine.assistant.StateMachineAssistant;
import io.github.zhdotm.ohzh.starter.statemachine.config.properties.StateMachineConfigProperties;
import io.github.zhdotm.ohzh.starter.statemachine.config.properties.StateMachineProperties;
import io.github.zhdotm.ohzh.starter.statemachine.config.properties.TransitionProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

/**
 * 状态机组装器
 *
 * @author zhihao.mao
 */
@Slf4j
@AllArgsConstructor
public class StateMachineApplicationRunner implements ApplicationRunner {

    private final StateMachineConfigProperties stateMachineConfigProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<StateMachineProperties> stateMachinePropertiesList = stateMachineConfigProperties.getStateMachines();
        for (StateMachineProperties stateMachineProperties : stateMachinePropertiesList) {
            String stateMachineId = stateMachineProperties.getId();
            String stateMachineDescription = stateMachineProperties.getDescription();
            List<TransitionProperties> transitionPropertiesList = stateMachineProperties.getTransitions();
            List<ITransition> iTransitions = Lists.newArrayList();
            for (TransitionProperties transitionProperties : transitionPropertiesList) {
                String transitionId = transitionProperties.getId();
                String transitionDescription = transitionProperties.getDescription();
                TransitionTypeEnum type = transitionProperties.getType();
                Integer sort = transitionProperties.getSort();
                List<String> beginStateIds = transitionProperties.getBeginStateIds();
                IState[] beginStates = beginStateIds
                        .stream()
                        .map(stateId -> StateBuilder
                                .builder()
                                .id(stateId)
                                .build())
                        .toArray(IState[]::new);
                String endStateId = transitionProperties.getEndStateId();
                IState endState = null;
                if (type == TransitionTypeEnum.EXTERNAL) {
                    endState = StateBuilder
                            .builder()
                            .id(endStateId)
                            .build();
                }
                String eventId = transitionProperties.getEventId();
                IEvent event = EventBuilder
                        .builder()
                        .id(eventId)
                        .build();
                String cacheKey = StateMachineAssistant.getCacheKey(stateMachineId, transitionId);
                ICondition condition = StateMachineAssistant.getCondition(cacheKey);
                IAction action = StateMachineAssistant.getAction(cacheKey);

                ITransition iTransition = null;
                switch (type) {
                    case EXTERNAL: {
                        iTransition = TransitionBuilder
                                .builder()
                                .id(transitionId)
                                .description(transitionDescription)
                                .sort(sort)
                                .external()
                                .from(beginStates)
                                .to(endState)
                                .on(condition)
                                .when(event)
                                .perform(action)
                                .build();
                        break;
                    }
                    case INTERNAL: {
                        iTransition = TransitionBuilder
                                .builder()
                                .id(transitionId)
                                .description(transitionDescription)
                                .internal()
                                .from(beginStates)
                                .on(condition)
                                .when(event)
                                .perform(action)
                                .build();
                        break;
                    }
                    default: {
                        log.warn("未知转换类型: {}", type);
                    }
                }
                if (ObjectUtil.isNotEmpty(iTransition)) {

                    iTransitions.add(iTransition);
                }
            }

            IStateMachine iStateMachine = StateMachineBuilder
                    .builder()
                    .id(stateMachineId)
                    .description(stateMachineDescription)
                    .addTransitions(iTransitions.toArray(new ITransition[0]))
                    .build();
            StateMachineAssistant.addStateMachine(stateMachineId, iStateMachine);
        }
    }

}
