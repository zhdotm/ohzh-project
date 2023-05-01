package io.github.zhdotm.ohzh.extension.core;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import io.github.zhdotm.ohzh.extension.core.coordinate.ExtensionCoordinate;
import io.github.zhdotm.ohzh.extension.core.exception.ExtensionException;
import io.github.zhdotm.ohzh.extension.core.exception.ExtensionExceptionEnum;
import io.github.zhdotm.ohzh.extension.core.point.IExtensionPoint;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 拓展适配器
 *
 * @author zhihao.mao
 */

public interface IExtension {

    /**
     * 获取拓展名称
     *
     * @return 拓展名称
     */
    default String getName() {
        Extension extensionAnnotation = getExtensionAnnotation();

        return extensionAnnotation.name();
    }

    /**
     * 获取拓展编码
     *
     * @return 拓展编码
     */
    default String getCode() {
        Extension extensionAnnotation = getExtensionAnnotation();

        return extensionAnnotation.code();
    }

    /**
     * 获取拓展坐标
     *
     * @return 拓展坐标
     */
    default List<ExtensionCoordinate> getCoordinates() {
        Extension extensionAnnotation = getExtensionAnnotation();
        Extension.ExtensionPoint[] points = extensionAnnotation.points();
        System.out.println(points.length);

        return Arrays.stream(points)
                .map(point -> ExtensionCoordinate.create(BizScenario.valueOf(point.bizId(), point.useCase(), point.scenario()), point.targetClazz()))
                .collect(Collectors.toList());
    }

    /**
     * 获取拓展点
     *
     * @param <T> 拓展点类型
     * @return 拓展点
     */
    default <T extends IExtensionPoint> T getExtensionPoint() {

        return (T) this;
    }

    /**
     * 获取命令拓展注解
     *
     * @return 命令拓展注解
     */
    @SneakyThrows
    default Extension getExtensionAnnotation() {
        Extension extensionAnnotation = AnnotationUtil.getAnnotation(this.getClass(), Extension.class);
        String simpleName = this.getClass().getSimpleName();
        Assert.notNull(extensionAnnotation, (Supplier<Throwable>) () -> new ExtensionException(ExtensionExceptionEnum.EXTENSION_ANNOTATION_NOT_EXIST.getCode(), ExtensionExceptionEnum.EXTENSION_ANNOTATION_NOT_EXIST.getMessage(simpleName)));

        return extensionAnnotation;
    }

}
