package io.github.zhdotm.ohzh.ddd.domain.aggregate.entity;

import io.github.zhdotm.ohzh.ddd.domain.DomainFactory;

import java.io.Serializable;

/**
 * 聚合根基础接口
 *
 * @author zhihao.mao
 */

public interface IAggregateRoot extends IDomainEntity, Serializable {

    /**
     * 创建领域实体
     *
     * @param clazz 领域实体类型
     * @param <T>   领域实体类型
     * @return 领域实体类型
     */
    default <T extends IDomainEntity> T createDomainEntity(Class<T> clazz) {

        return DomainFactory.createDomainEntity(clazz);
    }

}
