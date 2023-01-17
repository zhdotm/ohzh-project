package io.github.zhdotm.ohzh.ddd.domain.annotation;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.ddd.domain.enums.DomainAbilityExtensionScopeEnum;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 领域能力拓展
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public @interface DomainAbilityExtension {

    /**
     * 作用范围
     *
     * @return 作用范围
     */
    DomainAbilityExtensionScopeEnum scope();

    /**
     * 拓展名称
     *
     * @return 拓展名称
     */
    String name();

    /**
     * 拓展编码
     *
     * @return 拓展编码
     */
    String code();

    /**
     * 目标编码
     *
     * @return 目标编码
     */
    String targetCode();

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
