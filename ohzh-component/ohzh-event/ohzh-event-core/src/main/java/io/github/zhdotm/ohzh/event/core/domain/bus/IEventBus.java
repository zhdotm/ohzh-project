package io.github.zhdotm.ohzh.event.core.domain.bus;


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
     * 创建事件
     *
     * @return 创建事件
     */
    LocalDateTime getGmtCreate();

    /**
     * 修改时间
     *
     * @return 修改时间
     */
    LocalDateTime getGmtModify();
    
}
