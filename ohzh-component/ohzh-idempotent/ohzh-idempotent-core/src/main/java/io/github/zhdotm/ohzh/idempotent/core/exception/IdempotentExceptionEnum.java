package io.github.zhdotm.ohzh.idempotent.core.exception;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum IdempotentExceptionEnum {

    /**
     * 异常枚举
     */
    REPEATED_REQUEST(400001, "重复请求, 请稍后重试"),
    TRANSACTION_IS_NOT_ACTIVE(400002, "使用基于JDBC的幂等处理器必须激活事务"),
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
