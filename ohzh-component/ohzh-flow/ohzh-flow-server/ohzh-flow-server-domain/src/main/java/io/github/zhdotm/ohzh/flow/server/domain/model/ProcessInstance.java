package io.github.zhdotm.ohzh.flow.server.domain.model;

import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.BusinessType;
import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.ProcessCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 流程实例
 *
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class ProcessInstance {

    /**
     * 流程实例逻辑主键，CAMUNDA中的BUSINESS_KEY
     */
    private String businessKey;

    /**
     * CAMUNDA中的流程实例ID
     */
    private String procInstId;

    /**
     * 流程实例名称
     */
    private String procInstName;

    /**
     * 描述信息
     */
    private String procInstDesc;

    /**
     * 业务类型逻辑主键
     */
    private String businessTypeId;

    /**
     * 业务类型快照
     */
    private BusinessType businessTypeSnapshot;

    /**
     * 流程分类逻辑主键
     */
    private String procCategoryId;

    /**
     * 流程分类快照
     */
    private ProcessCategory procCategorySnapshot;

    /**
     * CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF
     */
    private String procDefId;

    /**
     * 流程定义快照
     */
    private ProcessDefinition procDefSnapshot;

    /**
     * 额外信息
     */
    private String extraAttrs;

    /**
     * 创建人ID
     */
    private String creatorId;

    /**
     * 创建人姓名
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人id
     */
    private String modifierId;

    /**
     * 更新人名称
     */
    private String modifiedBy;

    /**
     * 更新时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 逻辑删除标志位
     */
    private String isDeleted;
    
}
