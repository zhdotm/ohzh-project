package io.github.zhdotm.ohzh.interceptor.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 拦截点
 *
 * @author zhihao.mao
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface InterceptPoint {

    /**
     * 类
     *
     * @return 类
     */
    Class<?> type();

    /**
     * 方法名称
     *
     * @return 方法名称
     */
    String method();

    /**
     * 参数类型
     *
     * @return 参数类型
     */
    Class<?>[] args();
}
