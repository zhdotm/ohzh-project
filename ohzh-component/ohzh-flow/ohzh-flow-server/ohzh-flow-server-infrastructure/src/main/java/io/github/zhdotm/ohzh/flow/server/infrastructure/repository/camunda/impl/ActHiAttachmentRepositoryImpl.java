package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiAttachment;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiAttachmentMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiAttachmentRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_ATTACHMENT】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:12
 */
@Repository
public class ActHiAttachmentRepositoryImpl extends ServiceImpl<ActHiAttachmentMapper, ActHiAttachment>
        implements ActHiAttachmentRepository {

}




