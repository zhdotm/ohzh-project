package io.github.zhdotm.ohzh.ddd.domain.aggregate.entity;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.extension.IDomainAbilityExtensionExecutor;
import io.github.zhdotm.ohzh.ddd.domain.repository.IDomainRepository;

import java.io.Serializable;

/**
 * 实体基础接口
 *
 * @author zhihao.mao
 */

public interface IDomainEntity extends IDomainAbilityExtensionExecutor, Serializable {

    /**
     * 获取仓储
     *
     * @param clazz 仓储类
     * @param <T>   仓储类型
     * @return 仓储
     */
    default <T extends IDomainRepository> T getDomainRepository(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

}
