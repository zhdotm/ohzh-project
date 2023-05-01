package io.github.zhdotm.ohzh.extension.core.repository;

import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;

/**
 * 拓展仓储
 *
 * @author zhihao.mao
 */

public interface IExtensionRepository {

    /**
     * 添加拓展
     *
     * @param extension 拓展
     */
    void put(IExtension extension);

    /**
     * 移除拓展
     *
     * @param coordinate 拓展坐标
     */
    void remove(ExtensionCoordinate coordinate);

    /**
     * 获取拓展
     *
     * @param coordinate 拓展坐标
     * @param <T>        拓展类型
     * @return 拓展
     */
    <T extends IExtension> T get(ExtensionCoordinate coordinate);
}
