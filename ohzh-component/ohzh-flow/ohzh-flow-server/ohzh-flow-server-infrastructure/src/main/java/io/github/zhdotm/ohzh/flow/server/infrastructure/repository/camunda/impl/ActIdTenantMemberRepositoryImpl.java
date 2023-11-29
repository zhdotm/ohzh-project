package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id.ActIdTenantMember;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActIdTenantMemberMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActIdTenantMemberRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_ID_TENANT_MEMBER】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActIdTenantMemberRepositoryImpl extends ServiceImpl<ActIdTenantMemberMapper, ActIdTenantMember>
        implements ActIdTenantMemberRepository {

}



