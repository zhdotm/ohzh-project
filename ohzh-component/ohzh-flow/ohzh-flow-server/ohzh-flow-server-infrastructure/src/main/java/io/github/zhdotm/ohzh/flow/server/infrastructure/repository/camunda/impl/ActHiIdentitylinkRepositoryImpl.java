package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiIdentitylink;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiIdentitylinkMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiIdentitylinkRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_IDENTITYLINK】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiIdentitylinkRepositoryImpl extends ServiceImpl<ActHiIdentitylinkMapper, ActHiIdentitylink>
        implements ActHiIdentitylinkRepository {

}



