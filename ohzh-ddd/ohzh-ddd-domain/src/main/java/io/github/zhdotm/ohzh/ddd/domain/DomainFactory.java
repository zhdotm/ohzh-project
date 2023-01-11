package io.github.zhdotm.ohzh.ddd.domain;


import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.entity.Entity;
import io.github.zhdotm.ohzh.ddd.domain.entity.IEntity;
import io.github.zhdotm.ohzh.ddd.infrastructure.enums.ExpEnum;
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

    @SneakyThrows
    public static <T extends IEntity> T createEntity(Class<T> clazz) {
        Entity entity = AnnotationUtils.getAnnotation(clazz, Entity.class);
        Assert.notNull(entity, (Supplier<Throwable>) () -> new CheckException(ExpEnum.ENTITY_ANNOTATION_NOT_EXIST));

        return SpringUtil.getBean(clazz);
    }

}
