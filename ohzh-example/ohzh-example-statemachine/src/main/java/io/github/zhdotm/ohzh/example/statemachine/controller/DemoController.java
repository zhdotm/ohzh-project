package io.github.zhdotm.ohzh.example.statemachine.controller;

import io.github.zhdotm.ohzh.infrastructure.statemachine.builder.EventBuilder;
import io.github.zhdotm.ohzh.infrastructure.statemachine.builder.StateBuilder;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IState;
import io.github.zhdotm.ohzh.starter.statemachine.assistant.StateMachineAssistant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public IState test() {

        return StateMachineAssistant
                .getStateMachine("machine_id_001")
                .publishEvent(StateBuilder
                                .builder()
                                .id("begin_state_01")
                                .build()
                        , EventBuilder
                                .builder()
                                .id("event_003")
                                .payload("事件的载荷001")
                                .build());

    }
}
