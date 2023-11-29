package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuJob;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActRuJobMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActRuJobRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_JOB】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuJobRepositoryImpl extends ServiceImpl<ActRuJobMapper, ActRuJob>
        implements ActRuJobRepository {

}




