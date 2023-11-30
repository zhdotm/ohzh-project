package io.github.zhdotm.ohzh.flow.server.domain.facade.gateway;

import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.BusinessType;

/**
 * 业务类型
 *
 * @author zhihao.mao
 */

public interface IBusinessTypeGateway {

    /**
     * 根据业务类型ID获取业务类型
     *
     * @param businessTypeId 业务类型ID
     * @return 业务类型
     */
    BusinessType findByBusinessTypeId(String businessTypeId);
    
}
