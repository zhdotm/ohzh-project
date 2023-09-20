package io.github.zhdotm.ohzh.event.core.domain.event;

/**
 * 事件类型
 *
 * @author zhihao.mao
 */

public interface IEventType {

    /**
     * 事件类型编码
     *
     * @return 事件类型编码
     */
    String getCode();

    /**
     * 事件类型描述
     *
     * @return 事件类型描述
     */
    String getDescription();
}
