package io.github.zhdotm.ohzh.statemachine.core.support.builder.context.state;

/**
 * @author zhihao.mao
 */

public interface IStateContextToBuilder<S, E> {

    IStateRetContext<S, E> ret(Object obj);
}
