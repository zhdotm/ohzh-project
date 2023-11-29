package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiActinstDO;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.hi.ActHiActinstMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.ActHiActinstRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_ACTINST】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:12
 */
@Repository
public class ActHiActinstRepositoryImpl extends ServiceImpl<ActHiActinstMapper, ActHiActinstDO>
        implements ActHiActinstRepository {

}




