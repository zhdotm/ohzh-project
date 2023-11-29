package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiJobLog;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiJobLogMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiJobLogRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_JOB_LOG】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiJobLogRepositoryImpl extends ServiceImpl<ActHiJobLogMapper, ActHiJobLog>
        implements ActHiJobLogRepository {

}




