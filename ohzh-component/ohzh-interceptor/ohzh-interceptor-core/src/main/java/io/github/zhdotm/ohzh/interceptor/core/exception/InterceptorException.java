package io.github.zhdotm.ohzh.interceptor.core.exception;

/**
 * 拦截器异常
 *
 * @author zhihao.mao
 */

public class InterceptorException extends RuntimeException {

    private static final long serialVersionUID = 8548771664564998595L;

    public InterceptorException() {
        super();
    }

    public InterceptorException(String message) {
        super(message);
    }

    public InterceptorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterceptorException(Throwable cause) {
        super(cause);
    }
}
