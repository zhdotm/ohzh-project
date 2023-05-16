package io.github.zhdotm.ohzh.pipeline.starter.web.support;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.pipeline.core.Pipeline;

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
     * 抽取
     *
     * @param pipelineName 管道名称
     * @param input        输入
     * @param <Input>      输入类型
     * @param <Output>     输出类型
     * @return 输出
     */
    public static <Input, Output> Output drawOff(String pipelineName, Input input) {
        Pipeline<Input, Output> pipeline = SpringUtil.getBean(pipelineName, Pipeline.class);

        return pipeline.drawOff(input);
    }

}
