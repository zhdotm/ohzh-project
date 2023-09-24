package io.github.zhdotm.ohzh.event.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhihao.mao
 */

@Getter
@AllArgsConstructor
public enum EventExtraEnum {

    /**
     * 事件额外属性
     */
    EVENT_BUS_ID("eventBusId", "事件总线ID"),
    EVENT_RULE_ID("eventRuleId", "事件规则ID"),
    EVENT_MESSAGE_ID("eventMessageId", "事件消息ID"),
    EVENT_POSITION("eventPosition", "事件位置"),
    EVENT_SOURCE("eventSource", "事件源"),
    EVENT_TARGET("eventTarget", "事件目标"),
    ;

    private final String code;

    private final String description;
}
