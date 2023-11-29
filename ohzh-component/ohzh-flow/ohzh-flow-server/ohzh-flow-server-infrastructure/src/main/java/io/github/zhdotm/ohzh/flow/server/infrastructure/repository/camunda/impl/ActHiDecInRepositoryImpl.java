package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiDecIn;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiDecInMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiDecInRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_DEC_IN】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiDecInRepositoryImpl extends ServiceImpl<ActHiDecInMapper, ActHiDecIn>
        implements ActHiDecInRepository {

}




