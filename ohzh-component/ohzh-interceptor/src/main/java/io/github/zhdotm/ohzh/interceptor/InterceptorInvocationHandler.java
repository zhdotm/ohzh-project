package io.github.zhdotm.ohzh.interceptor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * 拦截器invocationHandler
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public class InterceptorInvocationHandler implements InvocationHandler {

    private final Object target;
    private final IInterceptor interceptor;
    private final Map<Class<?>, Set<Method>> interceptPointMap;

    @SneakyThrows
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Set<Method> methods = interceptPointMap.get(method.getDeclaringClass());
        if (methods != null && methods.contains(method)) {
            return interceptor.intercept(new InterceptPointInvocation(target, method, args));
        }
        return method.invoke(target, args);
    }

}
