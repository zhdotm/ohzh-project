package io.github.zhdotm.ohzh.event.core.model.subscriber;

import io.github.zhdotm.ohzh.event.core.model.event.IEvent;

import java.util.List;

/**
 * 订阅者
 *
 * @author zhihao.mao
 */

public interface IEventSubscriber {

    /**
     * 事件总线ID
     *
     * @return 事件总线ID
     */
    String getEventBusId();

    /**
     * 获取主题
     *
     * @return 主题
     */
    String getSubject();

    /**
     * 收到事件
     *
     * @param events          事件
     * @param acknowledgement 确认
     */
    void onEvent(List<IEvent> events, Acknowledgement acknowledgement);

}
