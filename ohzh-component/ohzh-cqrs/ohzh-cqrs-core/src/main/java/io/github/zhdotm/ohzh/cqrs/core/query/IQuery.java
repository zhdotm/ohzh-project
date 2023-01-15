package io.github.zhdotm.ohzh.cqrs.core.query;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;

import java.io.Serializable;

/**
 * 查询抽象接口
 *
 * @author zhihao.mao
 */

public interface IQuery extends Serializable {

    /**
     * 获取业务场景
     *
     * @return 业务场景
     */
    BizScenario getBizScenario();
}
