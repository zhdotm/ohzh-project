package io.github.zhdotm.ohzh.statemachine.starter.web.annotation;

import io.github.zhdotm.ohzh.statemachine.starter.web.configuration.StateMachineConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启状态机
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(StateMachineConfiguration.class)
public @interface EnableStateMachine {
}
