package io.github.zhdotm.ohzh.cqrs.starter.web.enums;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum CQRSExceptionEnum {

    /**
     * 异常枚举
     */
    COMMAND_EXECUTOR_NOT_MATCH(20001, "未找到匹配的命令执行器: {}"),
    QUERY_EXECUTOR_NOT_MATCH(20002, "未找到匹配的查询执行器: {}"),
    COMMAND_EXECUTOR_STRICT_MATCH_MANY(20003, "严格匹配到多个命令执行器: {}"),
    COMMAND_EXECUTOR_LOOSE_MATCH_MANY(20004, "松散匹配到多个命令执行器: {}"),
    QUERY_EXECUTOR_STRICT_MATCH_MANY(20005, "严格匹配到多个查询执行器: {}"),
    QUERY_EXECUTOR_LOOSE_MATCH_MANY(20006, "松散匹配到多个查询执行器: {}"),
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
