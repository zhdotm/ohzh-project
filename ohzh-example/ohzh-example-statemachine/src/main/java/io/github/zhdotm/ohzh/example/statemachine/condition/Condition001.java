package io.github.zhdotm.ohzh.example.statemachine.condition;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.ICondition;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IEvent;
import io.github.zhdotm.ohzh.starter.statemachine.annotation.Condition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhihao.mao
 */
@Slf4j
@Condition(stateMachineId = "machine_id_001", transitionId = "transition_001")
@Component
public class Condition001 implements ICondition {
    @Override
    public Boolean isAllowed(IEvent event) {
        log.info("条件001接收到事件: {}", JSONUtil.toJsonStr(event));

        return Boolean.TRUE;
    }

    @Override
    public String getId() {

        return "condition_001";
    }
}
