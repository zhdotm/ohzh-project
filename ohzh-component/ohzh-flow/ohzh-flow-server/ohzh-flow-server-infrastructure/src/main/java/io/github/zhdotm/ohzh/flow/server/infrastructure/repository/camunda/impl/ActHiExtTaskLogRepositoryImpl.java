package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiExtTaskLog;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiExtTaskLogMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiExtTaskLogRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_EXT_TASK_LOG】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiExtTaskLogRepositoryImpl extends ServiceImpl<ActHiExtTaskLogMapper, ActHiExtTaskLog>
        implements ActHiExtTaskLogRepository {

}




