package io.github.zhdotm.ohzh.statemachine.core.domain;


import io.github.zhdotm.ohzh.statemachine.core.constant.CharacterEnum;
import io.github.zhdotm.ohzh.statemachine.core.constant.PlantUmlFileEnum;
import io.github.zhdotm.ohzh.statemachine.core.constant.PlantUmlTypeEnum;
import io.github.zhdotm.ohzh.statemachine.core.domain.impl.EventContextImpl;
import io.github.zhdotm.ohzh.statemachine.core.domain.impl.EventImpl;
import io.github.zhdotm.ohzh.statemachine.core.exception.StateMachineException;
import io.github.zhdotm.ohzh.statemachine.core.exception.util.ExceptionUtil;
import io.github.zhdotm.ohzh.statemachine.core.log.StateMachineLog;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 状态机
 *
 * @author zhihao.mao
 */

public interface IStateMachine<M, S, E, C, A> {

    ThreadLocal<String> STATEMACHINE_ID_THREAD_LOCAL = new ThreadLocal<>();
    ThreadLocal<String> TRACE_ID_THREAD_LOCAL = new ThreadLocal<>();
    ThreadLocal<String> CURRENT_STATE_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取状态机ID
     *
     * @return 状态机ID
     */
    M getStateMachineId();

    /**
     * 设置状态机ID
     *
     * @param stateMachineId 状态机ID
     * @return 状态机
     */
    IStateMachine<M, S, E, C, A> stateMachineId(M stateMachineId);

    /**
     * 获取所有状态ID
     *
     * @return 状态ID
     */
    Collection<S> getStateIds();

    /**
     * 根据状态ID获取状态
     *
     * @param stateId 状态ID
     * @return 状态
     */
    IState<S, E> getState(S stateId);

    /**
     * 获取外部转换
     *
     * @param stateId 状态ID
     * @param eventId 事件ID
     * @return 转换
     */
    List<ITransition<S, E, C, A>> getExternalTransition(S stateId, E eventId);

    /**
     * 获取内部转换
     *
     * @param stateId 状态ID
     * @param eventId 事件ID
     * @return 转换
     */
    List<ITransition<S, E, C, A>> getInternalTransition(S stateId, E eventId);

    /**
     * 添加转换
     *
     * @param transitions 添加转换
     */
    void addTransitions(List<ITransition<S, E, C, A>> transitions);

    /**
     * 发布事件
     *
     * @param stateId 状态ID
     * @param eventId 事件ID
     * @param payload 事件负载
     * @return 状态上下文
     */
    default IStateContext<S, E> fireEvent(S stateId, E eventId, Object... payload) {
        EventContextImpl<S, E> eventContext = EventContextImpl.getInstance();
        EventImpl<E> event = EventImpl.getInstance();
        event.eventId(eventId)
                .payload(payload);
        eventContext.from(stateId)
                .on(event);

        return fireEvent(eventContext);
    }

    /**
     * 发布事件
     *
     * @param eventContext 事件上下文
     * @return 转换成功后的状态ID
     */
    @SneakyThrows
    default IStateContext<S, E> fireEvent(IEventContext<S, E> eventContext) {
        STATEMACHINE_ID_THREAD_LOCAL.set(String.valueOf(getStateMachineId()));
        TRACE_ID_THREAD_LOCAL.set(UUID.randomUUID().toString());
        CURRENT_STATE_THREAD_LOCAL.set(String.valueOf(eventContext.getStateId()));
        IStateContext<S, E> stateContext = null;
        try {
            S stateId = eventContext.getStateId();
            IEvent<E> event = eventContext.getEvent();
            E eventId = event.getEventId();
            Object[] payload = event.getPayload();

            StateMachineLog.info("状态机流程日志[%s, %s]: 当前%s状态收到携带负载[%s]的事件[%s]", STATEMACHINE_ID_THREAD_LOCAL.get(), TRACE_ID_THREAD_LOCAL.get(), stateId, Arrays.toString(payload), eventId);

            IState<S, E> state = getState(stateId);
            ExceptionUtil.isTrue(state != null, StateMachineException.class, "状态机[%s, %s]发布事件[%s]失败: 不存在对应的%s状态", STATEMACHINE_ID_THREAD_LOCAL.get(), TRACE_ID_THREAD_LOCAL.get(), eventId, stateId);

            Collection<E> eventIds = state.getEventIds();
            ExceptionUtil.isTrue(eventIds.contains(eventId), StateMachineException.class, "状态机[%s, %s]发布事件[%s]失败: 对应%s状态不存在指定事件[%s]", STATEMACHINE_ID_THREAD_LOCAL.get(), TRACE_ID_THREAD_LOCAL.get(), eventId, stateId, eventId);

            List<ITransition<S, E, C, A>> satisfiedInternalTransitions = Optional.ofNullable(getInternalTransition(stateId, eventId))
                    .orElse(new ArrayList<>())
                    .stream()
                    .filter(transition -> transition.getCondition().isSatisfied(eventContext))
                    .sorted(Comparator.comparingInt(ITransition::getSort))
                    .collect(Collectors.toList());

            List<ITransition<S, E, C, A>> satisfiedExternalTransitions = Optional.ofNullable(getExternalTransition(stateId, eventId))
                    .orElse(new ArrayList<>())
                    .stream()
                    .filter(transition -> transition.getCondition().isSatisfied(eventContext))
                    .collect(Collectors.toList());

            ExceptionUtil.isTrue(satisfiedExternalTransitions.size() <= 1, StateMachineException.class, "状态机[%s]发布事件[%s]失败: %s状态指定事件[%S]对应的符合条件的外部转换超过一个", STATEMACHINE_ID_THREAD_LOCAL.get(), eventId, stateId, eventId);

            for (ITransition<S, E, C, A> internalTransition : satisfiedInternalTransitions) {
                stateContext = internalTransition.transfer(eventContext);
            }

            for (ITransition<S, E, C, A> satisfiedExternalTransition : satisfiedExternalTransitions) {

                stateContext = satisfiedExternalTransition.transfer(eventContext);
            }
        } finally {
            STATEMACHINE_ID_THREAD_LOCAL.remove();
            TRACE_ID_THREAD_LOCAL.remove();
            CURRENT_STATE_THREAD_LOCAL.remove();
        }

        return stateContext;
    }

