package io.github.zhdotm.ohzh.pipeline.starter.web.adapter;

import cn.hutool.core.annotation.AnnotationUtil;
import io.github.zhdotm.ohzh.pipeline.core.IValve;
import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.SpringValve;

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

        return AnnotationUtil
                .getAnnotation(this.getClass(), SpringValve.class)
                .pipelineName();
    }

    /**
     * 获取阀门名称
     *
     * @return 阀门名称
     */
    default String getName() {

        return AnnotationUtil
                .getAnnotation(this.getClass(), SpringValve.class)
                .name();
    }

    /**
     * 获取排序号
     *
     * @return 排序号
     */
    default int getOrder() {

        return AnnotationUtil
                .getAnnotation(this.getClass(), SpringValve.class)
                .order();
    }

}
