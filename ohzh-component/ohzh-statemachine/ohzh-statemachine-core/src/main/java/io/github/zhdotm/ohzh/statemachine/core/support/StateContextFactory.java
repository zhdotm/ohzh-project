package io.github.zhdotm.ohzh.statemachine.core.support;

import io.github.zhdotm.ohzh.statemachine.core.support.builder.context.state.IStateContextBuilder;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.context.state.impl.StateContextBuilderImpl;

/**
 * @author zhihao.mao
 */

public class StateContextFactory {

    public static <S, E> IStateContextBuilder<S, E> create() {

        return StateContextBuilderImpl.getInstance();
    }
}
