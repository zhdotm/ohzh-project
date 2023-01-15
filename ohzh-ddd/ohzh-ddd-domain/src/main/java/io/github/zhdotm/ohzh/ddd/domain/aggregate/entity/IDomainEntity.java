package io.github.zhdotm.ohzh.ddd.domain.aggregate.entity;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.repository.IRepository;

import java.io.Serializable;

/**
 * 实体基础接口
 *
 * @author zhihao.mao
 */

public interface IDomainEntity extends Serializable {

    /**
     * 获取仓储
     *
     * @param clazz 仓储类
     * @param <T>   仓储类型
     * @return 仓储
     */
    default <T extends IRepository> T getRepository(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

}
