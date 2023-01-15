package io.github.zhdotm.ohzh.statemachine.core.support.builder.event.impl;

import io.github.zhdotm.ohzh.statemachine.core.domain.IEvent;
import io.github.zhdotm.ohzh.statemachine.core.domain.impl.EventImpl;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.event.IEventIdBuilder;
import lombok.AllArgsConstructor;

/**
 * @author zhihao.mao
 */

@AllArgsConstructor
public class EventIdBuilderImpl<E> implements IEventIdBuilder<E> {

    private final EventImpl<E> event;

    public static <E> EventIdBuilderImpl<E> getInstance(EventImpl<E> event) {

        return new EventIdBuilderImpl<>(event);
    }

    @Override
    public IEvent<E> build() {

        return event;
    }

}
