package io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi.ActHiComment;
import io.github.zhdotm.ohzh.flow.server.infrastructure.mapper.camunda.ActHiCommentMapper;
import io.github.zhdotm.ohzh.flow.server.infrastructure.repository.camunda.ActHiCommentRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhihao.mao
 * @description 针对表【ACT_HI_COMMENT】的数据库操作Repository实现
 * @createDate 2023-11-29 15:04:13
 */
@Repository
public class ActHiCommentRepositoryImpl extends ServiceImpl<ActHiCommentMapper, ActHiComment>
        implements ActHiCommentRepository {

}




