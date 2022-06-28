package io.github.zhdotm.ohzh.starter.statemachine.config.properties;

import lombok.Data;

import java.util.List;

/**
 * @author zhihao.mao
 */
@Data
public class StateMachineProperties {

    /**
     * 状态机ID
     */
    private String id;

    /**
     * 状态机描述
     */
    private String description;

    /**
     * 转换
     */
    private List<TransitionProperties> transitions;
}
