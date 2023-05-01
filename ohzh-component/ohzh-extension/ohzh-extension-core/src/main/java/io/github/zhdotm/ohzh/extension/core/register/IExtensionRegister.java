package io.github.zhdotm.ohzh.extension.core.register;

import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;

/**
 * 拓展注册器
 *
 * @author zhihao.mao
 */

public interface IExtensionRegister {

    /**
     * 注册拓展
     *
     * @param extensions 拓展
     * @param <T>        拓展类型
     */
    <T extends IExtension> void register(T... extensions);

    /**
     * 移除拓展
     *
     * @param extension 拓展
     * @param <T>       拓展类型
     */
    <T extends IExtension> void remove(T extension);

    /**
     * 获取拓展
     *
     * @param coordinate 拓展坐标
     * @param <T>        拓展类型
     */
    <T extends IExtension> T get(ExtensionCoordinate coordinate);
}
