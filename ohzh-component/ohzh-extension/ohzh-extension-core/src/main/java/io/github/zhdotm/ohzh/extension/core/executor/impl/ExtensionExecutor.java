package io.github.zhdotm.ohzh.extension.core.executor.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;
import io.github.zhdotm.ohzh.extension.core.exception.ExtensionException;
import io.github.zhdotm.ohzh.extension.core.exception.ExtensionExceptionEnum;
import io.github.zhdotm.ohzh.extension.core.executor.IExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.point.IExtensionPoint;
import io.github.zhdotm.ohzh.extension.core.register.IExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.register.impl.ExtensionRegister;
import lombok.SneakyThrows;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 拓展点执行器
 *
 * @author zhihao.mao
 */

public class ExtensionExecutor implements IExtensionExecutor {

    /**
     * 拓展执行器
     */
    private static volatile IExtensionExecutor extensionExecutor;

    /**
     * 拓展注册器
     */
    private final IExtensionRegister extensionRegister;

    private ExtensionExecutor(IExtensionRegister extensionRegister) {

        this.extensionRegister = extensionRegister;
    }

    public static synchronized IExtensionExecutor getInstance(IExtensionExecutor extensionExecutor) {
        if (ObjectUtil.isEmpty(extensionExecutor)) {
            ExtensionExecutor.extensionExecutor = extensionExecutor;
        }

        return ExtensionExecutor.extensionExecutor;
    }

    /**
     * 获取拓展执行器实例
     *
     * @return 拓展执行器实例
     */
    public static IExtensionExecutor getInstance() {

        return getInstance(ExtensionRegister.getInstance());
    }

    /**
     * 获取拓展执行器实例
     *
     * @param extensionRegister 拓展注册器
     * @return 拓展执行器实例
     */
    public static synchronized IExtensionExecutor getInstance(IExtensionRegister extensionRegister) {
        if (ObjectUtil.isEmpty(extensionExecutor)) {
            extensionExecutor = new ExtensionExecutor(extensionRegister);
        }

        return extensionExecutor;
    }

    @Override
    @SneakyThrows
    public <T extends IExtensionPoint> T getExtensionPoint(BizScenario bizScenario,
                                                           Class<T> extensionPointClazz) {
        ExtensionCoordinate extensionCoordinate = ExtensionCoordinate.create(bizScenario, extensionPointClazz);
        IExtension extension = extensionRegister.get(extensionCoordinate);
        Assert.notNull(extension, (Supplier<Throwable>) () -> new ExtensionException(ExtensionExceptionEnum.EXTENSION_COORDINATE_EXTENSION_NOT_EXIST.getCode(), ExtensionExceptionEnum.EXTENSION_COORDINATE_EXTENSION_NOT_EXIST.getMessage(extensionCoordinate)));

        return extension.getExtensionPoint();
    }

    @Override
    @SneakyThrows
    public <T extends IExtensionPoint> void execute(BizScenario bizScenario,
                                                    Class<T> extensionPointClazz,
                                                    Consumer<T> extensionPointConsumer) {

        extensionPointConsumer.accept(getExtensionPoint(bizScenario, extensionPointClazz));
    }

    @Override
    @SneakyThrows
    public <T extends IExtensionPoint, R> R execute(BizScenario bizScenario,
                                                    Class<T> extensionPointClazz,
                                                    Function<T, R> extensionPointFunction) {

        return extensionPointFunction.apply(getExtensionPoint(bizScenario, extensionPointClazz));
    }

}
