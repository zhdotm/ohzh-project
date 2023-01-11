package io.github.zhdotm.ohzh.ddd.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum ExpEnum {

    /**
     * 异常枚举
     */
    ENTITY_ANNOTATION_NOT_EXIST(10001, "@Entity注解不存在");

    /**
     * 异常编码
     */
    @Getter
    private final int code;

    /**
     * 异常消息
     */
    @Getter
    private final String message;
}
