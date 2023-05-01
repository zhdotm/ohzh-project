package io.github.zhdotm.ohzh.extension.core.repository.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;
import io.github.zhdotm.ohzh.extension.core.exception.ExtensionException;
import io.github.zhdotm.ohzh.extension.core.exception.ExtensionExceptionEnum;
import io.github.zhdotm.ohzh.extension.core.repository.IExtensionRepository;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * 默认拓展仓储
 *
 * @author zhihao.mao
 */

public class ExtensionRepository implements IExtensionRepository {

    private static IExtensionRepository extensionRepository;

    /**
     * 坐标拓展映射
     */
    private final Map<ExtensionCoordinate, IExtension> coordinateExtensionMap;

    private ExtensionRepository() {

        this.coordinateExtensionMap = new HashMap<>();
    }

    public static synchronized IExtensionRepository getInstance() {
        if (ObjectUtil.isEmpty(extensionRepository)) {
            extensionRepository = new ExtensionRepository();
        }

        return extensionRepository;
    }

    @SneakyThrows
    @Override
    public synchronized void put(IExtension extension) {
        for (ExtensionCoordinate coordinate : extension.getCoordinates()) {
            IExtension extensionOld = coordinateExtensionMap.get(coordinate);
            Assert.isNull(extensionOld, (Supplier<Throwable>) () -> new ExtensionException(ExtensionExceptionEnum.EXTENSION_COORDINATE_DUPLICATE.getCode(), ExtensionExceptionEnum.EXTENSION_COORDINATE_DUPLICATE.getMessage(extension.getCode(), extensionOld.getCode(), coordinate)));
            coordinateExtensionMap.put(coordinate, extension);
        }
    }

    @Override
    public synchronized void remove(ExtensionCoordinate coordinate) {
        IExtension extension = coordinateExtensionMap.get(coordinate);
        if (ObjectUtil.isNotEmpty(extension)) {
            Optional.ofNullable(extension.getCoordinates())
                    .orElse(ListUtil.empty())
                    .forEach(coordinateExtensionMap::remove);
        }
    }

    @Override
    public <T extends IExtension> T get(ExtensionCoordinate coordinate) {

        return (T) coordinateExtensionMap.get(coordinate);
    }

}
