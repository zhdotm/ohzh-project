package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiBatch;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiBatchMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiBatchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_BATCH】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiBatchRepositoryImpl extends ServiceImpl<ActHiBatchMapper, ActHiBatch>
        implements ActHiBatchRepository {

}




