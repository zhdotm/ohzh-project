package io.github.zhdotm.ohzh.infrastructure.statemachine.model;

/**
 * 条件
 *
 * @author zhihao.mao
 */
public interface ICondition extends Identity {

    /**
     * 判断是否允许处理该事件
     *
     * @param event 事件
     * @return 是/否
     */
    Boolean isAllowed(IEvent event);
}
