package io.github.zhdotm.ohzh.starter.statemachine.processor;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IAction;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.ICondition;
import io.github.zhdotm.ohzh.starter.statemachine.annotation.Action;
import io.github.zhdotm.ohzh.starter.statemachine.annotation.Condition;
import io.github.zhdotm.ohzh.starter.statemachine.assistant.StateMachineAssistant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 状态机后置处理器
 *
 * @author zhihao.mao
 */
public class StateMachineBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Action action = AnnotationUtil.getAnnotation(clazz, Action.class);
        if (ObjectUtil.isNotEmpty(action)) {
            Assert.isTrue(bean instanceof IAction, "生成状态机动作组件失败[{}]: 未实现IAction接口", beanName);
            String stateMachineId = action.stateMachineId();
            String transitionId = action.transitionId();
            String cacheKey = StateMachineAssistant.getCacheKey(stateMachineId, transitionId);
            StateMachineAssistant.addAction(cacheKey, (IAction) bean);
        }

        Condition condition = AnnotationUtil.getAnnotation(clazz, Condition.class);
        if (ObjectUtil.isNotEmpty(condition)) {
            Assert.isTrue(bean instanceof ICondition, "生成状态机条件组件失败[{}]: 未实现ICondition接口", beanName);
            String stateMachineId = condition.stateMachineId();
            String transitionId = condition.transitionId();
            String cacheKey = StateMachineAssistant.getCacheKey(stateMachineId, transitionId);
            StateMachineAssistant.addCondition(cacheKey, (ICondition) bean);
        }

        return bean;
    }

}
