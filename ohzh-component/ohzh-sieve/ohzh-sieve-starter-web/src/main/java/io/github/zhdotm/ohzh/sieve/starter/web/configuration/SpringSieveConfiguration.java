package io.github.zhdotm.ohzh.sieve.starter.web.configuration;

import io.github.zhdotm.ohzh.sieve.mybatis.plugin.SieveInterceptor;
import io.github.zhdotm.ohzh.sieve.starter.web.aspect.SieveAspect;
import io.github.zhdotm.ohzh.sieve.starter.web.holder.SieveConditionHolder;
import io.github.zhdotm.ohzh.sieve.starter.web.manager.ISpringValueGetterManager;
import io.github.zhdotm.ohzh.sieve.starter.web.manager.impl.SpringValueGetterManagerImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author zhihao.mao
 */

@EnableAutoConfiguration
public class SpringSieveConfiguration {

    @Bean
    public ISpringValueGetterManager springValueGetterManager() {

        return new SpringValueGetterManagerImpl();
    }

    @Bean
    public SieveAspect sieveAspect(ISpringValueGetterManager springValueGetterManager) {

        return new SieveAspect(springValueGetterManager);
    }

    @Bean
    public SieveInterceptor sieveInterceptor() {

        return new SieveInterceptor(SieveConditionHolder::getConditionMap);
    }
}
