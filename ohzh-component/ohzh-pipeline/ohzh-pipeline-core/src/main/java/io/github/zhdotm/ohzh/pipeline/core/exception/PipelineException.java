package io.github.zhdotm.ohzh.pipeline.core.exception;

import lombok.Getter;

/**
 * 管道异常
 *
 * @author zhihao.mao
 */

public class PipelineException extends RuntimeException {

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

    public PipelineException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public PipelineException(int code, String format, Object... args) {
        super(String.format(format, args));
        String message = String.format(format, args);
        this.code = code;
        this.message = message;
    }
}
