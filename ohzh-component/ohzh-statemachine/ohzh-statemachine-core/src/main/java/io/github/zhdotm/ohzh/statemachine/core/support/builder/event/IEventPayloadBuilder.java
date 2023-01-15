package io.github.zhdotm.ohzh.statemachine.core.support.builder.event;

/**
 * @author zhihao.mao
 */

public interface IEventPayloadBuilder<E> {

    IEventIdBuilder<E> id(E eventId);
}
