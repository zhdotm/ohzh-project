package io.github.zhdotm.ohzh.ddd.domain.extension;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAbilityExtensionPoint;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAggregateRoot;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainEntity;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainService;
import io.github.zhdotm.ohzh.ddd.domain.enums.DomainExceptionEnum;
import io.github.zhdotm.ohzh.ddd.domain.exceptions.DomainException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 拓展执行器
 *
 * @author zhihao.mao
 */

@Slf4j
public class DomainAbilityExtensionExecutors {

    /**
     * 注册领域能力拓展
     *
     * @param name      名称
     * @param extension 领域能力拓展
     * @param <T>       领域能力拓展类型
     */
    @SneakyThrows
    public static <T extends IDomainAbilityExtensionPoint> void registerExtension(String name, T extension) {
        Class<? extends IDomainAbilityExtensionPoint> extensionClazz = extension.getClass();
        DomainAbilityExtensionPoint domainAbilityExtensionPointAnn = AnnotationUtils.getAnnotation(extensionClazz, DomainAbilityExtensionPoint.class);
        Assert.notNull(domainAbilityExtensionPointAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST, extensionClazz.getSimpleName()));
        if (StrUtil.isBlank(name)) {
            name = domainAbilityExtensionPointAnn.code();
        }

        SpringUtil.registerBean(name, extension);
    }

    /**
     * 获取拓展
     *
     * @param bizScenario            业务身份
     * @param extensionExecutorClazz 拓展执行器类型
     * @param extensionPointClazz    拓展点类型
     */
    @SneakyThrows
    public static <T extends IDomainAbilityExtensionExecutor, R extends IDomainAbilityExtensionPoint> R getExtensionPoint(BizScenario bizScenario,
                                                                                                                          Class<T> extensionExecutorClazz,
                                                                                                                          Class<R> extensionPointClazz) {
        DomainAbilityExtensionPoint domainAbilityExtensionPointAnn = AnnotationUtils.getAnnotation(extensionPointClazz, DomainAbilityExtensionPoint.class);
        Assert.notNull(domainAbilityExtensionPointAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST, extensionPointClazz.getSimpleName()));
        switch (domainAbilityExtensionPointAnn.scope()) {
            case DOMAIN_ENTITY: {
                DomainEntity domainEntityAnn = AnnotationUtils.getAnnotation(extensionExecutorClazz, DomainEntity.class);
                Assert.notNull(domainEntityAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ENTITY_ANNOTATION_NOT_EXIST, extensionExecutorClazz.getSimpleName()));
                Assert.isTrue(domainEntityAnn.code().equalsIgnoreCase(domainAbilityExtensionPointAnn.targetCode()), (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ENTITY_EXTENSION_NOT_MATCH, extensionExecutorClazz.getSimpleName(), extensionPointClazz.getSimpleName()));
                break;
            }
            case DOMAIN_SERVICE: {
                DomainService domainServiceAnn = AnnotationUtils.getAnnotation(extensionExecutorClazz, DomainService.class);
                Assert.notNull(domainServiceAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_SERVICE_ANNOTATION_NOT_EXIST, extensionExecutorClazz.getSimpleName()));
                Assert.isTrue(domainServiceAnn.code().equalsIgnoreCase(domainAbilityExtensionPointAnn.targetCode()), (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_SERVICE_EXTENSION_NOT_MATCH, extensionExecutorClazz.getSimpleName(), extensionPointClazz.getSimpleName()));
                break;
            }
            case AGGREGATE_ROOT: {
                DomainAggregateRoot domainAggregateRootAnn = AnnotationUtils.getAnnotation(extensionExecutorClazz, DomainAggregateRoot.class);
                Assert.notNull(domainAggregateRootAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.AGGREGATE_ROOT_ANNOTATION_NOT_EXIST, extensionExecutorClazz.getSimpleName()));
                Assert.isTrue(domainAggregateRootAnn.code().equalsIgnoreCase(domainAbilityExtensionPointAnn.targetCode()), (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.AGGREGATE_ROOT_EXTENSION_NOT_MATCH, extensionExecutorClazz.getSimpleName(), extensionPointClazz.getSimpleName()));
                break;
            }
            default: {
                break;
            }
        }

        Collection<R> extensions = SpringUtil.getBeansOfType(extensionPointClazz).values();

        List<R> matchedExtensions = extensions
                .stream()
                .filter(extension -> extension.strictMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedExtensions)) {
            Assert.isTrue(matchedExtensions.size() == 1, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_STRICT_MATCH_MANY.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_STRICT_MATCH_MANY.getMessage(bizScenario)));
            R matchedExtension = matchedExtensions.get(0);
            log.info("严格匹配到领域能力拓展点[{}]: {}", bizScenario, matchedExtension.getCode());

            return matchedExtension;
        }

        matchedExtensions = extensions
                .stream()
                .filter(queryExe -> queryExe.looseMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedExtensions)) {
            Assert.isTrue(matchedExtensions.size() == 1, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_LOOSE_MATCH_MANY.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_LOOSE_MATCH_MANY.getMessage(bizScenario)));
            R matchedExtension = matchedExtensions.get(0);
            log.info("松散匹配到领域能力拓展点[{}]: {}", bizScenario, matchedExtension.getCode());

            return matchedExtension;
        }

        throw new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_NOT_MATCH.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_NOT_MATCH.getMessage(bizScenario));
    }

    /**
     * 执行拓展（无返回）
     *
     * @param bizScenario       业务身份
     * @param extensionClazz    拓展类型
     * @param extensionConsumer 拓展消费者
     * @param <T>               拓展类型
     */
    @SneakyThrows
    public static <T extends IDomainAbilityExtensionPoint, U extends IDomainAbilityExtensionExecutor> void execute(BizScenario bizScenario,
                                                                                                                   Class<U> extensionExecutorClazz,
                                                                                                                   Class<T> extensionClazz,
                                                                                                                   Consumer<T> extensionConsumer) {

        extensionConsumer.accept(DomainAbilityExtensionExecutors.getExtensionPoint(bizScenario, extensionExecutorClazz, extensionClazz));
    }

    /**
     * 执行拓展（有返回）
     *
     * @param bizScenario       业务身份
     * @param extensionClazz    拓展类型
     * @param extensionConsumer 拓展消费者
     * @param <T>               拓展类型
     * @return 出参
     */
    @SneakyThrows
    public static <T extends IDomainAbilityExtensionPoint, U extends IDomainAbilityExtensionExecutor, R> R execute(BizScenario bizScenario,
                                                                                                                   Class<U> extensionExecutorClazz,
                                                                                                                   Class<T> extensionClazz,
                                                                                                                   Function<T, R> extensionConsumer) {

        return extensionConsumer.apply(DomainAbilityExtensionExecutors.getExtensionPoint(bizScenario, extensionExecutorClazz, extensionClazz));
    }

}
