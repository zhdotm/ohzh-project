package io.github.zhdotm.ohzh.interceptor.starter.web.assembler;

import io.github.zhdotm.ohzh.interceptor.core.IInterceptor;
import io.github.zhdotm.ohzh.interceptor.core.annotation.Interceptor;
import io.github.zhdotm.ohzh.interceptor.core.assembler.IInterceptorAssembler;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * 拦截器装配器
 *
 * @author zhihao.mao
 */

public class SpringInterceptorAssembler implements IInterceptorAssembler {


    @Override
    public Interceptor getInterceptorAnnotation(IInterceptor interceptor) {

        return AnnotatedElementUtils.getMergedAnnotation(interceptor.getClass(), Interceptor.class);
    }

}
