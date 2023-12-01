package io.github.zhdotm.ohzh.ddd.domain.event.listener;

import io.github.zhdotm.ohzh.ddd.domain.event.AbstractDomainEvent;
import org.springframework.context.ApplicationListener;

/**
 * 领域事件监听器
 *
 * @author zhihao.mao
 */

@FunctionalInterface
public interface IDomainEventListener<E extends AbstractDomainEvent<?>> extends ApplicationListener<E> {
    
}
