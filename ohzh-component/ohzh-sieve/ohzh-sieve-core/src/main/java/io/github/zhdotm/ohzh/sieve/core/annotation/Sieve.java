package io.github.zhdotm.ohzh.sieve.core.annotation;

import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetter;

import java.lang.annotation.*;

/**
 * 筛子
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Sieve {

    /**
     * 指定表
     *
     * @return 表
     */
    String table();

    /**
     * 指定字段
     *
     * @return 字段
     */
    String column();

    /**
     * 获取器类
     *
     * @return 获取器类
     */
    Class<? extends IValueGetter> getterClazz();

    /**
     * 用途描述（没有实际作用，只是为了方便梳理逻辑）
     *
     * @return 用途描述
     */
    String description() default "";

}
