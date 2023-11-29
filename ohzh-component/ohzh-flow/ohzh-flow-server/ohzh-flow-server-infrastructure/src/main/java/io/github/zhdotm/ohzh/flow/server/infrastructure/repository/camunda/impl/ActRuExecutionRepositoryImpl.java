package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuExecution;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActRuExecutionMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActRuExecutionRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_EXECUTION】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuExecutionRepositoryImpl extends ServiceImpl<ActRuExecutionMapper, ActRuExecution>
        implements ActRuExecutionRepository {

}




