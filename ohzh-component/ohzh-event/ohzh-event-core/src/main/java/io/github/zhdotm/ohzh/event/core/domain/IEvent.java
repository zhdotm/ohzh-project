package io.github.zhdotm.ohzh.event.core.domain;

import java.time.LocalDateTime;

/**
 * 事件（toppic = busName + eventType，tag = streamId ）
 *
 * @author zhihao.mao
 */

public interface IEvent<T> {

    /**
     * 唯一的事件标识符
     *
     * @return 事件ID
     */
    Number getEventId();

    /**
     * 事件的类型，如“开户事件”。
     *
     * @return 事件类型
     */
    IEventType getEventType();

    /**
     * 事件流的唯一标识符，如账户ID。在DDD中，通常是一个领域上下文的聚合根。
     *
     * @return 事件流ID
     */
    Number getStreamId();

    /**
     * 表示事件在流中的位置，递增编号即可（消息队列的offset）
     *
     * @return 流位置
     */
    Long getStreamPos();

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
    T getBody();
}

