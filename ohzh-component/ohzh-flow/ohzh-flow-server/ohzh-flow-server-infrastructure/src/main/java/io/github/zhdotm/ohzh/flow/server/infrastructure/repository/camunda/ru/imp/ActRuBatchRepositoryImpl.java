package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ru.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru.ActRuBatchDO;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ru.ActRuBatchMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ru.ActRuBatchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_RU_BATCH】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActRuBatchRepositoryImpl extends ServiceImpl<ActRuBatchMapper, ActRuBatchDO>
        implements ActRuBatchRepository {

}




