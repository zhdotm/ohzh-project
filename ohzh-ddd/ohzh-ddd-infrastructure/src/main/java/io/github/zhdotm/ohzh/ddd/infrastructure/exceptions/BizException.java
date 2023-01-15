package io.github.zhdotm.ohzh.ddd.infrastructure.exceptions;

import io.github.zhdotm.ohzh.ddd.infrastructure.enums.ExceptionEnum;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author zhihao.mao
 */

public class BizException extends RuntimeException {

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

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

}
