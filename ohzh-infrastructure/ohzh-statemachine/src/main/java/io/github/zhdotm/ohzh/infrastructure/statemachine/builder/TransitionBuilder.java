package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import io.github.zhdotm.ohzh.infrastructure.statemachine.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 转换器组件构造器
 *
 * @author zhihao.mao
 */

@Slf4j
public class TransitionBuilder implements IBuilder<ITransition>, Serializable {

    /**
     * 转换器组件ID
     */
    private String id;

    /**
     * 转换器组件描述
     */
    private String description;

    /**
     * 转换器组件排序号
     */
    private Integer sort;

    /**
     * 转换类型
     */
    private TransitionTypeEnum type;

    /**
     * 转换前状态
     */
    private List<IState> beginStates;

    /**
     * 转换后状态
     */
    private IState endState;

    /**
     * 条件
     */
    private ICondition condition;

    /**
     * 事件
     */
    private IEvent event;

    /**
     * 动作
     */
    private IAction action;

    /**
     * 新建转换器组件构造器
     *
     * @return 转换器组件构造器
     */
    public static TransitionBuilder builder() {

        return new TransitionBuilder();
    }

    /**
     * 设置转换器组件ID
     *
     * @param id 转换器组件ID
     * @return 转换器组件构造器
     */
    public TransitionBuilder id(String id) {
        this.id = id;

        return this;
    }

    /**
     * 设置转换器组件排序号
     *
     * @param sort 转换器组件排序号
     * @return 转换器组件构造器
     */
    public TransitionBuilder sort(Integer sort) {
        this.sort = sort;

        return this;
    }

    /**
     * 设置转换组件描述
     *
     * @param description 转换组件描述
     * @return 转换器组件构造器
     */
    public TransitionBuilder description(String description) {
        this.description = description;

        return this;
    }

    /**
     * 设置转换类型为外部转换
     *
     * @return 转换器组件构造器
     */
    public TransitionBuilder external() {
        type = TransitionTypeEnum.EXTERNAL;

        return this;
    }

    /**
     * 设置转换类型为内部转换
     *
     * @return 转换器组件构造器
     */
    public TransitionBuilder internal() {
        type = TransitionTypeEnum.INTERNAL;

        return this;
    }

    /**
     * 设置转换前状态
     *
     * @param states 转换前状态
     * @return 转换器组件构造器
     */
    public TransitionBuilder from(IState... states) {
        if (CollectionUtil.isEmpty(beginStates)) {

            beginStates = Lists.newArrayList();
        }

        if (ObjectUtil.isNotEmpty(states)) {

            beginStates.addAll(Arrays.asList(states));
        }

        return this;
    }

    /**
     * 设置转换后状态
     *
     * @param state 转换后状态
     * @return 转换器组件构造器
     */
    public TransitionBuilder to(IState state) {
        Assert.notNull(type, "设置转换后状态失败: 未设置转换类型");
        Assert.isTrue(type == TransitionTypeEnum.EXTERNAL, "设置转换后状态失败: 只有外部转换需要设置转换后状态");
        this.endState = state;

        return this;
    }

    /**
     * 设置转换条件
     *
     * @param condition 转换条件
     * @return 转换器组件构造器
     */
    public TransitionBuilder on(ICondition condition) {
        this.condition = condition;

        return this;
    }

    /**
     * 设置转换事件
     *
     * @param event 转换事件
     * @return 转换器组件构造器
     */
    public TransitionBuilder when(IEvent event) {
        this.event = event;

        return this;
    }

    /**
     * 设置转换动作
     *
     * @param action 转换动作
     * @return 转换器组件构造器
     */
    public TransitionBuilder perform(IAction action) {
        this.action = action;

        return this;
    }

    /**
     * 生成转换器组件
     *
     * @return 转换器组件
     */
    @Override
    public ITransition build() {
        Assert.notBlank(id, "构建转换器组件失败: id为空");
        Assert.notNull(type, "构建转换器组件失败: 转换类型为空");
        Assert.notEmpty(beginStates, "构建转换器组件失败: 转换前状态为空");
        Assert.notNull(endState, "构建转换器组件失败: 转换后状态为空");
        Assert.notNull(condition, "构建转换器组件失败: 条件组件为空");
        Assert.notNull(event, "构建转换器组件失败: 事件组件为空");
        Assert.notNull(action, "构建转换器组件失败: 动作组件为空");

        return new ITransition() {
            @Override
            public TransitionTypeEnum getType() {

                return type;
            }

            @Override
            public List<IState> getFrom() {

                return beginStates;
            }

            @Override
            public IState getTo() {

                return endState;
            }

            @Override
            public IEvent getEvent() {

                return event;
            }

            @Override
            public ICondition getCondition() {

                return condition;
            }

            @Override
            public IAction getAction() {

                return action;
            }

            @Override
            public String getId() {

                return id;
            }

            @Override
            public String getDescription() {

                return description;
            }

            @Override
            public Integer getSort() {
                if (ObjectUtil.isNotEmpty(sort)) {

                    return sort;
                }

                return ITransition.super.getSort();
            }
        };
    }

}
