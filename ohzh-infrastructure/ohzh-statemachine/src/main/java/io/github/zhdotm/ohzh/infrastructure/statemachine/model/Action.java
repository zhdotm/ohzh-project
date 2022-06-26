package io.github.zhdotm.ohzh.infrastructure.statemachine.model;

/**
 * 动作
 *
 * @author zhihao.mao
 */
public interface Action extends Identity {

    /**
     * 执行事件
     *
     * @param event 事件
     */
    void onEvent(Event event);
}
