package io.github.zhdotm.ohzh.starter.statemachine.annotation;

import io.github.zhdotm.ohzh.starter.statemachine.config.StateMachineConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 状态机
 *
 * @author zhihao.mao
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(StateMachineConfig.class)
public @interface EnableStateMachine {

}
