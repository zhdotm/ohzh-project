package io.github.zhdotm.ohzh.event.core.model.event;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.event.core.enums.EventExtraEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 事件
 *
 * @author zhihao.mao
 */

public interface IEvent {

    /**
     * 唯一的事件标识符
     *
     * @return 事件ID
     */
    Number getEventId();

    /**
     * 事件主题
     *
     * @return 事件主题
     */
    String getSubject();

    /**
     * 表示事件发生的时间
     *
     * @return 事件发生时间
     */
    LocalDateTime getWhen();

    /**
     * 通常存放处理该事件，所需要的上下文数据
     *
     * @return 事件内容
     */
    <T> T getData();

    /**
     * 额外属性
     *
     * @return 额外属性
     */
    Map<String, String> getExtraProperties();

    /**
     * 事件总线ID
     *
     * @return 事件总线ID
     */
    default String getEventBusId() {

        return getExtraProperties().get(EventExtraEnum.EVENT_BUS_ID.getCode());
    }

    /**
     * 事件规则ID
     *
     * @return 事件规则ID
     */
    default String getEventRuleId() {

        return getExtraProperties().get(EventExtraEnum.EVENT_RULE_ID.getCode());
    }

    /**
     * 事件消息ID
     *
     * @return 事件消息ID
     */
    default String getEventMessageId() {

        return getExtraProperties().get(EventExtraEnum.EVENT_MESSAGE_ID.getCode());
    }

    /**
     * 事件位置
     *
     * @return 事件位置
     */
    default String getEventPosition() {

        return getExtraProperties().get(EventExtraEnum.EVENT_POSITION.getCode());
    }

    /**
     * 事件源
     *
     * @return 事件源
     */
    default String getEventSource() {

        return getExtraProperties().get(EventExtraEnum.EVENT_SOURCE.getCode());
    }

    /**
     * 事件目标
     *
     * @return 事件目标
     */
    default List<String> getEventTarget() {
        String eventTargetsStr = getExtraProperties().get(EventExtraEnum.EVENT_TARGET.getCode());
        if (StrUtil.isBlank(eventTargetsStr)) {

            return ListUtil.empty();
        }

        return JSONUtil.toList(eventTargetsStr, String.class);
    }

}

