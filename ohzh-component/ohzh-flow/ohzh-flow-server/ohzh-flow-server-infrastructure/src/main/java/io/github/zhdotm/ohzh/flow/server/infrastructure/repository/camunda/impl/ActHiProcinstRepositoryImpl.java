package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiProcinst;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiProcinstMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiProcinstRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_PROCINST】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiProcinstRepositoryImpl extends ServiceImpl<ActHiProcinstMapper, ActHiProcinst>
        implements ActHiProcinstRepository {

}




