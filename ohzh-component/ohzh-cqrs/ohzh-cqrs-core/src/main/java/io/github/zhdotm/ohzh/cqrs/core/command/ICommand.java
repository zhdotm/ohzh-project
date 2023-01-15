package io.github.zhdotm.ohzh.cqrs.core.command;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;

import java.io.Serializable;

/**
 * 命令抽象接口
 *
 * @author zhihao.mao
 */

public interface ICommand extends Serializable {

    /**
     * 获取业务场景
     *
     * @return 业务场景
     */
    BizScenario getBizScenario();

}
