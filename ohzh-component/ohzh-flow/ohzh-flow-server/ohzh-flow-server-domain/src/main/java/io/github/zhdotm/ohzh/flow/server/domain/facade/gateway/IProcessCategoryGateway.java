package io.github.zhdotm.ohzh.flow.server.domain.facade.gateway;

import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.ProcessCategory;

/**
 * 流程分类
 *
 * @author zhihao.mao
 */

public interface IProcessCategoryGateway {

    /**
     * 根据流程分类ID获取流程分类
     *
     * @param procCategoryId 流程分类ID
     * @return 流程分类
     */
    ProcessCategory findByProcCategoryId(String procCategoryId);

}
