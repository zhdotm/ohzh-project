package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuEventSubscr;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActRuEventSubscrMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActRuEventSubscrRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_EVENT_SUBSCR】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuEventSubscrRepositoryImpl extends ServiceImpl<ActRuEventSubscrMapper, ActRuEventSubscr>
        implements ActRuEventSubscrRepository {

}




