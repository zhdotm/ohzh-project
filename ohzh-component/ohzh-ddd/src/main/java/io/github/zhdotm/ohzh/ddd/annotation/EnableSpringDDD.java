package io.github.zhdotm.ohzh.ddd.annotation;

import io.github.zhdotm.ohzh.extension.starter.web.annotation.EnableSpringExtension;

import java.lang.annotation.*;

/**
 * 开启拓展功能
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableSpringExtension
public @interface EnableSpringDDD {

}
