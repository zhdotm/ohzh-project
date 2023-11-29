package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id.ActIdUser;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActIdUserMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActIdUserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_ID_USER】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActIdUserRepositoryImpl extends ServiceImpl<ActIdUserMapper, ActIdUser>
        implements ActIdUserRepository {

}




