package io.github.zhdotm.ohzh.starter.statemachine.annotation;

import java.lang.annotation.*;

/**
 * 条件
 *
 * @author zhihao.mao
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Condition {

    /**
     * 状态机ID
     *
     * @return 状态机ID
     */
    String stateMachineId();

    /**
     * 转换ID
     *
     * @return 转换ID
     */
    String transitionId();
}
