package io.github.zhdotm.ohzh.ddd.domain;


import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.AggregateRoot;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.DomainEntity;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.IAggregateRoot;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.IDomainEntity;
import io.github.zhdotm.ohzh.ddd.domain.service.DomainService;
import io.github.zhdotm.ohzh.ddd.domain.service.IDomainService;
import io.github.zhdotm.ohzh.ddd.infrastructure.enums.ExceptionEnum;
import io.github.zhdotm.ohzh.ddd.infrastructure.exceptions.CheckException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * 领域工厂
 *
 * @author zhihao.mao
 */

@Slf4j
@Component
public class DomainFactory {

    /**
     * 创建领域实体
     *
     * @param clazz 领域实体类型
     * @param <T>   领域实体类型
     * @return 领域实体类型
     */
    @SneakyThrows
    public static <T extends IDomainEntity> T createDomainEntity(Class<T> clazz) {
        DomainEntity domainEntity = AnnotationUtils.getAnnotation(clazz, DomainEntity.class);
        Assert.notNull(domainEntity, (Supplier<Throwable>) () -> new CheckException(ExceptionEnum.DOMAIN_ENTITY_ANNOTATION_NOT_EXIST));

        return SpringUtil.getBean(clazz);
    }

    /**
     * 获取领域聚合根
     *
     * @param clazz 聚合根类型
     * @param <T>   聚合根类型
     * @return 聚合根类型
     */
    @SneakyThrows
    public static <T extends IAggregateRoot> T getAggregateRoot(Class<T> clazz) {
        AggregateRoot aggregateRoot = AnnotationUtils.getAnnotation(clazz, AggregateRoot.class);
        Assert.notNull(aggregateRoot, (Supplier<Throwable>) () -> new CheckException(ExceptionEnum.AGGREGATE_ROOT_ANNOTATION_NOT_EXIST));

        return SpringUtil.getBean(clazz);
    }

    /**
     * 获取领域服务
     *
     * @param clazz 服务类型
     * @param <T>   服务类型
     * @return 服务类型
     */
    @SneakyThrows
    public static <T extends IDomainService> T getDomainService(Class<T> clazz) {
        DomainService domainService = AnnotationUtils.getAnnotation(clazz, DomainService.class);
        Assert.notNull(domainService, (Supplier<Throwable>) () -> new CheckException(ExceptionEnum.DOMAIN_SERVICE_ANNOTATION_NOT_EXIST));

        return SpringUtil.getBean(clazz);
    }

}
