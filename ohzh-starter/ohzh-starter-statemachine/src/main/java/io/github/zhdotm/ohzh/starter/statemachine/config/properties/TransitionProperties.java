package io.github.zhdotm.ohzh.starter.statemachine.config.properties;

import io.github.zhdotm.ohzh.infrastructure.statemachine.constant.TransitionTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * 转换配置
 *
 * @author zhihao.mao
 */
@Data
public class TransitionProperties {

    /**
     * 转换ID
     */
    private String id;

    /**
     * 转换描述
     */
    private String description;

    /**
     * 转换类型
     */
    private TransitionTypeEnum type;

    /**
     * 转换前状态ID
     */
    private List<String> beginStateIds;

    /**
     * 转换后状态ID
     */
    private String endStateId;

    /**
     * 转换事件ID
     */
    private String eventId;
}
