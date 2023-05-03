package io.github.zhdotm.ohzh.pipeline.abs;

import io.github.zhdotm.ohzh.pipeline.IValve;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽象阀门
 *
 * @author zhihao.mao
 */

public abstract class AbstractValve<Input, TempOutput, Output> implements IValve<Input, TempOutput, Output> {

    @Getter
    @Setter
    private IValve<Input, TempOutput, Output> next;

}
