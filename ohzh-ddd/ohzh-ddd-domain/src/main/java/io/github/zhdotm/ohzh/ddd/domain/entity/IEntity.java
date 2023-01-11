package io.github.zhdotm.ohzh.ddd.domain.entity;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.repository.IRepository;

/**
 * 抽象实体
 *
 * @author zhihao.mao
 */

public interface IEntity {

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
