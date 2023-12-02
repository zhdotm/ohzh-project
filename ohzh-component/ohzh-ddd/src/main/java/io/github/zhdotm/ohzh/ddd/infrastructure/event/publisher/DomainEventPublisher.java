package io.github.zhdotm.ohzh.ddd.infrastructure.event.publisher;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.infrastructure.event.AbstractDomainEvent;

/**
 * 领域事件发布器
 *
 * @author zhihao.mao
 */

public class DomainEventPublisher {

    /**
     * 发布领域事件
     *
     * @param domainEvent 领域事件
     * @param <T>         领域事件类型
     */
    public static <T extends AbstractDomainEvent<?>> void publish(T domainEvent) {
        SpringUtil.publishEvent(domainEvent);
    }

}
