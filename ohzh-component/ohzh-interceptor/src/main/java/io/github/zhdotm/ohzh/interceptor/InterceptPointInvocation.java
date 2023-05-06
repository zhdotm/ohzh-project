package io.github.zhdotm.ohzh.interceptor;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * 拦截点调用信息
 *
 * @author zhihao.mao
 */

public class InterceptPointInvocation {

    @Getter
    private final Object target;

    @Getter
    private final Method method;

    @Getter
    private final Object[] args;

    public InterceptPointInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @SneakyThrows
    public Object proceed() {
        return method.invoke(target, args);
    }

}
