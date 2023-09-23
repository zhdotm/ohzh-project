package io.github.zhdotm.ohzh.event.core.domain;

import java.util.Iterator;

/**
 * 订阅者注册器
 *
 * @author zhihao.mao
 */

public interface ISubscriberRegistry {

    /**
     * 注册监听者
     *
     * @param listener 监听者
     */
    void register(IEventListener listener);

    /**
     * 取消注册监听者
     *
     * @param listener 监听者
     */
    void unregister(IEventListener listener);

    /**
     * 根据事件获取监听者
     *
     * @param event 事件
     * @return 监听者
     */
    Iterator<ISubscriber> getSubscribers(IEvent event);
}
