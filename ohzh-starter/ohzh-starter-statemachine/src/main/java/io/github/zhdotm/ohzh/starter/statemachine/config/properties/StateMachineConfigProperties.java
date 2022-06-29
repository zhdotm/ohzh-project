package io.github.zhdotm.ohzh.starter.statemachine.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 状态机配置参数
 *
 * @author zhihao.mao
 */
@Data
@Component
@ConfigurationProperties(prefix = StateMachineConfigProperties.PREFIX)
public class StateMachineConfigProperties {

    public static final String PREFIX = "ohzh";

    /**
     * 状态机
     */
    private List<StateMachineProperties> stateMachines;
}
