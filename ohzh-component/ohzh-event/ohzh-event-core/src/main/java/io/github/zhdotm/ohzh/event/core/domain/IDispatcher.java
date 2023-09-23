package io.github.zhdotm.ohzh.event.core.domain;

import java.util.Iterator;

/**
 * 调度
 *
 * @author zhihao.mao
 */

public interface IDispatcher {

    void dispatch(IEvent event, Iterator<ISubscriber> subscribers);

}
