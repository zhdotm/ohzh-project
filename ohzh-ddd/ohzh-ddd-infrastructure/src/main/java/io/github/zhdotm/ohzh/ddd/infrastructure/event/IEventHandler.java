package io.github.zhdotm.ohzh.ddd.infrastructure.event;


import java.util.List;

/**
 * 事件处理器
 *
 * @author zhihao.mao
 */

public interface IEventHandler {

    /**
     * 处理事件
     *
     * @param events 事件
     * @param <T>    事件类型
     */
    <T extends IEvent> void onEvents(List<T> events);

}
