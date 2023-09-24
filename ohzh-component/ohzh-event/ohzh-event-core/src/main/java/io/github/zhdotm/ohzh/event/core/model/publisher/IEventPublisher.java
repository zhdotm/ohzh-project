package io.github.zhdotm.ohzh.event.core.model.publisher;

import io.github.zhdotm.ohzh.event.core.model.event.IEvent;

/**
 * @author zhihao.mao
 */

public interface IEventPublisher {

    /**
     * 发布事件
     *
     * @param event 事件
     */
    void post(IEvent event);

}
