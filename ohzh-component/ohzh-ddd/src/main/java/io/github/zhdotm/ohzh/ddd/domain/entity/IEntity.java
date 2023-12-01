package io.github.zhdotm.ohzh.ddd.domain.entity;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.ability.IEntityAbility;

/**
 * 领域实体
 *
 * @author zhihao.mao
 */
public interface IEntity {

    /**
     * 获取实体能力
     *
     * @param clazz 类
     * @param <T>   类型
     * @return 实体能力
     */
    default <T extends IEntityAbility> T getAbility(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

}
