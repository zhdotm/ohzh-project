package io.github.zhdotm.ohzh.sieve.core.annotation;

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
     * 值获取器类名称
     *
     * @return 获取器类
     */
    String valueGetterName();

    /**
     * 用途描述（没有实际作用，只是为了方便梳理逻辑）
     *
     * @return 用途描述
     */
    String description() default "";

}
