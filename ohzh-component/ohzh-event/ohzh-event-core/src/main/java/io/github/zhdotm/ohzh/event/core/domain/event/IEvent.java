package io.github.zhdotm.ohzh.event.core.domain.event;

import java.time.LocalDateTime;

/**
 * 事件
 *
 * @author zhihao.mao
 */

public interface IEvent {

    /**
     * 事件ID
     *
     * @return 事件ID
     */
    Number getEventId();

    /**
     * 事件流ID
     *
     * @return 事件流ID
     */
    Number getStreamId();

    /**
     * 事件类型
     *
     * @return 事件类型
     */
    IEventType getEventType();

    /**
     * 流位置（用时间戳）
     *
     * @return 流位置
     */
    Number getStreamPos();

    /**
     * 事件发生时间
     *
     * @return 事件发生时间
     */
    LocalDateTime getWhen();

    /**
     * 事件内容
     *
     * @return 事件内容
     */
    String getBody();
}

