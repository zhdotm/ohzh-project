package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.re.ActReDecisionDef;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActReDecisionDefMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActReDecisionDefRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RE_DECISION_DEF】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActReDecisionDefRepositoryImpl extends ServiceImpl<ActReDecisionDefMapper, ActReDecisionDef>
        implements ActReDecisionDefRepository {

}




