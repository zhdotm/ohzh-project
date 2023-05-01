package io.github.zhdotm.ohzh.extension.starter.web.exception;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum SpringExtensionExceptionEnum {

    /**
     * 异常枚举
     */
    ANNOTATION_SPRINGEXTENSION_ILLEGAL(200001, "{}上使用了@SpringExtension注解, @SpringExtension注解的类必须实现ISpringExtension接口"),
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
