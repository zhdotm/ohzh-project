package io.github.zhdotm.ohzh.infrastructure.statemachine.model;

/**
 * 事件
 *
 * @author zhihao.mao
 */
public interface Event extends Identity {

    /**
     * 获取事件载荷
     *
     * @param <T> 载荷类型
     * @return 事件载荷
     */
    <T> T getPayload();

}
