package io.github.zhdotm.ohzh.pipeline.starter.web.adapter;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.pipeline.core.IValve;
import io.github.zhdotm.ohzh.pipeline.core.exception.PipelineException;
import io.github.zhdotm.ohzh.pipeline.core.exception.PipelineExceptionEnum;
import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.Valve;
import lombok.SneakyThrows;

import java.util.function.Supplier;

/**
 * 阀门
 *
 * @author zhihao.mao
 */

@FunctionalInterface
public interface ISpringValve<Input, Output> extends IValve<Input, Output> {

    /**
     * 获取管道名称
     *
     * @return 管道名称
     */
    default String getPipelineName() {

        return getValveAnno().pipelineName();
    }

    /**
     * 获取阀门名称
     *
     * @return 阀门名称
     */
    default String getName() {

        return getValveAnno().name();
    }

    /**
     * 获取排序号
     *
     * @return 排序号
     */
    default int getOrder() {

        return getValveAnno().order();
    }

    @SneakyThrows
    default Valve getValveAnno() {
        Valve valveAnno = AnnotationUtil.getAnnotation(this.getClass(), Valve.class);
        Assert.notNull(valveAnno, new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new PipelineException(PipelineExceptionEnum.VALVE_ANNOTATION_NOT_EXIST.getCode(), PipelineExceptionEnum.VALVE_ANNOTATION_NOT_EXIST.getMessage(this.getClass()));
            }
        });

        return valveAnno;
    }

}
