package io.github.zhdotm.ohzh.ddd.domain.entity;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * 实体工厂
 *
 * @author zhihao.mao
 */

@Slf4j
@Component
public class EntityFactory implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    public static <T extends IEntity> T create(Class<T> clazz) {
        Entity entity = AnnotationUtils.getAnnotation(clazz, Entity.class);
        if (ObjectUtils.isEmpty(entity)) {
            log.warn("创建实体失败: {}非实体类", clazz);
            return null;
        }

        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        EntityFactory.applicationContext = applicationContext;
    }

}
