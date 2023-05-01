package io.github.zhdotm.ohzh.cqrs.starter.web.annotations;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.core.annotations.CQRSExecutor;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 命令执行器
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@CQRSExecutor
public @interface CommandExecutor {

    /**
     * 命令执行器名称
     *
     * @return 命令执行器名称
     */
    String name() default "";

    /**
     * 命令执行器编码
     *
     * @return 命令执行器编码
     */
    @AliasFor(annotation = Component.class, attribute = "value")
    String code();

    /**
     * bizId 用于标识业务，例如“天猫”，如果只有一个业务，则可为空
     *
     * @return 业务
     */
    @AliasFor(annotation = CQRSExecutor.class, attribute = "bizId")
    String bizId() default BizScenario.DEFAULT_BIZ_ID;

    /**
     * 用例用于标识用例，例如“placeOrder”，不能为空
     *
     * @return 用例
     */
    @AliasFor(annotation = CQRSExecutor.class, attribute = "useCase")
    String useCase() default BizScenario.DEFAULT_USE_CASE;

    /**
     * 场景用于标识用例，例如“88VIP”，“正常”，不能为空
     *
     * @return 场景
     */
    @AliasFor(annotation = CQRSExecutor.class, attribute = "scenario")
    String scenario() default BizScenario.DEFAULT_SCENARIO;
}
