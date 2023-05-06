package io.github.zhdotm.ohzh.interceptor;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器责任链
 *
 * @author zhihao.mao
 */

public class InterceptorChain {

    @Getter
    private final List<IInterceptor> interceptors = new ArrayList<>();

    @SneakyThrows
    public <T> T assembleAll(T target) {
        for (IInterceptor interceptor : interceptors) {
            target = interceptor.assemble(target);
        }
        return target;
    }

    public void addInterceptor(IInterceptor interceptor) {
        interceptors.add(interceptor);
        interceptors.sort((interceptor1, interceptor2) -> interceptor2.order() - interceptor1.order());
    }

}