    /**
     * 导出状态机内部uml
     */
    @SneakyThrows
    default void exportPlantUml() {

        exportPlantUml("./", PlantUmlTypeEnum.STATE_DIAGRAM);
    }

    /**
     * 导出状态机内部uml
     *
     * @param filePath 输出文件路径
     */
    @SneakyThrows
    default void exportPlantUml(String filePath) {
        if (!filePath.endsWith(CharacterEnum.LEFT_SLASH.getValue())) {
            filePath = filePath + CharacterEnum.LEFT_SLASH.getValue();
        }
        exportPlantUml(filePath, PlantUmlTypeEnum.STATE_DIAGRAM);
    }

    /**
     * 导出状态机内部uml
     *
     * @param filePath         输出文件路径
     * @param plantUmlTypeEnum uml类型
     */
    @SneakyThrows
    default void exportPlantUml(String filePath, PlantUmlTypeEnum plantUmlTypeEnum) {
        String plantUml = getPlantUml(plantUmlTypeEnum);
        Files.write(Paths.get(filePath + getStateMachineId() + PlantUmlFileEnum.FILE_SUFFIX.getValue()),
                plantUml.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 打印状态机内部结构
     *
     * @return uml
     */
    default String getPlantUml() {

        return getPlantUml(PlantUmlTypeEnum.STATE_DIAGRAM);
    }

    /**
     * 打印状态机内部结构
     *
     * @param plantUmlTypeEnum uml图类型
     * @return uml
     */
    default String getPlantUml(PlantUmlTypeEnum plantUmlTypeEnum) {
        StringBuilder plantUmlStringBuilder = new StringBuilder("@startuml \n");
        if (plantUmlTypeEnum == PlantUmlTypeEnum.SEQUENCE_DIAGRAM
                || plantUmlTypeEnum == PlantUmlTypeEnum.STATE_DIAGRAM) {
            List<S> topStateIds = new ArrayList<>(getStateIds());
            List<S> bottomStateIds = new ArrayList<>();
            getStateIds()
                    .forEach(stateId -> {
                        IState<S, E> state = getState(stateId);
                        state.getEventIds()
                                .forEach(eventId -> {
                                    Optional.ofNullable(getInternalTransition(stateId, eventId))
                                            .orElse(new ArrayList<>())
                                            .forEach(internalTransition -> {
                                                C conditionId = internalTransition.getCondition().getConditionId();
                                                A actionId = internalTransition.getAction().getActionId();

                                                plantUmlStringBuilder
                                                        .append(String.format("%s状态", stateId))
                                                        .append(" --> ")
                                                        .append(String.format("%s状态", stateId))
                                                        .append(" : ")
                                                        .append(String.format("发生%s事件, 判断%s条件, 执行%s动作", eventId, conditionId, actionId))
                                                        .append(" \n");
                                            });
                                    Optional.ofNullable(getExternalTransition(stateId, eventId))
                                            .orElse(new ArrayList<>())
                                            .forEach(externalTransition -> {
                                                C conditionId = externalTransition.getCondition().getConditionId();
                                                A actionId = externalTransition.getAction().getActionId();
                                                S toStateId = externalTransition.getToStateId();
                                                topStateIds.remove(toStateId);
                                                if (!getStateIds().contains(toStateId)) {
                                                    bottomStateIds.add(toStateId);
                                                }
                                                plantUmlStringBuilder
                                                        .append(String.format("%s状态", stateId))
                                                        .append(" --> ")
                                                        .append(String.format("%s状态", toStateId))
                                                        .append(" : ")
                                                        .append(String.format("发生%s事件, 判断%s条件, 执行%s动作", eventId, conditionId, actionId))
                                                        .append(" \n");
                                            });
                                });
                    });
            if (plantUmlTypeEnum == PlantUmlTypeEnum.STATE_DIAGRAM) {
                topStateIds.forEach(stateId -> {
                    plantUmlStringBuilder
                            .append(" [*] ")
                            .append(" --> ")
                            .append(String.format("%s状态", stateId))
                            .append(" \n");
                });
                bottomStateIds.forEach(stateId -> {
                    plantUmlStringBuilder
                            .append(String.format("%s状态", stateId))
                            .append(" --> ")
                            .append(" [*] ")
                            .append(" \n");
                });
            }
        }
        plantUmlStringBuilder.append("@enduml \n");

        return plantUmlStringBuilder.toString();
    }

}
