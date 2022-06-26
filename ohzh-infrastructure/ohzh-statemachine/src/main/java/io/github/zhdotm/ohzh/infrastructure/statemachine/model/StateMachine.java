package io.github.zhdotm.ohzh.infrastructure.statemachine.model;

/**
 * 状态机
 *
 * @author zhihao.mao
 */
public interface StateMachine extends Identity {

    /**
     * 发布事件
     *
     * @param from  执行前状态
     * @param event 事件
     * @return 执行后状态
     */
    State publishEvent(State from, Event event);
}
