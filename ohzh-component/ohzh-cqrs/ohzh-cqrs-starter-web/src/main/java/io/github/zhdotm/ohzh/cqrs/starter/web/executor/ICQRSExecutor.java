package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.core.annotations.CQRSExecutor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.io.Serializable;

/**
 * 执行器
 *
 * @author zhihao.mao
 */

public interface ICQRSExecutor extends Serializable {

    /**
     * 与该业务场景是否匹配（严格匹配）
     *
     * @param bizScenario 业务场景
     * @return 是/否
     */
    default boolean strictMatch(BizScenario bizScenario) {

        return getMatchKey().equalsIgnoreCase(bizScenario.getUniqueIdentity());
    }

    /**
     * 与该业务场景是否匹配（宽松匹配）
     *
     * @param bizScenario 业务场景
     * @return 是/否
     */
    default boolean looseMatch(BizScenario bizScenario) {

        return getMatchKey().equalsIgnoreCase(bizScenario.getIdentityWithDefaultScenario());
    }

    /**
     * 获取匹配key
     *
     * @return 匹配key
     */
    default String getMatchKey() {
        Class<? extends ICQRSExecutor> aClass = this.getClass();
        CQRSExecutor cqrsExecutor = AnnotatedElementUtils.getMergedAnnotation(this.getClass(), CQRSExecutor.class);

        return cqrsExecutor.bizId() + StrUtil.DOT + cqrsExecutor.useCase() + StrUtil.DOT + cqrsExecutor.scenario();
    }

}
