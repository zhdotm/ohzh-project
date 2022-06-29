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
public class StateMachineBuilder implements IBuilder<IStateMachine>, Serializable {

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
    private final Map<String, ITransition> externalTransitionCache = new HashMap<>();

    /**
     * 内部转换缓存
     */
    private final Map<String, List<ITransition>> internalTransitionCache = new HashMap<>();

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
    public synchronized StateMachineBuilder addTransitions(ITransition... transitions) {
        for (ITransition transition : transitions) {
            TransitionTypeEnum type = transition.getType();
            List<IState> beginStates = transition.getFrom();
            IEvent event = transition.getEvent();
            for (IState beginState : beginStates) {
                String cacheKey = cacheKey(beginState.getId(), event.getId());

                //外部转换
                if (type == TransitionTypeEnum.EXTERNAL) {
                    Assert.isNull(externalTransitionCache.get(cacheKey), "添加转换失败[{},{}]: 相同启始状态和事件对应的外部转换有且仅允许存在一个", id, transition.getId());
                    externalTransitionCache.put(cacheKey, transition);

                    continue;
                }

                //内部转换
                if (type == TransitionTypeEnum.INTERNAL) {
                    List<ITransition> internalTransitionList = internalTransitionCache.getOrDefault(cacheKey, Lists.newArrayList());
                    internalTransitionList.add(transition);
                    internalTransitionList.sort(Comparator.comparingInt(ITransition::getSort));
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
    public IStateMachine build() {

        return new IStateMachine() {
            @Override
            public IState publishEvent(IState from, IEvent event) {
                String cacheKey = cacheKey(from.getId(), event.getId());
                List<ITransition> internalTransitions = internalTransitionCache.get(cacheKey);
                ITransition externalTransition = externalTransitionCache.get(cacheKey);
                if (CollectionUtil.isEmpty(internalTransitions) && ObjectUtil.isEmpty(externalTransition)) {
                    log.warn("状态机[{}]未找到对应转换组件: from[{}], event[{}]", getId(), from.getId(), event.getId());

                    return null;
                }

                if (CollectionUtil.isNotEmpty(internalTransitions)) {
                    for (ITransition internalTransition : internalTransitions) {
                        ICondition condition = internalTransition.getCondition();
                        if (!condition.isAllowed(event)) {

                            continue;
                        }
                        IAction action = internalTransition.getAction();
                        action.onEvent(event);
                    }
                }

                if (ObjectUtil.isNotEmpty(externalTransition)) {
                    ICondition condition = externalTransition.getCondition();
                    if (!condition.isAllowed(event)) {

                        return null;
                    }
                    IAction action = externalTransition.getAction();
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
