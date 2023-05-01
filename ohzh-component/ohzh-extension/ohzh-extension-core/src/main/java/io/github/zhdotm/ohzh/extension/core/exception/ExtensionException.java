package io.github.zhdotm.ohzh.extension.core.exception;

import lombok.Getter;

/**
 * 拓展点异常
 *
 * @author zhihao.mao
 */

public class ExtensionException extends RuntimeException {

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

    public ExtensionException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ExtensionException(int code, String format, Object... args) {
        super(String.format(format, args));
        String message = String.format(format, args);
        this.code = code;
        this.message = message;
    }
}
