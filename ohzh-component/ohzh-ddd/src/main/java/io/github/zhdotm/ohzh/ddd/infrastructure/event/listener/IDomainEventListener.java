package io.github.zhdotm.ohzh.ddd.infrastructure.event.listener;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.application.service.IApplicationService;
import io.github.zhdotm.ohzh.ddd.domain.aggregation.service.IDomainService;
import io.github.zhdotm.ohzh.ddd.infrastructure.event.AbstractDomainEvent;
import org.springframework.context.ApplicationListener;

/**
 * 领域事件监听器（具体实现一般放在应用服务层）
 *
 * @author zhihao.mao
 */

@FunctionalInterface
public interface IDomainEventListener<E extends AbstractDomainEvent<?>> extends ApplicationListener<E> {

    /**
     * 获取应用服务
     *
     * @param clazz 类
     * @param <T>   应用服务类型
     * @return 领域服务
     */
    default <T extends IApplicationService> T getApplicationService(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

    /**
     * 获取领域服务
     *
     * @param clazz 类
     * @param <T>   领域服务类型
     * @return 领域服务
     */
    default <T extends IDomainService> T getDomainService(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

}
