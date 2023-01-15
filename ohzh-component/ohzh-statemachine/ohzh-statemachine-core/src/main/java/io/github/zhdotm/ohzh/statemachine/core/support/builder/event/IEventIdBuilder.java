package io.github.zhdotm.ohzh.statemachine.core.support.builder.event;

import io.github.zhdotm.ohzh.statemachine.core.domain.IEvent;

/**
 * @author zhihao.mao
 */

public interface IEventIdBuilder<E> {

    IEvent<E> build();
}
