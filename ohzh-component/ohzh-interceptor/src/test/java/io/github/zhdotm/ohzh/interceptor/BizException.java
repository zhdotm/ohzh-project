package io.github.zhdotm.ohzh.interceptor;

/**
 * 业务异常
 *
 * @author zhihao.mao
 */

public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }
}
