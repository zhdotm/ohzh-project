package io.github.zhdotm.ohzh.interceptor;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 拦截器装配器
 *
 * @author zhihao.mao
 */

public class InterceptorAssembler {

    /**
     * 装配拦截器
     *
     * @param target      装配对象
     * @param interceptor 拦截器
     * @return 装配拦截器后的对象
     */
    public static Object assemble(Object target, IInterceptor interceptor) {
        Map<Class<?>, Set<Method>> interceptPointMap = getInterceptPointMap(interceptor);
        Class<?> targetClazz = target.getClass();

        List<Class<?>> interfaces = interceptPointMap
                .keySet()
                .stream()
                .filter(type -> ClassUtil.isAssignable(type, targetClazz))
                .collect(Collectors.toList());

        if (CollectionUtil.isNotEmpty(interfaces)) {

            return Proxy.newProxyInstance(
                    targetClazz.getClassLoader(),
                    interfaces.toArray(new Class<?>[0]),
                    new InterceptorInvocationHandler(target, interceptor, interceptPointMap));
        }

        return target;
    }

    /**
     * 获取拦截点信息
     *
     * @param interceptor 拦截器
     * @return 拦截点信息
     */
    @SneakyThrows
    private static Map<Class<?>, Set<Method>> getInterceptPointMap(IInterceptor interceptor) {
        Interceptor interceptorAnnotation = AnnotationUtil.getAnnotation(interceptor.getClass(), Interceptor.class);
        Assert.isTrue(ObjectUtil.isNotEmpty(interceptorAnnotation), (Supplier<Throwable>) () -> new InterceptorException("No @Intercepts annotation was found in interceptor " + interceptor.getClass().getName()));

        return Arrays.stream(interceptorAnnotation.points())
                .collect(Collectors.groupingBy(
                        Interceptor.InterceptPoint::type,
                        Collectors.mapping(
                                new Function<Interceptor.InterceptPoint, Method>() {
                                    @SneakyThrows
                                    @Override
                                    public Method apply(Interceptor.InterceptPoint point) {
                                        return point.type().getMethod(point.method(), point.args());
                                    }
                                },
                                Collectors.toSet())
                ));
    }

}
