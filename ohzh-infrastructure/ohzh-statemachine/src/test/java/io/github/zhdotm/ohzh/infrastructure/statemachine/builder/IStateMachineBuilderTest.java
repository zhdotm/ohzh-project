package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;


import io.github.zhdotm.ohzh.infrastructure.statemachine.model.*;
import org.junit.Test;


public class IStateMachineBuilderTest {

    @Test
    public void test() {
        IState beginState1 = StateBuilder
                .builder()
                .id("state:before:001")
                .description("转换前状态1")
                .build();
        IState beginState2 = StateBuilder
                .builder()
                .id("state:before:002")
                .description("转换前状态2")
                .build();

        IState endState1 = StateBuilder
                .builder()
                .id("state:after:001")
                .description("转换后状态1")
                .build();

        ICondition condition1 = ConditionBuilder
                .builder()
                .description("001一律允许的判断条件")
                .id("condition:001")
                .isAllowed(event -> {
                    String payload = event.getPayload();
                    System.out.println("001条件组件获取到事件荷载: " + payload);

                    return Boolean.TRUE;
                })
                .build();

        ICondition condition2 = ConditionBuilder
                .builder()
                .description("002一律不允许的判断条件")
                .id("condition:002")
                .isAllowed(event -> {
                    String payload = event.getPayload();
                    System.out.println("002条件组件获取到事件荷载: " + payload);

                    return Boolean.FALSE;
                })
                .build();

        IEvent event1 = EventBuilder
                .builder()
                .id("event:001")
                .description("001号事件")
                .payload("这是一个事件荷载001")
                .build();

        IEvent event2 = EventBuilder
                .builder()
                .id("event:002")
                .description("002号事件")
                .payload("这是一个事件荷载002")
                .build();

        IAction action1 = ActionBuilder
                .builder()
                .id("action:001")
                .description("001号动作")
                .onEvent(event -> {
                    String payload = event.getPayload();
                    System.out.println("001号动作组件获取到事件荷载: " + payload);
                })
                .build();

        IAction action2 = ActionBuilder
                .builder()
                .id("action:002")
                .description("002号动作")
                .onEvent(event -> {
                    String payload = event.getPayload();
                    System.out.println("002号动作组件获取到事件荷载: " + payload);
                })
                .build();

        ITransition transition1 = TransitionBuilder
                .builder()
                .id("transition:001")
                .description("001号转换组件")
                .external()
                .from(beginState1, beginState2)
                .to(endState1)
                .on(condition1)
                .when(event1)
                .perform(action1)
                .build();

        ITransition transition2 = TransitionBuilder
                .builder()
                .id("transition:002")
                .description("002号转换组件")
                .external()
                .from(beginState1, beginState2)
                .to(endState1)
                .on(condition2)
                .when(event2)
                .perform(action2)
                .build();

        IStateMachine stateMachine = StateMachineBuilder
                .builder()
                .id("stateMachine:001")
                .description("001号状态机")
                .addTransitions(transition1, transition1)
                .build();
        stateMachine.publishEvent(beginState1, event2);
    }

}