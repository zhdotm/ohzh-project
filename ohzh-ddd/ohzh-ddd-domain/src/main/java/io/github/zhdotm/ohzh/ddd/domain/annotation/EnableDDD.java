package io.github.zhdotm.ohzh.ddd.domain.annotation;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用DDD
 *
 * @author zhihao.mao
 */

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpringUtil.class)
public @interface EnableDDD {
}
