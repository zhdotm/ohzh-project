package io.github.zhdotm.ohzh.statemachine.starter.web.mq.consumer.rocketmq;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.statemachine.starter.web.configuration.properties.StateMachineProperties;
import io.github.zhdotm.ohzh.statemachine.starter.web.enums.StateMachineMQEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.enums.StateMachineScopeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.mq.consumer.IEventConsumer;
import io.github.zhdotm.ohzh.statemachine.starter.web.mq.message.EventContextMessage;
import io.github.zhdotm.ohzh.statemachine.starter.web.support.StateMachineSupport;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhihao.mao
 */

@Slf4j
public class RocketMQEventConsumer implements SmartInitializingSingleton, DisposableBean, IEventConsumer {

    private final Map<String, DefaultMQPushConsumer> topicConsumer = MapUtil.newConcurrentHashMap();

    @SneakyThrows
    @Override
    public void afterSingletonsInstantiated() {
        StateMachineProperties stateMachineProperties = SpringUtil.getBean(StateMachineProperties.class);
        String scope = stateMachineProperties.getScope();
        if (!StateMachineScopeEnum.REMOTE.getCode().equalsIgnoreCase(scope)) {
            return;
        }
        RocketMQProperties rocketMQProperties = SpringUtil.getBean(RocketMQProperties.class);
        List<String> stateMachineCodes = Optional.ofNullable(stateMachineProperties.getRemoteCodes())
                .orElse(ListUtil.empty())
                .stream()
                .distinct()
                .collect(Collectors.toList());
        for (String stateMachineCode : stateMachineCodes) {
            String consumerGroup = stateMachineCode + StrUtil.UNDERLINE + SpringUtil.getApplicationName() + StateMachineMQEnum.CONSUMER_GROUP_NAME_SUFFIX.getCode();
            RocketMQProperties.Consumer mqPropertiesConsumer = rocketMQProperties.getConsumer();
            String accessKey = mqPropertiesConsumer.getAccessKey();
            String secretKey = mqPropertiesConsumer.getSecretKey();
            AclClientRPCHook rpcHook = null;
            if (StrUtil.isNotBlank(accessKey) && StrUtil.isNotBlank(secretKey)) {
                rpcHook = new AclClientRPCHook(new SessionCredentials(accessKey, secretKey));
            }
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(StateMachineMQEnum.TOPIC_NAME_SPACE.getCode(), consumerGroup, rpcHook, new AllocateMessageQueueAveragely(),
                    Boolean.TRUE, stateMachineCode);
            consumer.setNamesrvAddr(rocketMQProperties.getNameServer());
            MessageSelector messageSelector = MessageSelector.byTag("*");
            consumer.subscribe(stateMachineCode, messageSelector);
            consumer.setMessageListener(new DefaultMessageListenerConcurrently());
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            consumer.start();
            log.info("启动状态机[{}]消费者", stateMachineCode);

            topicConsumer.put(stateMachineCode, consumer);
        }
    }

    @Override
    public void destroy() throws Exception {
        topicConsumer.forEach((topic, consumer) -> consumer.shutdown());
        topicConsumer.clear();
        log.info("关闭状态机事件消费者");
    }

    @SneakyThrows
    @Override
    public void consume(EventContextMessage message) {
        if (ObjectUtil.isEmpty(message)) {
            return;
        }
        Map<String, String> extraProperties = message.getExtraProperties();
        String stateMachineCode = extraProperties.get(StateMachineMQEnum.STATE_MACHINE_CODE.getCode());
        String stateCode = extraProperties.get(StateMachineMQEnum.STATE_CODE.getCode());
        String eventCode = extraProperties.get(StateMachineMQEnum.EVENT_CODE.getCode());
        String payloadClazzNameArrayStr = extraProperties.get(StateMachineMQEnum.PAYLOAD_CLAZZ_NAME_ARRAY.getCode());
        if (StrUtil.isBlank(payloadClazzNameArrayStr)) {
            StateMachineSupport.fireEvent(stateMachineCode, stateCode, eventCode);
        }
        String bodyStr = message.getBody();
        JSONArray bodyArray = JSONUtil.parseArray(bodyStr);
        JSONArray payloadClazzNameArray = JSONUtil.parseArray(payloadClazzNameArrayStr);
        Object[] payload = new Object[payloadClazzNameArray.size()];
        for (int i = 0; i < payloadClazzNameArray.size(); i++) {
            String payloadClazzName = payloadClazzNameArray.get(i, String.class);
            Class<?> clazz = Class.forName(payloadClazzName);
            payload[i] = bodyArray.get(i, clazz);
        }
        StateMachineSupport.fireEvent(stateMachineCode, stateCode, eventCode, payload);
    }

    public class DefaultMessageListenerConcurrently implements MessageListenerConcurrently {

        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            for (MessageExt messageExt : msgs) {
                log.debug("received msg: {}", messageExt);
                try {
                    long now = System.currentTimeMillis();
                    consume(EventContextMessage.create(messageExt));
                    long costTime = System.currentTimeMillis() - now;
                    log.debug("consume {} cost: {} ms", messageExt.getMsgId(), costTime);
                } catch (Exception e) {
                    log.warn("consume message failed. messageId:{}, topic:{}, reconsumeTimes:{}", messageExt.getMsgId(), messageExt.getTopic(), messageExt.getReconsumeTimes(), e);
                    context.setDelayLevelWhenNextConsume(0);
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }
}
