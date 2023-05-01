package io.github.zhdotm.ohzh.extension.starter.web.annotation;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.extension.starter.web.configuration.SpringExtensionConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启拓展功能
 *
 * @author zhihao.mao
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {SpringExtensionConfiguration.class, SpringUtil.class})
public @interface EnableSpringExtension {

}
