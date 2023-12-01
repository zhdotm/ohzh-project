package io.github.zhdotm.ohzh.ddd.domain.event.publisher;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.ddd.domain.event.AbstractDomainEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhihao.mao
 */

@Slf4j
public class DomainEventPublisher {

    /**
     * 发布领域事件
     *
     * @param domainEvent 领域事件
     * @param <T>         领域事件类型
     */
    public static <T extends AbstractDomainEvent<?>> void publish(T domainEvent) {
        log.info("领域事件发布: {}", JSONUtil.toJsonStr(domainEvent));
        SpringUtil.publishEvent(domainEvent);
        log.info("领域事件发布处理成功: {},{}", domainEvent.getEventType(), domainEvent.getEventId());
    }

}
