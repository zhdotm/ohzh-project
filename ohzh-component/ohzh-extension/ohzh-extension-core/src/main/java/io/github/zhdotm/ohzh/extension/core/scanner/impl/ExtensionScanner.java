package io.github.zhdotm.ohzh.extension.core.scanner.impl;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import io.github.zhdotm.ohzh.extension.core.register.IExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.register.impl.ExtensionRegister;
import io.github.zhdotm.ohzh.extension.core.scanner.IExtensionScanner;
import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 拓展点扫描器
 *
 * @author zhihao.mao
 */

public class ExtensionScanner implements IExtensionScanner {

    private static IExtensionScanner extensionScanner;

    private final IExtensionRegister extensionRegister;

    public ExtensionScanner(IExtensionRegister extensionRegister) {
        this.extensionRegister = extensionRegister;
    }

    public static synchronized IExtensionScanner getInstance(IExtensionScanner extensionScanner) {
        if (ObjectUtil.isEmpty(ExtensionScanner.extensionScanner)) {
            ExtensionScanner.extensionScanner = extensionScanner;
        }

        return ExtensionScanner.extensionScanner;
    }

    public static IExtensionScanner getInstance() {

        return getInstance(ExtensionRegister.getInstance());
    }


    public static synchronized IExtensionScanner getInstance(IExtensionRegister extensionRegister) {
        if (ObjectUtil.isEmpty(extensionScanner)) {
            extensionScanner = new ExtensionScanner(extensionRegister);
        }

        return extensionScanner;
    }

    @Override
    @SneakyThrows
    public synchronized void scanExtensions(String packageName) {
        Set<Class<?>> classes = Optional
                .ofNullable(ClassScanner
                        .scanAllPackage(packageName, clazz ->
                                ClassUtil.isNormalClass(clazz)
                                        && ClassUtil.isAssignable(IExtension.class, clazz)
                                        && AnnotationUtil.hasAnnotation(clazz, Extension.class)))
                .orElse(new HashSet<>());
        for (Class<?> clazz : classes) {
            IExtension extension = (IExtension) clazz.getConstructor().newInstance();
            extensionRegister.register(extension);
        }
    }

    @Override
    public synchronized void importExtension(IExtension extension) {
        extensionRegister.register(extension);
    }

}
