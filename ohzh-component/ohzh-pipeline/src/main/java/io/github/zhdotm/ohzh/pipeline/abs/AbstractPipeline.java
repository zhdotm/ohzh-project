package io.github.zhdotm.ohzh.pipeline.abs;

import io.github.zhdotm.ohzh.pipeline.IPipeline;
import io.github.zhdotm.ohzh.pipeline.IValve;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽象管道
 *
 * @param <Input>  输入
 * @param <Output> 输出
 * @author zhihao.mao
 */

public abstract class AbstractPipeline<Input, TempOutput, Output> implements IPipeline<Input, TempOutput, Output> {

    @Getter
    @Setter
    private IValve<Input, TempOutput, Output> head;

    @Getter
    @Setter
    private IValve<Input, TempOutput, Output> tail;

}
