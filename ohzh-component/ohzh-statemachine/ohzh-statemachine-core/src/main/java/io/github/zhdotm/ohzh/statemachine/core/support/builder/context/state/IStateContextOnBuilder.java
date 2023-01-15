package io.github.zhdotm.ohzh.statemachine.core.support.builder.context.state;

/**
 * @author zhihao.mao
 */

public interface IStateContextOnBuilder<S, E> {

    IStateContextToBuilder<S, E> to(S stateId);
}
