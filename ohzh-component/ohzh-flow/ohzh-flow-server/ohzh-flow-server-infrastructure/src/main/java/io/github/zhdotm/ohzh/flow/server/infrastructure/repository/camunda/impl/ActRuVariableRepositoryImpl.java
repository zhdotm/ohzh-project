package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuVariable;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActRuVariableMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActRuVariableRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_VARIABLE】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuVariableRepositoryImpl extends ServiceImpl<ActRuVariableMapper, ActRuVariable>
        implements ActRuVariableRepository {

}




