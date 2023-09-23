package io.github.zhdotm.ohzh.event.core.domain;

/**
 * 事件流
 * 流是系统中单个对象的有序事件集合。
 *
 * @author zhihao.mao
 */

public interface IEventStream {

    /**
     * 事件流ID
     *
     * @return 事件流ID
     */
    Number getStreamId();

    /**
     * 事件流类型
     *
     * @return 事件流类型
     */
    IEventStreamType getStreamType();

    /**
     * 流位置
     *
     * @return 流位置
     */
    Number getStreamPos();
}
