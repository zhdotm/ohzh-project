package io.github.zhdotm.ohzh.extension.core.scanner;

import io.github.zhdotm.ohzh.extension.core.IExtension;

/**
 * 拓展点扫描器
 *
 * @author zhihao.mao
 */

public interface IExtensionScanner {

    /**
     * 扫描拓展
     *
     * @param packageName 包名
     */
    void scanExtensions(String packageName);

    /**
     * 导入拓展
     *
     * @param extension 拓展
     */
    void importExtension(IExtension extension);
}
