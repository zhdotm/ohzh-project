package io.github.zhdotm.ohzh.interceptor.core.assembler;

import cn.hutool.core.util.ObjectUtil;

/**
 * 拦截器装配器
 *
 * @author zhihao.mao
 */

public class InterceptorAssembler implements IInterceptorAssembler {

    private static volatile IInterceptorAssembler interceptorAssembler;

    private InterceptorAssembler() {
    }

    public static synchronized IInterceptorAssembler getInstance() {
        if (ObjectUtil.isEmpty(InterceptorAssembler.interceptorAssembler)) {
            InterceptorAssembler.interceptorAssembler = new InterceptorAssembler();
        }

        return InterceptorAssembler.interceptorAssembler;
    }

    public static synchronized IInterceptorAssembler getInstance(IInterceptorAssembler interceptorAssembler) {
        if (ObjectUtil.isNotEmpty(interceptorAssembler)) {
            InterceptorAssembler.interceptorAssembler = interceptorAssembler;
        }

        return getInstance();
    }

}
