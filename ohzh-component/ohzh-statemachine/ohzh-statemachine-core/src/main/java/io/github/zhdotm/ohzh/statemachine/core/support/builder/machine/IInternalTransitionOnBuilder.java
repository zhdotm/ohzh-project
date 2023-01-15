package io.github.zhdotm.ohzh.statemachine.core.support.builder.machine;

import io.github.zhdotm.ohzh.statemachine.core.domain.IEventContext;

import java.util.function.Function;

/**
 * @author zhihao.mao
 */

public interface IInternalTransitionOnBuilder<S, E, C, A> {

    IInternalTransitionWhenBuilder<S, E, C, A> when(C conditionId, Function<IEventContext<S, E>, Boolean> check);

}
