package io.github.zhdotm.ohzh.ddd.infrastructure.event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 领域事件抽象
 *
 * @author zhihao.mao
 */

@ToString(callSuper = true)
public abstract class AbstractDomainEvent<T> extends ApplicationEvent {

    @Getter
    private final String eventType;

    @Getter
    private final String eventId;

    public AbstractDomainEvent(T source, String eventType, String eventId) {
        super(source);
        this.eventType = eventType;
        this.eventId = eventId;
    }

    @Override
    public T getSource() {

        return (T) super.getSource();
    }

}
