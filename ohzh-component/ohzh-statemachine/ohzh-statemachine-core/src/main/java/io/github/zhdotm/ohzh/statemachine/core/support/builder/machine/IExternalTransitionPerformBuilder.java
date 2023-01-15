package io.github.zhdotm.ohzh.statemachine.core.support.builder.machine;

/**
 * @author zhihao.mao
 */

public interface IExternalTransitionPerformBuilder<S, E, C, A> {

    IExternalTransitionToBuilder<S, E, C, A> to(S stateId);
}
