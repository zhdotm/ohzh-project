package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ge.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ge.ActGePropertyDO;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ge.ActGePropertyMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ge.ActGePropertyRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_GE_PROPERTY】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:12
 */
@Repository
public class ActGePropertyRepositoryImpl extends ServiceImpl<ActGePropertyMapper, ActGePropertyDO>
        implements ActGePropertyRepository {

}




