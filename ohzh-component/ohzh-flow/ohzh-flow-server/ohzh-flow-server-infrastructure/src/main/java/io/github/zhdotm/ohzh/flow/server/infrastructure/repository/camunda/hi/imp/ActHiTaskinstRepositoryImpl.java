package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiTaskinstDO;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.hi.ActHiTaskinstMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.hi.ActHiTaskinstRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_TASKINST】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiTaskinstRepositoryImpl extends ServiceImpl<ActHiTaskinstMapper, ActHiTaskinstDO>
        implements ActHiTaskinstRepository {

}



