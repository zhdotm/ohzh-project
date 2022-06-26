package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import io.github.zhdotm.ohzh.infrastructure.statemachine.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 状态机构造器
 *
 * @author zhihao.mao
 */
@Slf4j
public class StateMachineBuilder implements Builder<StateMachine>, Serializable {

    /**
     * 状态机ID
     */
    private String id;

    /**
     * 描述
     */
    private String description;

    /**
     * 外部转换缓存
     */
    private final Map<String, Transition> externalTransitionCache = new HashMap<>();

    /**
     * 内部转换缓存
     */
    private final Map<String, List<Transition>> internalTransitionCache = new HashMap<>();

    /**
     * 新建转换构造器
     *
     * @return 转换构造器
     */
    public static StateMachineBuilder builder() {

        return new StateMachineBuilder();
    }

    /**
     * 设置状态机ID
     *
     * @param id 状态机ID
     * @return 状态机构造器
     */
    public StateMachineBuilder id(String id) {
        this.id = id;

        return this;
    }

    /**
     * 设置状态机描述
     *
     * @param description 状态机描述
     * @return 状态机构造器
     */
    public StateMachineBuilder description(String description) {
        this.description = description;

        return this;
    }

    /**
     * 添加转换
     *
     * @param transitions 转换
     */
    public synchronized StateMachineBuilder addTransitions(Transition... transitions) {
        for (Transition transition : transitions) {
            TransitionTypeEnum type = transition.getType();
            List<State> beginStates = transition.getFrom();
            Event event = transition.getEvent();
            for (State beginState : beginStates) {
                String cacheKey = cacheKey(beginState.getId(), event.getId());

                //外部转换
                if (type == TransitionTypeEnum.EXTERNAL) {
                    Assert.isNull(externalTransitionCache.get(cacheKey), "添加转换失败[{}]: 相同启始状态和事件对应的外部转换有且仅允许存在一个", transition.getId());
                    externalTransitionCache.put(cacheKey, transition);

                    return this;
                }

                //内部转换
                if (type == TransitionTypeEnum.INTERNAL) {
                    List<Transition> internalTransitionList = internalTransitionCache.getOrDefault(cacheKey, Lists.newArrayList());
                    internalTransitionList.add(transition);
                    internalTransitionList.sort(Comparator.comparingInt(Transition::getSort));
                    internalTransitionCache.put(cacheKey, internalTransitionList);
                }
            }
        }

        return this;
    }

    /**
     * 构造状态机
     *
     * @return 状态机
     */
    @Override
    public StateMachine build() {

        return new StateMachine() {
            @Override
            public State publishEvent(State from, Event event) {
                String cacheKey = cacheKey(from.getId(), event.getId());
                List<Transition> internalTransitions = internalTransitionCache.get(cacheKey);
                Transition externalTransition = externalTransitionCache.get(cacheKey);
                if (CollectionUtil.isEmpty(internalTransitions) && ObjectUtil.isEmpty(externalTransition)) {
                    log.warn("状态机[{}]未找到对应转换组件: from[{}], event[{}]", getId(), from.getId(), event.getId());

                    return null;
                }

                if (CollectionUtil.isNotEmpty(internalTransitions)) {
                    for (Transition internalTransition : internalTransitions) {
                        Condition condition = internalTransition.getCondition();
                        if (!condition.isAllowed(event)) {

                            continue;
                        }
                        Action action = internalTransition.getAction();
                        action.onEvent(event);
                    }
                }

                if (ObjectUtil.isNotEmpty(externalTransition)) {
                    Condition condition = externalTransition.getCondition();
                    if (!condition.isAllowed(event)) {

                        return null;
                    }
                    Action action = externalTransition.getAction();
                    action.onEvent(event);

                    return externalTransition.getTo();
                }

                return null;
            }

            @Override
            public String getId() {

                return id;
            }

            @Override
            public String getDescription() {

                return description;
            }
        };
    }

    /**
     * 生成缓存键
     *
     * @param stateId 状态ID
     * @param eventId 事件ID
     * @return 缓存键
     */
    private String cacheKey(String stateId, String eventId) {

        return stateId + StrUtil.UNDERLINE + eventId;
    }

}
