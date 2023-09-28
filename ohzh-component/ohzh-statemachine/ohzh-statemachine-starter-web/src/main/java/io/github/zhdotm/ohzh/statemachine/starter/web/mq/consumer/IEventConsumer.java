package io.github.zhdotm.ohzh.statemachine.starter.web.mq.consumer;

import io.github.zhdotm.ohzh.statemachine.starter.web.mq.message.EventContextMessage;

/**
 * @author zhihao.mao
 */

public interface IEventConsumer {

    /**
     * 消费消息
     *
     * @param message 消息
     */
    void consume(EventContextMessage message);

}
