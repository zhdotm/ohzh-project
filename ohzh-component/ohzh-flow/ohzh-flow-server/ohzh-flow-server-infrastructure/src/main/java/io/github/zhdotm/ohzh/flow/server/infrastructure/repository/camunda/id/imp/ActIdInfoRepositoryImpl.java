package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.id.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id.ActIdInfoDO;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.id.ActIdInfoMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.id.ActIdInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_ID_INFO】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActIdInfoRepositoryImpl extends ServiceImpl<ActIdInfoMapper, ActIdInfoDO>
        implements ActIdInfoRepository {

}




