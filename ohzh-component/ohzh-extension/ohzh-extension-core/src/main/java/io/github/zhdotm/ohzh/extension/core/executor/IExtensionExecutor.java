package io.github.zhdotm.ohzh.extension.core.executor;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.point.IExtensionPoint;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 拓展执行器
 *
 * @author zhihao.mao
 */

public interface IExtensionExecutor {

    /**
     * 获取拓展点
     *
     * @param bizScenario         业务身份
     * @param extensionPointClazz 拓展点类型
     * @param <T>                 拓展点类型
     * @return 拓展点
     */
    <T extends IExtensionPoint> T getExtensionPoint(BizScenario bizScenario, Class<T> extensionPointClazz);


    /**
     * 执行拓展点（无返回）
     *
     * @param bizScenario            业务身份
     * @param extensionPointClazz    拓展点类型
     * @param extensionPointConsumer 拓展点消费者
     * @param <T>                    拓展点类型
     */
    <T extends IExtensionPoint> void execute(BizScenario bizScenario, Class<T> extensionPointClazz, Consumer<T> extensionPointConsumer);

    /**
     * 执行拓展点（有返回）
     *
     * @param bizScenario            业务身份
     * @param extensionPointClazz    拓展点类型
     * @param extensionPointFunction 拓展点方法
     * @param <T>                    拓展点类型
     * @param <R>                    出参类型
     * @return 出参
     */
    <T extends IExtensionPoint, R> R execute(BizScenario bizScenario, Class<T> extensionPointClazz, Function<T, R> extensionPointFunction);

}
