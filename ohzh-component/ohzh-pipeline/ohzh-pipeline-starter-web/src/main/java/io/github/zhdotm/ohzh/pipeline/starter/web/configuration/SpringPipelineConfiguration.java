package io.github.zhdotm.ohzh.pipeline.starter.web.configuration;

import io.github.zhdotm.ohzh.pipeline.starter.web.runner.SpringPipelineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 配置
 *
 * @author zhihao.mao
 */

@EnableAutoConfiguration
public class SpringPipelineConfiguration {

    @Bean
    public SpringPipelineRunner springPipelineRunner() {

        return new SpringPipelineRunner();
    }

}
