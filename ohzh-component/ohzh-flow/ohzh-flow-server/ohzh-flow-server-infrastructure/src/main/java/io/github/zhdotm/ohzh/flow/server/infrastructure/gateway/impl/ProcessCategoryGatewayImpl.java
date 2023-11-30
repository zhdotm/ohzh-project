package io.github.zhdotm.ohzh.flow.server.infrastructure.gateway.impl;

import io.github.zhdotm.ohzh.flow.server.domain.facade.gateway.IProcessCategoryGateway;
import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.ProcessCategory;
import org.springframework.stereotype.Component;

/**
 * 流程分类
 *
 * @author zhihao.mao
 */

@Component
public class ProcessCategoryGatewayImpl implements IProcessCategoryGateway {

    @Override
    public ProcessCategory findByProcCategoryId(String procCategoryId) {
        return null;
    }

}
