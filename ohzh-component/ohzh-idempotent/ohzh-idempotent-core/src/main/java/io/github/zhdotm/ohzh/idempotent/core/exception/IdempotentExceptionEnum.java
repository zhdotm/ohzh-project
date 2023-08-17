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
    EXEC_IS_NOT_DONE(400001, "幂等方法执行失败: 业务ID[{}], 方法名[{}], 幂等键[{}], 已抢占锁的线程未在等待时间内完成方法执行"),
    TRANSACTION_IS_NOT_ACTIVE(400002, "幂等方法执行失败: 业务ID[{}], 方法名[{}], 幂等键[{}], 事务未激活"),
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
