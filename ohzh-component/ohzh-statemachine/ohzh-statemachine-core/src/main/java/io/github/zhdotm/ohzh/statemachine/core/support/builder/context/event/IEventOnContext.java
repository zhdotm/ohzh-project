package io.github.zhdotm.ohzh.statemachine.core.support.builder.context.event;

import io.github.zhdotm.ohzh.statemachine.core.domain.IEventContext;

/**
 * @author zhihao.mao
 */

public interface IEventOnContext<S, E> {

    IEventContext<S, E> build();
}
