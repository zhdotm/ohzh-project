package io.github.zhdotm.ohzh.ddd.application.service;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.aggregation.service.IDomainService;
import io.github.zhdotm.ohzh.ddd.domain.facade.IDomainFacade;

/**
 * 应用服务
 *
 * @author zhihao.mao
 */

public interface IApplicationService {

    /**
     * 获取领域门面
     *
     * @param clazz 领域门面类
     * @param <T>   领域门面类型
     * @return 领域门面
     */
    default <T extends IDomainFacade> T getDomainFacade(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

    /**
     * 获取领域服务
     *
     * @param clazz 领域服务类
     * @param <T>   领域服务类型
     * @return 领域服务
     */
    default <T extends IDomainService> T getDomainService(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

}
