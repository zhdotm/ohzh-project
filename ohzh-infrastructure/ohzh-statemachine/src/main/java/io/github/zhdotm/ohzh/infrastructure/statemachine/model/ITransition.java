package io.github.zhdotm.ohzh.infrastructure.statemachine.model;

import io.github.zhdotm.ohzh.infrastructure.statemachine.constant.TransitionTypeEnum;

import java.util.List;

/**
 * 转换
 *
 * @author zhihao.mao
 */
public interface ITransition extends Identity {

    /**
     * 获取排序号
     *
     * @return 排序号
     */
    default Integer getSort() {

        return Integer.MAX_VALUE;
    }

    /**
     * 获取转换类型
     *
     * @return 转换类型
     */
    TransitionTypeEnum getType();

    /**
     * 获取转换前状态
     *
     * @return 转换前状态
     */
    List<IState> getFrom();

    /**
     * 获取转换后状态
     *
     * @return 转换后状态
     */
    IState getTo();

    /**
     * 获取事件
     *
     * @return 事件
     */
    IEvent getEvent();

    /**
     * 获取条件
     *
     * @return 条件
     */
    ICondition getCondition();

    /**
     * 获取动作
     *
     * @return 动作
     */
    IAction getAction();

}
