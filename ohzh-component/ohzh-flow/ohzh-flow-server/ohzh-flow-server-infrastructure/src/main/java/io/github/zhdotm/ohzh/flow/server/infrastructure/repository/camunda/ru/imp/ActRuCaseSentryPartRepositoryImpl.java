package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ru.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuCaseSentryPart;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ru.ActRuCaseSentryPartMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ru.ActRuCaseSentryPartRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_CASE_SENTRY_PART】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuCaseSentryPartRepositoryImpl extends ServiceImpl<ActRuCaseSentryPartMapper, ActRuCaseSentryPart>
        implements ActRuCaseSentryPartRepository {

}




