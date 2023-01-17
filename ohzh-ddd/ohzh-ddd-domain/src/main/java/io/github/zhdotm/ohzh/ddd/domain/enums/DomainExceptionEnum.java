package io.github.zhdotm.ohzh.ddd.domain.enums;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum DomainExceptionEnum {

    /**
     * 异常枚举
     */
    DOMAIN_ENTITY_ANNOTATION_NOT_EXIST(10001, "{}不存在@DomainEntity注解"),
    AGGREGATE_ROOT_ANNOTATION_NOT_EXIST(10002, "{}不存在@AggregateRoot注解"),
    DOMAIN_SERVICE_ANNOTATION_NOT_EXIST(10003, "{}不存在@DomainService注解"),
    DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST(10004, "{}不存在@DomainAbilityExtension注解"),
    DOMAIN_ENTITY_EXTENSION_NOT_MATCH(10005, "领域实体{}和领域拓展{}不匹配"),
    DOMAIN_SERVICE_EXTENSION_NOT_MATCH(10006, "领域服务{}和领域拓展{}不匹配"),
    AGGREGATE_ROOT_EXTENSION_NOT_MATCH(10007, "聚合根{}和领域拓展{}不匹配"),
    DOMAIN_ABILITY_EXTENSION_STRICT_MATCH_MANY(10008, "严格匹配到多个领域能力拓展: {}"),
    DOMAIN_ABILITY_EXTENSION_LOOSE_MATCH_MANY(10009, "松散匹配到多个领域能力拓展: {}"),
    DOMAIN_ABILITY_EXTENSION_NOT_MATCH(10010, "未匹配到领域能力拓展: {}"),
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
    private final String format;

    public String getMessage(Object... args) {

        return StrUtil.format(format, args);
    }

}
