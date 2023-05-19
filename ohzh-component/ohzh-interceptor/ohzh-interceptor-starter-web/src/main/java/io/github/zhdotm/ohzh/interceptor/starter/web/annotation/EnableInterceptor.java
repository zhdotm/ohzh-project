package io.github.zhdotm.ohzh.interceptor.starter.web.annotation;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.interceptor.starter.web.configuration.SpringInterceptorConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用拦截器
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SpringUtil.class, SpringInterceptorConfiguration.class})
public @interface EnableInterceptor {
}
