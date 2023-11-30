package io.github.zhdotm.ohzh.flow.server.infrastructure.gateway.impl;

import io.github.zhdotm.ohzh.flow.server.domain.facade.gateway.IBusinessTypeGateway;
import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.BusinessType;
import org.springframework.stereotype.Component;

/**
 * 业务类型
 *
 * @author zhihao.mao
 */

@Component
public class BusinessTypeGatewayImpl implements IBusinessTypeGateway {

    @Override
    public BusinessType findByBusinessTypeId(String businessTypeId) {

        return null;
    }

}
