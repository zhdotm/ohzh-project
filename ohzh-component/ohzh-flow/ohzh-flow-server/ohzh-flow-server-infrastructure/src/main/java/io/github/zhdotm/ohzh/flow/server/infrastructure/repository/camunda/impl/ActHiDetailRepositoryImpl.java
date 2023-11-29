package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiDetail;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiDetailMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiDetailRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_DETAIL】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiDetailRepositoryImpl extends ServiceImpl<ActHiDetailMapper, ActHiDetail>
        implements ActHiDetailRepository {

}




