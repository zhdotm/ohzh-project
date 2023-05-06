package io.github.zhdotm.ohzh.interceptor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 拦截器责任链
 *
 * @author zhihao.mao
 */

public class InterceptorChain {

    @Getter
    private final List<IInterceptor> interceptors = new ArrayList<>();

    public Object assembleAll(Object target) {
        for (IInterceptor interceptor : interceptors) {
            target = interceptor.assemble(target);
        }
        return target;
    }

    public void addInterceptor(IInterceptor interceptor) {
        interceptors.add(interceptor);
        interceptors.sort(Comparator.comparingInt(IInterceptor::order));
    }
    
}
