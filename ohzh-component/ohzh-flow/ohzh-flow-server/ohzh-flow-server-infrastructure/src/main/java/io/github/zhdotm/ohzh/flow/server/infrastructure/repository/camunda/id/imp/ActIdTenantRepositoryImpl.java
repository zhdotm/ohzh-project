package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.id.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id.ActIdTenant;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.id.ActIdTenantMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.id.ActIdTenantRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_ID_TENANT】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActIdTenantRepositoryImpl extends ServiceImpl<ActIdTenantMapper, ActIdTenant>
        implements ActIdTenantRepository {

}




