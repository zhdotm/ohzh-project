package io.github.zhdotm.ohzh.event.core.domain;

/**
 * 订阅者
 *
 * @author zhihao.mao
 */

public interface ISubscriber {

    void dispatchEvent(IEvent event);

}
