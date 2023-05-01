package io.github.zhdotm.ohzh.extension.core.annotation;


import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.point.IExtensionPoint;

import java.lang.annotation.*;

/**
 * 拓展
 *
 * @author zhihao.mao
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Extension {

    /**
     * 拓展名称
     *
     * @return 拓展点名称
     */
    String name() default StrUtil.EMPTY;

    /**
     * 拓展编码
     *
     * @return 拓展编码
     */
    String code() default StrUtil.EMPTY;

    /**
     * 拓展点
     *
     * @return 拓展点
     */
    ExtensionPoint[] points() default {};

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @interface ExtensionPoint {

        /**
         * bizId 用于标识业务，例如“天猫”，如果只有一个业务，则可为空
         *
         * @return 业务
         */
        String bizId() default io.github.zhdotm.ohzh.biz.dto.BizScenario.DEFAULT_BIZ_ID;

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

        /**
         * 拓展点目标接口
         *
         * @return 拓展点目标接口
         */
        Class<? extends IExtensionPoint> targetClazz();
    }
}
