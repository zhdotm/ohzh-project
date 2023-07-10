package io.github.zhdotm.ohzh.sieve.starter.web.annotation;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用数据筛子
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {SpringUtil.class})
public @interface EnableSieve {
}
