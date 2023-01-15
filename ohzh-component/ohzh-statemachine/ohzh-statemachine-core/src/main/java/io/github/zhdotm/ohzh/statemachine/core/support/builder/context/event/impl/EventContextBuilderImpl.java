package io.github.zhdotm.ohzh.statemachine.core.support.builder.context.event.impl;

import io.github.zhdotm.ohzh.statemachine.core.domain.impl.EventContextImpl;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.context.event.IEventContextBuilder;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.context.event.IEventContextFromBuilder;

/**
 * @author zhihao.mao
 */

public class EventContextBuilderImpl<S, E> implements IEventContextBuilder<S, E> {

    public static <S, E> EventContextBuilderImpl<S, E> getInstance() {

        return new EventContextBuilderImpl<>();
    }

    @Override
    public IEventContextFromBuilder<S, E> from(S stateId) {
        EventContextImpl<S, E> eventContext = EventContextImpl.getInstance();
        eventContext.from(stateId);

        return EventContextFromBuilderImpl.getInstance(eventContext);
    }

}
