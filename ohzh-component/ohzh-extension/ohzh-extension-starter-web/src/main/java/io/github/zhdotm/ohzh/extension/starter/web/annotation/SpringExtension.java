package io.github.zhdotm.ohzh.extension.starter.web.annotation;

import cn.hutool.core.annotation.AliasFor;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 拓展
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@Extension
public @interface SpringExtension {

    /**
     * 拓展名称
     *
     * @return 拓展点名称
     */
    @AliasFor(annotation = Extension.class, attribute = "name")
    String name() default StrUtil.EMPTY;

    /**
     * 拓展编码
     *
     * @return 拓展编码
     */
    @AliasFor(annotation = Extension.class, attribute = "code")
    String code() default StrUtil.EMPTY;

    /**
     * 拓展点
     *
     * @return 拓展点
     */
    @AliasFor(annotation = Extension.class, attribute = "points")
    Extension.ExtensionPoint[] points() default {};

}
