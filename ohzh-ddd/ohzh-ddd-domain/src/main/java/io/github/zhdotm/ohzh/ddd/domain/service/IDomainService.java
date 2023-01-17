package io.github.zhdotm.ohzh.ddd.domain.service;

import io.github.zhdotm.ohzh.ddd.domain.DomainFactory;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.IDomainAggregateRoot;
import io.github.zhdotm.ohzh.ddd.domain.extension.IDomainAbilityExtensionExecutor;
import lombok.SneakyThrows;

import java.io.Serializable;

/**
 * 领域服务
 * 跨实体的业务逻辑代码在领域服务中实现
 *
 * @author zhihao.mao
 */

public interface IDomainService extends IDomainAbilityExtensionExecutor, Serializable {

    /**
     * 获取领域聚合根
     *
     * @param clazz 聚合根类型
     * @param <T>   聚合根类型
     * @return 聚合根类型
     */
    @SneakyThrows
    default <T extends IDomainAggregateRoot> T getAggregateRoot(Class<T> clazz) {

        return DomainFactory.getAggregateRoot(clazz);
    }

}
