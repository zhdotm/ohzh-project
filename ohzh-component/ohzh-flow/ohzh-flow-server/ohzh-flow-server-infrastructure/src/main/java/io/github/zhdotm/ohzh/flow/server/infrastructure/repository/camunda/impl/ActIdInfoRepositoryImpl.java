package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id.ActIdInfo;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActIdInfoMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActIdInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_ID_INFO】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActIdInfoRepositoryImpl extends ServiceImpl<ActIdInfoMapper, ActIdInfo>
        implements ActIdInfoRepository {

}




