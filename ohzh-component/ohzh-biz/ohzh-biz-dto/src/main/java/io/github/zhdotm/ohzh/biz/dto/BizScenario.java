package io.github.zhdotm.ohzh.biz.dto;


import lombok.ToString;

/**
 * 来源：https://github.com/alibaba/COLA/blob/master/cola-components/cola-component-dto/src/main/java/com/alibaba/cola/extension/BizScenario.java
 * <p>
 * BizScenario（业务场景）= bizId + useCase + scenario
 *
 * @author zhihao.mao
 */

@ToString
public class BizScenario {
    public final static String DEFAULT_BIZ_ID = "#defaultBizId#";
    public final static String DEFAULT_USE_CASE = "#defaultUseCase#";
    public final static String DEFAULT_SCENARIO = "#defaultScenario#";
    private final static String DOT_SEPARATOR = ".";

    /**
     * bizId 用于标识业务，例如“天猫”，如果只有一个业务，则可为空
     */
    private String bizId = DEFAULT_BIZ_ID;

    /**
     * 用例用于标识用例，例如“placeOrder”，不能为空
     */
    private String useCase = DEFAULT_USE_CASE;

    /**
     * 场景用于标识用例，例如“88VIP”，“正常”，不能为空
     */
    private String scenario = DEFAULT_SCENARIO;

    public static BizScenario valueOf(String bizId, String useCase, String scenario) {
        BizScenario bizScenario = new BizScenario();
        bizScenario.bizId = bizId;
        bizScenario.useCase = useCase;
        bizScenario.scenario = scenario;
        return bizScenario;
    }

    public static BizScenario valueOf(String bizId, String useCase) {
        return BizScenario.valueOf(bizId, useCase, DEFAULT_SCENARIO);
    }

    public static BizScenario valueOf(String bizId) {
        return BizScenario.valueOf(bizId, DEFAULT_USE_CASE, DEFAULT_SCENARIO);
    }

    public static BizScenario newDefault() {
        return BizScenario.valueOf(DEFAULT_BIZ_ID, DEFAULT_USE_CASE, DEFAULT_SCENARIO);
    }

    /**
     * 对于上述情况，BizScenario 将是“tmall.placeOrder.88vip”，使用此代码，我们可以提供“tmall.placeOrder.normal”场景以外的扩展处理。
     *
     * @return 唯一身份
     */
    public String getUniqueIdentity() {
        return bizId + DOT_SEPARATOR + useCase + DOT_SEPARATOR + scenario;
    }

    public String getIdentityWithDefaultScenario() {
        return bizId + DOT_SEPARATOR + useCase + DOT_SEPARATOR + DEFAULT_SCENARIO;
    }

    public String getIdentityWithDefaultUseCase() {
        return bizId + DOT_SEPARATOR + DEFAULT_USE_CASE + DOT_SEPARATOR + DEFAULT_SCENARIO;
    }
}
