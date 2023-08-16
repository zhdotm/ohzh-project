package io.github.zhdotm.ohzh.extension.core.register.impl;

import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;
import io.github.zhdotm.ohzh.extension.core.register.IExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.repository.IExtensionRepository;
import io.github.zhdotm.ohzh.extension.core.repository.impl.ExtensionRepository;
import lombok.SneakyThrows;

import java.util.Arrays;

/**
 * 扩展点注册器
 *
 * @author zhihao.mao
 */

public class ExtensionRegister implements IExtensionRegister {

    private static volatile IExtensionRegister extensionRegister;

    private final IExtensionRepository extensionRepository;

    private ExtensionRegister(IExtensionRepository extensionRepository) {

        this.extensionRepository = extensionRepository;
    }

    public static synchronized IExtensionRegister getInstance(IExtensionRegister extensionRegister) {
        if (ObjectUtil.isEmpty(ExtensionRegister.extensionRegister)) {
            ExtensionRegister.extensionRegister = extensionRegister;
        }

        return ExtensionRegister.extensionRegister;
    }

    public static IExtensionRegister getInstance() {

        return getInstance(ExtensionRepository.getInstance());
    }

    public static synchronized IExtensionRegister getInstance(IExtensionRepository extensionRepository) {
        if (ObjectUtil.isEmpty(extensionRegister)) {
            extensionRegister = new ExtensionRegister(extensionRepository);
        }

        return extensionRegister;
    }

    @Override
    @SafeVarargs
    @SneakyThrows
    public final <T extends IExtension> void register(T... extensions) {
        Arrays.stream(extensions)
                .forEach(extensionRepository::put);
    }

    @Override
    public <T extends IExtension> void remove(T extension) {
        extension.getCoordinates()
                .forEach(extensionRepository::remove);
    }

    @Override
    public <T extends IExtension> T get(ExtensionCoordinate coordinate) {

        return extensionRepository.get(coordinate);
    }

}
