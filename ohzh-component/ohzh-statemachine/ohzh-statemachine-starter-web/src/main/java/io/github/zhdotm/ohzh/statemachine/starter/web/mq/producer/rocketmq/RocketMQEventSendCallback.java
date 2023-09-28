package io.github.zhdotm.ohzh.statemachine.starter.web.mq.producer.rocketmq;

import io.github.zhdotm.ohzh.statemachine.starter.web.mq.producer.IEventSendCallback;
import lombok.AllArgsConstructor;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author zhihao.mao
 */

@AllArgsConstructor
public class RocketMQEventSendCallback implements SendCallback {
    private final IEventSendCallback eventSendCallback;

    @Override
    public void onSuccess(SendResult sendResult) {
        eventSendCallback.onSuccess(RocketMQEventSendResult.create(sendResult));
    }

    @Override
    public void onException(Throwable throwable) {
        eventSendCallback.onException(throwable);
    }

}
