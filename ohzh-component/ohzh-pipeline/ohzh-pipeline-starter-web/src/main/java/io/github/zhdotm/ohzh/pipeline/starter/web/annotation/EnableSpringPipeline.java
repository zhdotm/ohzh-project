package io.github.zhdotm.ohzh.pipeline.starter.web.annotation;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.pipeline.starter.web.configuration.SpringPipelineConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 管道
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SpringUtil.class, SpringPipelineConfiguration.class})
public @interface EnableSpringPipeline {

}
