package io.github.zhdotm.ohzh.ddd.domain.extension;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAbilityExtension;
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
    public static <T extends IDomainAbilityExtension> void registerExtension(String name, T extension) {
        Class<? extends IDomainAbilityExtension> extensionClazz = extension.getClass();
        DomainAbilityExtension domainAbilityExtensionAnn = AnnotationUtils.getAnnotation(extensionClazz, DomainAbilityExtension.class);
        Assert.notNull(domainAbilityExtensionAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST, extensionClazz.getSimpleName()));
        if (StrUtil.isBlank(name)) {
            name = domainAbilityExtensionAnn.code();
        }

        SpringUtil.registerBean(name, extension);
    }

    /**
     * 获取拓展
     *
     * @param bizScenario            业务身份
     * @param extensionExecutorClazz 拓展执行器类型
     * @param extensionClazz         拓展类型
     */
    @SneakyThrows
    public static <T extends IDomainAbilityExtensionExecutor, R extends IDomainAbilityExtension> R getExtension(BizScenario bizScenario,
                                                                                                                Class<T> extensionExecutorClazz,
                                                                                                                Class<R> extensionClazz) {
        DomainAbilityExtension domainAbilityExtensionAnn = AnnotationUtils.getAnnotation(extensionClazz, DomainAbilityExtension.class);
        Assert.notNull(domainAbilityExtensionAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_ANNOTATION_NOT_EXIST, extensionClazz.getSimpleName()));
        switch (domainAbilityExtensionAnn.scope()) {
            case DOMAIN_ENTITY: {
                DomainEntity domainEntityAnn = AnnotationUtils.getAnnotation(extensionExecutorClazz, DomainEntity.class);
                Assert.notNull(domainEntityAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ENTITY_ANNOTATION_NOT_EXIST, extensionExecutorClazz.getSimpleName()));
                Assert.isTrue(domainEntityAnn.code().equalsIgnoreCase(domainAbilityExtensionAnn.targetCode()), (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ENTITY_EXTENSION_NOT_MATCH, extensionExecutorClazz.getSimpleName(), extensionClazz.getSimpleName()));
                break;
            }
            case DOMAIN_SERVICE: {
                DomainService domainServiceAnn = AnnotationUtils.getAnnotation(extensionExecutorClazz, DomainService.class);
                Assert.notNull(domainServiceAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_SERVICE_ANNOTATION_NOT_EXIST, extensionExecutorClazz.getSimpleName()));
                Assert.isTrue(domainServiceAnn.code().equalsIgnoreCase(domainAbilityExtensionAnn.targetCode()), (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_SERVICE_EXTENSION_NOT_MATCH, extensionExecutorClazz.getSimpleName(), extensionClazz.getSimpleName()));
                break;
            }
            case AGGREGATE_ROOT: {
                DomainAggregateRoot domainAggregateRootAnn = AnnotationUtils.getAnnotation(extensionExecutorClazz, DomainAggregateRoot.class);
                Assert.notNull(domainAggregateRootAnn, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.AGGREGATE_ROOT_ANNOTATION_NOT_EXIST, extensionExecutorClazz.getSimpleName()));
                Assert.isTrue(domainAggregateRootAnn.code().equalsIgnoreCase(domainAbilityExtensionAnn.targetCode()), (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.AGGREGATE_ROOT_EXTENSION_NOT_MATCH, extensionExecutorClazz.getSimpleName(), extensionClazz.getSimpleName()));
                break;
            }
            default: {
                break;
            }
        }

        Collection<R> extensions = SpringUtil.getBeansOfType(extensionClazz).values();

        List<R> matchedExtensions = extensions
                .stream()
                .filter(extension -> extension.strictMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedExtensions)) {
            Assert.isTrue(matchedExtensions.size() == 1, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_STRICT_MATCH_MANY.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_STRICT_MATCH_MANY.getMessage(bizScenario)));
            R matchedExtension = matchedExtensions.get(0);
            log.info("严格匹配到领域能力拓展[{}]: {}", bizScenario, matchedExtension.getCode());

            return matchedExtension;
        }

        matchedExtensions = extensions
                .stream()
                .filter(queryExe -> queryExe.looseMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedExtensions)) {
            Assert.isTrue(matchedExtensions.size() == 1, (Supplier<Throwable>) () -> new DomainException(DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_LOOSE_MATCH_MANY.getCode(), DomainExceptionEnum.DOMAIN_ABILITY_EXTENSION_LOOSE_MATCH_MANY.getMessage(bizScenario)));
            R matchedExtension = matchedExtensions.get(0);
            log.info("松散匹配到领域能力拓展[{}]: {}", bizScenario, matchedExtension.getCode());

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
    public static <T extends IDomainAbilityExtension, U extends IDomainAbilityExtensionExecutor> void execute(BizScenario bizScenario,
                                                                                                              Class<U> extensionExecutorClazz,
                                                                                                              Class<T> extensionClazz,
                                                                                                              Consumer<T> extensionConsumer) {

        extensionConsumer.accept(DomainAbilityExtensionExecutors.getExtension(bizScenario, extensionExecutorClazz, extensionClazz));
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
    public static <T extends IDomainAbilityExtension, U extends IDomainAbilityExtensionExecutor, R> R execute(BizScenario bizScenario,
                                                                                                              Class<U> extensionExecutorClazz,
                                                                                                              Class<T> extensionClazz,
                                                                                                              Function<T, R> extensionConsumer) {

        return extensionConsumer.apply(DomainAbilityExtensionExecutors.getExtension(bizScenario, extensionExecutorClazz, extensionClazz));
    }

}
