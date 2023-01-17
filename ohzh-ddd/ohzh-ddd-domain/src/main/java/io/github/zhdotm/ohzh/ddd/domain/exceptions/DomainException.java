package io.github.zhdotm.ohzh.ddd.domain.exceptions;

import io.github.zhdotm.ohzh.ddd.domain.enums.DomainExceptionEnum;
import lombok.Getter;

/**
 * 检查异常
 *
 * @author zhihao.mao
 */

public class DomainException extends RuntimeException {

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

    public DomainException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public DomainException(DomainExceptionEnum domainExceptionEnum, Object... args) {
        super(domainExceptionEnum.getMessage());
        this.code = domainExceptionEnum.getCode();
        this.message = domainExceptionEnum.getMessage(args);
    }

}
