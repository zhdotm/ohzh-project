package io.github.zhdotm.ohzh.event.core.domain;


import java.time.LocalDateTime;

/**
 * 事件总线
 *
 * @author zhihao.mao
 */

public interface IEventBus {

    /**
     * 事件总线ID
     *
     * @return 事件总线ID
     */
    Number getEventBusId();

    /**
     * 事件总线名称
     *
     * @return 事件总线名称
     */
    String getEventBusName();

    /**
     * 事件总线描述
     *
     * @return 事件总线描述
     */
    String getDescription();

    /**
     * 创建时间
     *
     * @return 创建时间
     */
    LocalDateTime getGmtCreate();

    /**
     * 修改时间
     *
     * @return 修改时间
     */
    LocalDateTime getGmtModify();

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
     * 发布事件
     *
     * @param event 事件
     */
    <T> void post(IEvent<T> event);
}
