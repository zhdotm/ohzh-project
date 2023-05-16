package io.github.zhdotm.ohzh.pipeline.core.exception;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author zhihao.mao
 */

@AllArgsConstructor
public enum PipelineExceptionEnum {

    /**
     * 异常枚举
     */
    NEXT_VALVE_NOT_EXIST(300001, "阀门{}不存在下个阀门"),
    PIPELINE_NOT_EXIST(300002, "管道{}不存在"),
    VALVE_ANNOTATION_NOT_EXIST(300003, "类{}上不存在@Valve注解"),
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
