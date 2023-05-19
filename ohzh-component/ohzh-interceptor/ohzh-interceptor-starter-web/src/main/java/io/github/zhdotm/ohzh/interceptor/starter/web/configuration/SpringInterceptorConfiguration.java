package io.github.zhdotm.ohzh.interceptor.starter.web.configuration;

import io.github.zhdotm.ohzh.interceptor.core.assembler.IInterceptorAssembler;
import io.github.zhdotm.ohzh.interceptor.core.assembler.InterceptorAssembler;
import io.github.zhdotm.ohzh.interceptor.starter.web.assembler.SpringInterceptorAssembler;
import io.github.zhdotm.ohzh.interceptor.starter.web.runner.SpringInterceptorRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author zhihao.mao
 */

@EnableAutoConfiguration
public class SpringInterceptorConfiguration {

    @Bean
    public SpringInterceptorRunner springInterceptorRunner() {

        return new SpringInterceptorRunner();
    }

    @Bean
    public IInterceptorAssembler interceptorAssembler() {

        return InterceptorAssembler.getInstance(new SpringInterceptorAssembler());
    }

}
