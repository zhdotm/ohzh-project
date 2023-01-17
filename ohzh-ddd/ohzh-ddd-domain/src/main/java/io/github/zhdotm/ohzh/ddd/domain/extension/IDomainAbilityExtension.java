package io.github.zhdotm.ohzh.ddd.domain.extension;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAbilityExtension;
import io.github.zhdotm.ohzh.ddd.domain.enums.DomainExceptionEnum;
import io.github.zhdotm.ohzh.ddd.domain.exceptions.DomainException;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.function.Supplier;

/**
 * 拓展抽象
 *
 * @author zhihao.mao
 */

public interface IDomainAbilityExtension {

    /**
     * 获取执行器名称
     *
     * @return 执行器名称
     */
    default String getName() {
        DomainAbilityExtension domainAbilityExtensionAnnotation = getDomainAbilityExtensionAnnotation();

        return domainAbilityExtensionAnnotation.name();
    }

    /**
     * 获取执行器编码
     *
     * @return 执行器编码
     */
    default String getCode() {
        DomainAbilityExtension domainAbilityExtensionAnnotation = getDomainAbilityExtensionAnnotation();

        return domainAbilityExtensionAnnotation.code();
    }

    /**
     * 获取领域能力注解
     *
     * @return 领域能力注解
     */
    @SneakyThrows
    default DomainAbilityExtension getDomainAbilityExtensionAnnotation() {
        DomainAbilityExtension queryExecutor = AnnotationUtils.getAnnotation(this.getClass(), DomainAbilityExtension.class);
        String simpleName = this.getClass().getSimpleName();
        Assert.notNull(queryExecutor, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST.getMessage(simpleName)));

        return queryExecutor;
    }

    /**
     * 是否存在DomainAbilityExtension注解
     *
     * @return 是/否
     */
    default Boolean isExistDomainAbilityExtensionAnnotation() {
        DomainAbilityExtension domainAbilityExtensionAnnotation = AnnotationUtils.getAnnotation(this.getClass(), DomainAbilityExtension.class);

        return ObjectUtil.isNotEmpty(domainAbilityExtensionAnnotation);
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
        DomainAbilityExtension domainAbilityExtensionAnn = AnnotatedElementUtils.getMergedAnnotation(this.getClass(), DomainAbilityExtension.class);

        return domainAbilityExtensionAnn.bizId() + StrUtil.DOT + domainAbilityExtensionAnn.useCase() + StrUtil.DOT + domainAbilityExtensionAnn.scenario();
    }

}
