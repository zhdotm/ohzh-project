package io.github.zhdotm.ohzh.interceptor.core.chain;

import cn.hutool.core.collection.CollectionUtil;
import io.github.zhdotm.ohzh.interceptor.core.IInterceptor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collection;
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

    public void addInterceptors(Collection<IInterceptor> interceptors) {
        if (CollectionUtil.isEmpty(interceptors)) {
            return;
        }
        interceptors.forEach(this::addInterceptor);
    }

}
