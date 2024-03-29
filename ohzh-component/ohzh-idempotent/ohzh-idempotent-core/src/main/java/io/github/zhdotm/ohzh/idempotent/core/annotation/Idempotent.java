package io.github.zhdotm.ohzh.idempotent.core.annotation;

import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;

import java.lang.annotation.*;

/**
 * 幂等
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Idempotent {

    /**
     * 业务ID
     *
     * @return 业务ID
     */
    String bizId();

    /**
     * 键表达式文本
     *
     * @return 键表达式文本
     */
    String keyExpressionText();

    /**
     * 键获取器名称
     *
     * @return 键获取器名称
     */
    String keyGetterName() default IIdempotentKeyGetter.COMMON_NAME;

    /**
     * 幂等处理器名称
     *
     * @return 幂等处理器名称
     */
    String handlerName() default IIdempotentHandler.COMMON_NAME;

    /**
     * 过期时间（秒）
     *
     * @return 过期时间
     */
    long expire() default 60;

    /**
     * 重复请求信息
     *
     * @return 重复请求信息
     */
    String repeatedRequestMessage() default "";
}
