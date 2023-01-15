package io.github.zhdotm.ohzh.ddd.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum ExceptionEnum {

    /**
     * 异常枚举
     */
    DOMAIN_ENTITY_ANNOTATION_NOT_EXIST(10001, "@DomainEntity注解不存在"),
    AGGREGATE_ROOT_ANNOTATION_NOT_EXIST(10001, "@AggregateRoot注解不存在"),
    DOMAIN_SERVICE_ANNOTATION_NOT_EXIST(10001, "@DomainService注解不存在"),
    ;

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
