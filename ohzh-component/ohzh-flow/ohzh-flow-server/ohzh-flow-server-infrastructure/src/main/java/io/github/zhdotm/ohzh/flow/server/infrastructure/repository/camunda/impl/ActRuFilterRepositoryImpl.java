package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuFilter;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActRuFilterMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActRuFilterRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_FILTER】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuFilterRepositoryImpl extends ServiceImpl<ActRuFilterMapper, ActRuFilter>
        implements ActRuFilterRepository {

}




