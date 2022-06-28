package io.github.zhdotm.ohzh.starter.statemachine.assistant;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IAction;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.ICondition;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IStateMachine;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 状态机帮助类
 *
 * @author zhihao.mao
 */
@Slf4j
public class StateMachineAssistant {

    /**
     * 动作组件缓存
     */
    private static final Map<String, IAction> ACTION_CACHE = new ConcurrentHashMap<>();

    /**
     * 条件组件缓存
     */
    private static final Map<String, ICondition> CONDITION_CACHE = new ConcurrentHashMap<>();

    /**
     * 状态机缓存
     */
    private static final Map<String, IStateMachine> STATEMACHINE_CACHE = new ConcurrentHashMap<>();

    /**
     * 添加状态机
     *
     * @param stateMachineId 状态机ID
     * @param stateMachine   状态机
     */
    public static void addStateMachine(String stateMachineId, IStateMachine stateMachine) {
        if (ObjectUtil.isEmpty(stateMachine)) {

            return;
        }

        STATEMACHINE_CACHE.put(stateMachineId, stateMachine);
        log.info("添加状态机到缓存空间成功: stateMachineId[{}]", stateMachineId);
    }

    /**
     * 移除状态机
     *
     * @param stateMachineId 状态机ID
     */
    public static void removeStateMachine(String stateMachineId) {
        if (StrUtil.isEmpty(stateMachineId)) {

            return;
        }

        List<String> conditionCacheKeys = CONDITION_CACHE
                .keySet()
                .stream()
                .filter(cacheKey -> cacheKey.startsWith(stateMachineId))
                .collect(Collectors.toList());
        conditionCacheKeys.forEach(CONDITION_CACHE::remove);

        List<String> actionCacheKeys = ACTION_CACHE
                .keySet()
                .stream()
                .filter(cacheKey -> cacheKey.startsWith(stateMachineId))
                .collect(Collectors.toList());
        actionCacheKeys.forEach(ACTION_CACHE::remove);


        STATEMACHINE_CACHE.remove(stateMachineId);
        log.info("移除缓存空间状态机成功: stateMachineId[{}]", stateMachineId);
    }

    /**
     * 获取状态机
     *
     * @param stateMachineId 状态机ID
     * @return 状态机
     */
    public static IStateMachine getStateMachine(String stateMachineId) {

        return STATEMACHINE_CACHE.get(stateMachineId);
    }

    /**
     * 添加条件组件
     *
     * @param cacheKey  缓存键
     * @param condition 条件组件
     */
    public static void addCondition(String cacheKey, ICondition condition) {
        if (ObjectUtil.isEmpty(condition)) {

            return;
        }

        CONDITION_CACHE.put(cacheKey, condition);
        log.info("添加条件组件到缓存空间成功: cacheKey[{}], conditionId[{}]", cacheKey, condition.getId());
    }

    /**
     * 移除条件组件
     *
     * @param cacheKey 缓存键
     */
    public static void removeCondition(String cacheKey) {
        if (StrUtil.isEmpty(cacheKey)) {

            return;
        }

        CONDITION_CACHE.remove(cacheKey);
        log.info("移除缓存空间条件组件成功: cacheKey[{}]", cacheKey);
    }

    /**
     * 获取条件组件
     *
     * @param cacheKey 缓存键
     * @return 条件组件
     */
    public static ICondition getCondition(String cacheKey) {

        return CONDITION_CACHE.get(cacheKey);
    }

    /**
     * 添加动作组件
     *
     * @param cacheKey 缓存键
     * @param action   动作组件
     */
    public static void addAction(String cacheKey, IAction action) {
        if (ObjectUtil.isEmpty(action)) {

            return;
        }

        ACTION_CACHE.put(cacheKey, action);
        log.info("添加动作组件到缓存空间成功: cacheKey[{}], actionId[{}]", cacheKey, action.getId());
    }

    /**
     * 移除动作组件
     *
     * @param cacheKey 缓存键
     */
    public static void removeAction(String cacheKey) {
        if (StrUtil.isEmpty(cacheKey)) {

            return;
        }

        ACTION_CACHE.remove(cacheKey);
        log.info("移除缓存空间动作组件成功: cacheKey[{}]", cacheKey);
    }

    /**
     * 获取动作组件
     *
     * @param cacheKey 缓存键
     * @return 动作组件
     */
    public static IAction getAction(String cacheKey) {

        return ACTION_CACHE.get(cacheKey);
    }

    /**
     * 获取缓存键
     *
     * @param stateMachineId 状态机ID
     * @param transitionId   转换ID
     * @return 缓存键
     */
    public static String getCacheKey(String stateMachineId, String transitionId) {

        return stateMachineId + StrUtil.UNDERLINE + transitionId;
    }
}
