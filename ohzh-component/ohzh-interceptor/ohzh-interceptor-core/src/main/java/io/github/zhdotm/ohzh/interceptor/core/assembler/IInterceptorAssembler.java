package io.github.zhdotm.ohzh.interceptor.core.assembler;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.interceptor.core.IInterceptor;
import io.github.zhdotm.ohzh.interceptor.core.annotation.InterceptPoint;
import io.github.zhdotm.ohzh.interceptor.core.annotation.Interceptor;
import io.github.zhdotm.ohzh.interceptor.core.exception.InterceptorException;
import io.github.zhdotm.ohzh.interceptor.core.invocation.InterceptorInvocationHandler;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 拦截器装配器
 *
 * @author zhihao.mao
 */

public interface IInterceptorAssembler {

    /**
     * 装配拦截器
     *
     * @param target      装配对象
     * @param interceptor 拦截器
     * @return 装配拦截器后的对象
     */
    default <T> T assemble(T target, IInterceptor interceptor) {
        Map<Class<?>, Set<Method>> interceptPointMap = getInterceptPointMap(interceptor);
        Class<?> targetClazz = target.getClass();

        List<Class<?>> interfaces = interceptPointMap
                .keySet()
                .stream()
                .filter(type -> ClassUtil.isAssignable(type, targetClazz))
                .collect(Collectors.toList());

        if (CollectionUtil.isNotEmpty(interfaces)) {

            return (T) Proxy.newProxyInstance(
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
    default Map<Class<?>, Set<Method>> getInterceptPointMap(IInterceptor interceptor) {
        checkInterceptor(interceptor);
        Interceptor interceptorAnnotation = getInterceptorAnnotation(interceptor);

        return Arrays.stream(interceptorAnnotation.points())
                .collect(Collectors.groupingBy(
                        InterceptPoint::type,
                        Collectors.mapping(
                                new Function<InterceptPoint, Method>() {
                                    @SneakyThrows
                                    @Override
                                    public Method apply(InterceptPoint point) {
                                        return point.type().getMethod(point.method(), point.args());
                                    }
                                },
                                Collectors.toSet())
                ));
    }

    /**
     * 校验拦截器合法性
     *
     * @param interceptor 拦截器
     */
    @SneakyThrows
    default void checkInterceptor(IInterceptor interceptor) {
        Interceptor interceptorAnnotation = getInterceptorAnnotation(interceptor);
        Assert.isTrue(ObjectUtil.isNotEmpty(interceptorAnnotation), (Supplier<Throwable>) () -> new InterceptorException(StrUtil.format("装配拦截器失败: {}拦截器上未携带@Interceptor注解", interceptor.getClass().getName())));
        Optional<InterceptPoint> notInterfaceInterceptPointOptional = Arrays
                .stream(interceptorAnnotation.points())
                .filter(interceptPoint -> !ClassUtil.isInterface(interceptPoint.type()))
                .findAny();
        Assert.isFalse(notInterfaceInterceptPointOptional.isPresent(), (Supplier<Throwable>) () -> new InterceptorException(StrUtil.format("装配拦截器失败: {}拦截器上声明的拦截点type = {}非接口", interceptor.getClass().getName(), notInterfaceInterceptPointOptional.get().type())));
    }

    /**
     * 获取拦截器注解
     *
     * @param interceptor 拦截器
     * @return 拦截器注解
     */
    default Interceptor getInterceptorAnnotation(IInterceptor interceptor) {

        return AnnotationUtil.getAnnotation(interceptor.getClass(), Interceptor.class);
    }
}
