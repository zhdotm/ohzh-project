package io.github.zhdotm.ohzh.ddd.annotation;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启拓展功能
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {SpringUtil.class})
public @interface EnableDDD {

}
