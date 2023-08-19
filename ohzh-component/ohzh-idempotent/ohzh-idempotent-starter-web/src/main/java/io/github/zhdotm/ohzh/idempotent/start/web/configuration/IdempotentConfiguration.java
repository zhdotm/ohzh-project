package io.github.zhdotm.ohzh.idempotent.start.web.configuration;

import io.github.zhdotm.ohzh.idempotent.start.web.aspect.IdempotentAspect;
import io.github.zhdotm.ohzh.idempotent.start.web.getter.ISpringIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.start.web.getter.impl.CommonSpringIdempotentKeyGetterImpl;
import io.github.zhdotm.ohzh.idempotent.start.web.manager.ISpringIdempotentManager;
import io.github.zhdotm.ohzh.idempotent.start.web.manager.impl.SpringIdempotentManagerImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author zhihao.mao
 */

@EnableAutoConfiguration
public class IdempotentConfiguration {

    @Bean
    public ISpringIdempotentKeyGetter idempotentKeyGetter() {

        return new CommonSpringIdempotentKeyGetterImpl();
    }

    @Bean
    public ISpringIdempotentManager springIdempotentManager() {

        return new SpringIdempotentManagerImpl();
    }

    @Bean
    public IdempotentAspect idempotentAspect(ISpringIdempotentManager idempotentManager) {
        return new IdempotentAspect(idempotentManager);
    }
}
