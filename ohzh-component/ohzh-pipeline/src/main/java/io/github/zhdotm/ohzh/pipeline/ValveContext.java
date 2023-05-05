package io.github.zhdotm.ohzh.pipeline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 阀门上下文
 *
 * @author zhihao.mao
 */

@RequiredArgsConstructor
public class ValveContext<Input, Output> implements IValveContext<Input, Output> {

    @Getter
    private final String name;

    @Getter
    private final IPipeline<Input, Output> pipeline;

    @Getter
    private final IValve<Input, Output> valve;

    @Getter
    @Setter
    private IValveContext<Input, Output> before;

    @Getter
    @Setter
    private IValveContext<Input, Output> next;

    public static <Input, Output> ValveContext<Input, Output> create(String name, IPipeline<Input, Output> pipeline, IValve<Input, Output> valve) {

        return new ValveContext<>(name, pipeline, valve);
    }

}
