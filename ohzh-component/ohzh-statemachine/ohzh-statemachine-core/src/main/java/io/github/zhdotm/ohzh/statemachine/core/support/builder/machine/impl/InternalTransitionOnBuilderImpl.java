package io.github.zhdotm.ohzh.statemachine.core.support.builder.machine.impl;

import io.github.zhdotm.ohzh.statemachine.core.domain.IEventContext;
import io.github.zhdotm.ohzh.statemachine.core.domain.ITransition;
import io.github.zhdotm.ohzh.statemachine.core.domain.impl.ConditionImpl;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.machine.IInternalTransitionOnBuilder;
import io.github.zhdotm.ohzh.statemachine.core.support.builder.machine.IInternalTransitionWhenBuilder;
import lombok.NonNull;

import java.util.function.Function;

/**
 * @author zhihao.mao
 */

public class InternalTransitionOnBuilderImpl<S, E, C, A> implements IInternalTransitionOnBuilder<S, E, C, A> {

    private ITransition<S, E, C, A> transition;

    public static <S, E, C, A> InternalTransitionOnBuilderImpl<S, E, C, A> getInstance(@NonNull ITransition<S, E, C, A> transition) {
        InternalTransitionOnBuilderImpl<S, E, C, A> transitionOnBuilder = new InternalTransitionOnBuilderImpl<>();
        transitionOnBuilder.transition = transition;

        return transitionOnBuilder;
    }

    @Override
    public IInternalTransitionWhenBuilder<S, E, C, A> when(@NonNull C conditionId, @NonNull Function<IEventContext<S, E>, Boolean> check) {
        ConditionImpl<S, E, C> condition = ConditionImpl.getInstance();
        condition.conditionId(conditionId)
                .check(check);
        transition.when(condition);

        return InternalTransitionWhenBuilderImpl.getInstance(transition);
    }

}
