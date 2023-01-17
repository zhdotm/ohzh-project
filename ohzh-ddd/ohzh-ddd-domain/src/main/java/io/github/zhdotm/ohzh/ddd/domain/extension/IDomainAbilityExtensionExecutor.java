package io.github.zhdotm.ohzh.ddd.domain.extension;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 拓展执行器抽象
 *
 * @author zhihao.mao
 */

public interface IDomainAbilityExtensionExecutor extends Serializable {

    /**
     * 执行拓展（无返回）
     *
     * @param bizScenario       业务身份
     * @param extensionClazz    拓展类型
     * @param extensionConsumer 拓展消费者
     * @param <T>               拓展类型
     */
    @SneakyThrows
    default <T extends IDomainAbilityExtension> void execute(BizScenario bizScenario,
                                                             Class<T> extensionClazz,
                                                             Consumer<T> extensionConsumer) {

        extensionConsumer.accept(DomainAbilityExtensionExecutors.getExtension(bizScenario, this.getClass(), extensionClazz));
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
    default <T extends IDomainAbilityExtension, R> R execute(BizScenario bizScenario,
                                                             Class<T> extensionClazz,
                                                             Function<T, R> extensionConsumer) {

        return extensionConsumer.apply(DomainAbilityExtensionExecutors.getExtension(bizScenario, this.getClass(), extensionClazz));
    }

}
