package io.github.zhdotm.ohzh.pipeline.starter.web.support;

import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.pipeline.core.Pipeline;
import io.github.zhdotm.ohzh.pipeline.core.exception.PipelineException;
import io.github.zhdotm.ohzh.pipeline.core.exception.PipelineExceptionEnum;
import lombok.SneakyThrows;

import java.util.function.Supplier;

/**
 * 管道支持
 *
 * @author zhihao.mao
 */

public class SpringPipelineSupport {

    /**
     * 获取管道
     *
     * @param pipelineName 管道名称
     * @param <Input>      输入
     * @param <Output>     输出
     * @return 管道
     */
    public static <Input, Output> Pipeline<Input, Output> getPipeline(String pipelineName) {

        return SpringUtil.getBean(pipelineName, Pipeline.class);
    }

    /**
     * 添加管道
     *
     * @param pipeline 管道
     * @param <Input>  入参
     * @param <Output> 出参
     */
    public static <Input, Output> void addPipeline(Pipeline<Input, Output> pipeline) {

        SpringUtil.registerBean(pipeline.getName(), pipeline);
    }

    /**
     * 移除管道
     *
     * @param pipeline 管道
     * @param <Input>  入参
     * @param <Output> 出参
     */
    public static <Input, Output> void removePipeline(Pipeline<Input, Output> pipeline) {

        SpringUtil.unregisterBean(pipeline.getName());
    }

    /**
     * 移除管道
     *
     * @param pipelineName 管道名称
     */
    public static void removePipeline(String pipelineName) {

        SpringUtil.unregisterBean(pipelineName);
    }


    /**
     * 抽取
     *
     * @param pipelineName 管道名称
     * @param input        输入
     * @param <Input>      输入类型
     * @param <Output>     输出类型
     * @return 输出
     */
    @SneakyThrows
    public static <Input, Output> Output drawOff(String pipelineName, Input input) {
        Pipeline<Input, Output> pipeline = getPipeline(pipelineName);
        Assert.notNull(pipeline, (Supplier<Throwable>) () -> new PipelineException(PipelineExceptionEnum.PIPELINE_NOT_EXIST.getCode(), PipelineExceptionEnum.PIPELINE_NOT_EXIST.getMessage(pipelineName)));

        return pipeline.drawOff(input);
    }

}
