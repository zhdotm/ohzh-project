package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ru.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuIncident;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ru.ActRuIncidentMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ru.ActRuIncidentRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_INCIDENT】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuIncidentRepositoryImpl extends ServiceImpl<ActRuIncidentMapper, ActRuIncident>
        implements ActRuIncidentRepository {

}




