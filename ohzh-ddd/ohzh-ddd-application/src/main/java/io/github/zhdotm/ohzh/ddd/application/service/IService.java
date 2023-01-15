package io.github.zhdotm.ohzh.ddd.application.service;

import io.github.zhdotm.ohzh.ddd.domain.DomainFactory;
import io.github.zhdotm.ohzh.ddd.domain.service.IDomainService;
import lombok.SneakyThrows;

import java.io.Serializable;

/**
 * 业务服务抽象接口
 *
 * @author zhihao.mao
 */

public interface IService extends Serializable {

    /**
     * 获取领域服务
     *
     * @param clazz 服务类型
     * @param <T>   服务类型
     * @return 服务类型
     */
    @SneakyThrows
    public static <T extends IDomainService> T getDomainService(Class<T> clazz) {

        return DomainFactory.getDomainService(clazz);
    }

}
