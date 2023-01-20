package io.github.zhdotm.ohzh.ddd.domain.extension;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAbilityExtensionPoint;
import io.github.zhdotm.ohzh.ddd.domain.enums.DomainExceptionEnum;
import io.github.zhdotm.ohzh.ddd.domain.exceptions.DomainException;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.function.Supplier;

/**
 * 拓展点抽象
 *
 * @author zhihao.mao
 */

public interface IDomainAbilityExtensionPoint {

    /**
     * 获取拓展点名称
     *
     * @return 拓展点名称
     */
    default String getName() {
        DomainAbilityExtensionPoint domainAbilityExtensionPointAnnotation = getDomainAbilityExtensionPointAnnotation();

        return domainAbilityExtensionPointAnnotation.name();
    }

    /**
     * 获取拓展点编码
     *
     * @return 拓展点编码
     */
    default String getCode() {
        DomainAbilityExtensionPoint domainAbilityExtensionPointAnnotation = getDomainAbilityExtensionPointAnnotation();

        return domainAbilityExtensionPointAnnotation.code();
    }

    /**
     * 获取领域能力拓展点注解
     *
     * @return 领域能力拓展点注解
     */
    @SneakyThrows
    default DomainAbilityExtensionPoint getDomainAbilityExtensionPointAnnotation() {
        DomainAbilityExtensionPoint queryExecutor = AnnotationUtils.getAnnotation(this.getClass(), DomainAbilityExtensionPoint.class);
        String simpleName = this.getClass().getSimpleName();
        Assert.notNull(queryExecutor, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST.getMessage(simpleName)));

        return queryExecutor;
    }

    /**
     * 是否存在DomainAbilityExtensionPoint注解
     *
     * @return 是/否
     */
    default Boolean isExistDomainAbilityExtensionPointAnnotation() {
        DomainAbilityExtensionPoint domainAbilityExtensionPointAnnotation = AnnotationUtils.getAnnotation(this.getClass(), DomainAbilityExtensionPoint.class);

        return ObjectUtil.isNotEmpty(domainAbilityExtensionPointAnnotation);
    }

    /**
     * 与该业务场景是否匹配（严格匹配）
     *
     * @param bizScenario 业务场景
     * @return 是/否
     */
    default boolean strictMatch(BizScenario bizScenario) {

        return getMatchKey().equalsIgnoreCase(bizScenario.getUniqueIdentity());
    }

    /**
     * 与该业务场景是否匹配（宽松匹配）
     *
     * @param bizScenario 业务场景
     * @return 是/否
     */
    default boolean looseMatch(BizScenario bizScenario) {

        return getMatchKey().equalsIgnoreCase(bizScenario.getIdentityWithDefaultScenario());
    }

    /**
     * 获取匹配key
     *
     * @return 匹配key
     */
    default String getMatchKey() {
        DomainAbilityExtensionPoint domainAbilityExtensionPointAnn = AnnotatedElementUtils.getMergedAnnotation(this.getClass(), DomainAbilityExtensionPoint.class);

        return domainAbilityExtensionPointAnn.bizId() + StrUtil.DOT + domainAbilityExtensionPointAnn.useCase() + StrUtil.DOT + domainAbilityExtensionPointAnn.scenario();
    }

}
