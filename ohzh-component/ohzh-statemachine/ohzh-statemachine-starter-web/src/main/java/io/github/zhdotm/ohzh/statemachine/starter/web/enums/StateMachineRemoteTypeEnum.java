package io.github.zhdotm.ohzh.statemachine.starter.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum StateMachineRemoteTypeEnum {

    /**
     * 状态机远程类型
     */
    ROECKTMQ("roecktmq", "roecktmq"),
    ;

    @Getter
    private final String code;

    @Getter
    private final String description;

}
