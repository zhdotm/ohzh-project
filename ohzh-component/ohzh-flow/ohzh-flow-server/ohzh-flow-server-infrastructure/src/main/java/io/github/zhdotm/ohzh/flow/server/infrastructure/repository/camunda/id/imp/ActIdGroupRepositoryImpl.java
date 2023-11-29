package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.id.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id.ActIdGroup;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.id.ActIdGroupMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.id.ActIdGroupRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_ID_GROUP】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActIdGroupRepositoryImpl extends ServiceImpl<ActIdGroupMapper, ActIdGroup>
        implements ActIdGroupRepository {

}




