package io.github.zhdotm.ohzh.idempotent.start.web.annotation;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.idempotent.start.web.configuration.IdempotentConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {IdempotentConfiguration.class, SpringUtil.class})
public @interface EnableIdempotent {
}
