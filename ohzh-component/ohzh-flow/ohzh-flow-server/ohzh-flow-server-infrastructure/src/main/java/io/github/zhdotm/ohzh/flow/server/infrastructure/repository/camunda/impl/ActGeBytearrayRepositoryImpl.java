package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ge.ActGeBytearray;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActGeBytearrayMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActGeBytearrayRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_GE_BYTEARRAY】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:12
 */
@Repository
public class ActGeBytearrayRepositoryImpl extends ServiceImpl<ActGeBytearrayMapper, ActGeBytearray>
        implements ActGeBytearrayRepository {

}



