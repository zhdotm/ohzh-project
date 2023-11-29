package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiCaseinst;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.hi.ActHiCaseinstMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.ActHiCaseinstRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_CASEINST】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiCaseinstRepositoryImpl extends ServiceImpl<ActHiCaseinstMapper, ActHiCaseinst>
        implements ActHiCaseinstRepository {

}




