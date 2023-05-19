package io.github.zhdotm.ohzh.interceptor.starter.web.runner;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.interceptor.core.IInterceptor;
import io.github.zhdotm.ohzh.interceptor.core.annotation.InterceptPoint;
import io.github.zhdotm.ohzh.interceptor.core.annotation.Interceptor;
import io.github.zhdotm.ohzh.interceptor.core.chain.InterceptorChain;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author zhihao.mao
 */

public class SpringInterceptorRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Collection<IInterceptor> interceptors = SpringUtil.getBeansOfType(IInterceptor.class)
                .values()
                .stream()
                .filter(interceptor -> ObjectUtil.isNotEmpty(AnnotatedElementUtils.getMergedAnnotation(interceptor.getClass(), Interceptor.class)))
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(interceptors)) {
            return;
        }
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptors(interceptors);
        interceptors
                .stream()
                .flatMap(interceptor -> Arrays.stream(AnnotatedElementUtils.getMergedAnnotation(interceptor.getClass(), Interceptor.class).points()).map(InterceptPoint::type))
                .distinct()
                .forEach(clazz -> {
                    SpringUtil.getBeansOfType(clazz)
                            .values()
                            .forEach(interceptorChain::assembleAll);
                });

        SpringUtil.registerBean(interceptorChain.getClass().getSimpleName(), interceptorChain);
    }

}
