package io.github.zhdotm.ohzh.extension.starter.web.repository;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;
import io.github.zhdotm.ohzh.extension.core.repository.IExtensionRepository;
import io.github.zhdotm.ohzh.extension.core.repository.impl.ExtensionRepository;
import lombok.Getter;
import lombok.Setter;

/**
 * 拓展仓储
 *
 * @author zhihao.mao
 */

public class SpringExtensionRepository implements IExtensionRepository {

    private static volatile SpringExtensionRepository springExtensionRepository;

    @Getter
    @Setter
    private IExtensionRepository innerExtensionRepository = ExtensionRepository.getInstance();

    private SpringExtensionRepository() {
    }

    public static synchronized SpringExtensionRepository getInstance() {
        if (ObjectUtil.isEmpty(springExtensionRepository)) {
            springExtensionRepository = new SpringExtensionRepository();
        }

        return springExtensionRepository;
    }

    @Override
    public void put(IExtension extension) {
        SpringUtil.registerBean(extension.getCode(), extension);
        innerExtensionRepository.put(extension);
    }

    /**
     * 内部拓展存储添加拓展
     *
     * @param extension 拓展
     */
    public void innerPut(IExtension extension) {
        innerExtensionRepository.put(extension);
    }

    @Override
    public void remove(ExtensionCoordinate coordinate) {
        IExtension extension = innerExtensionRepository.get(coordinate);
        innerExtensionRepository.remove(coordinate);
        SpringUtil.unregisterBean(extension.getCode());
    }

    /**
     * 内部拓展存储移除拓展
     *
     * @param coordinate 拓展坐标
     */
    public void innerRemove(ExtensionCoordinate coordinate) {
        innerExtensionRepository.remove(coordinate);
    }

    @Override
    public <T extends IExtension> T get(ExtensionCoordinate coordinate) {

        return innerExtensionRepository.get(coordinate);
    }

}
