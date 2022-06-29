package io.github.zhdotm.ohzh.example.statemachine.action;

import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IAction;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IEvent;
import io.github.zhdotm.ohzh.starter.statemachine.annotation.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 动作001
 *
 * @author zhihao.mao
 */
@Slf4j
@Action(stateMachineId = "machine_id_001", transitionId = "transition_004")
@Component
public class Action004 implements IAction {

    @Override
    public void onEvent(IEvent event) {
        log.info("动作004接受到事件: {}, {}", event.getId(), event.getPayload());
    }

    @Override
    public String getId() {
        return "action_004";
    }
}
