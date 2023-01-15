package io.github.zhdotm.ohzh.cqrs.core.annotations;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;

import java.lang.annotation.*;

/**
 * CQRS执行器
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CQRSExecutor {

    /**
     * bizId 用于标识业务，例如“天猫”，如果只有一个业务，则可为空
     *
     * @return 业务
     */
    String bizId() default BizScenario.DEFAULT_BIZ_ID;

    /**
     * 用例用于标识用例，例如“placeOrder”，不能为空
     *
     * @return 用例
     */
    String useCase() default BizScenario.DEFAULT_USE_CASE;

    /**
     * 场景用于标识用例，例如“88VIP”，“正常”，不能为空
     *
     * @return 场景
     */
    String scenario() default BizScenario.DEFAULT_SCENARIO;
}
