package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiOpLogDO;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.hi.ActHiOpLogMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.ActHiOpLogRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_OP_LOG】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiOpLogRepositoryImpl extends ServiceImpl<ActHiOpLogMapper, ActHiOpLogDO>
        implements ActHiOpLogRepository {

}




