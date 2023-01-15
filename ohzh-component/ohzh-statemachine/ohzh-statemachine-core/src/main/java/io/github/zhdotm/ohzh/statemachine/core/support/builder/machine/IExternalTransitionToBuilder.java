package io.github.zhdotm.ohzh.statemachine.core.support.builder.machine;

import io.github.zhdotm.ohzh.statemachine.core.domain.ITransition;

/**
 * @author zhihao.mao
 */

public interface IExternalTransitionToBuilder<S, E, C, A> {

    ITransition<S, E, C, A> build();
}
