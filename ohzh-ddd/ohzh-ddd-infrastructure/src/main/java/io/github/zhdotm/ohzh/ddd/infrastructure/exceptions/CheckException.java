package io.github.zhdotm.ohzh.ddd.infrastructure.exceptions;

import io.github.zhdotm.ohzh.ddd.infrastructure.enums.ExpEnum;
import lombok.Getter;

/**
 * 检查异常
 *
 * @author zhihao.mao
 */

public class CheckException extends RuntimeException {

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

    public CheckException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public CheckException(ExpEnum expEnum) {
        super(expEnum.getMessage());
        this.code = expEnum.getCode();
        this.message = expEnum.getMessage();
    }

}
