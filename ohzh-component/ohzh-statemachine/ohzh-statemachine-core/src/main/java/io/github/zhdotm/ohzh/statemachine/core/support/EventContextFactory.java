package io.github.zhdotm.ohzh.statemachine.core.support;

import io.github.zhdotm.ohzh.statemachine.core.support.builder.context.event.IEventContextBuilder;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.context.event.impl.EventContextBuilderImpl;

/**
 * @author zhihao.mao
 */

public class EventContextFactory {

    public static <S, E> IEventContextBuilder<S, E> create() {

        return EventContextBuilderImpl.getInstance();
    }
}
