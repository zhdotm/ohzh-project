package io.github.zhdotm.ohzh.cqrs.starter.web.annotations;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.CQRSExecutors;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用CQRS
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(value = {SpringUtil.class, CQRSExecutors.class})
public @interface EnableCQRS {
}
