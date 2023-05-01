package io.github.zhdotm.ohzh.extension.core.exception;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum ExtensionExceptionEnum {

    /**
     * 异常枚举
     */
    EXTENSION_ANNOTATION_NOT_EXIST(100001, "{}拓展未找到@Extension注解"),
    EXTENSION_COORDINATE_DUPLICATE(100002, "{}拓展和{}拓展存在重复拓展点坐标{}"),
    EXTENSION_COORDINATE_EXTENSION_NOT_EXIST(100003, "{}拓展点坐标未找到对应拓展"),
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
