package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.extra;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 流程实例信息
 *
 * @TableName ACT_EXTRA_PROC_INST
 */
@TableName(value = "ACT_EXTRA_PROC_INST")
@Data
public class ActExtraProcInstDO implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 流程实例逻辑主键，CAMUNDA中的BUSINESS_KEY
     */
    @TableField(value = "BUSINESS_KEY")
    private String businessKey;

    /**
     * CAMUNDA中的流程实例ID
     */
    @TableField(value = "PROC_INST_ID")
    private String procInstId;

    /**
     * 流程实例名称
     */
    @TableField(value = "PROC_INST_NAME")
    private String procInstName;

    /**
     * 描述信息
     */
    @TableField(value = "PROC_INST_DESC")
    private String procInstDesc;

    /**
     * 业务类型逻辑主键
     */
    @TableField(value = "BUSINESS_TYPE_ID")
    private String businessTypeId;

    /**
     * 业务类型快照
     */
    @TableField(value = "BUSINESS_TYPE_SNAPSHOT")
    private String businessTypeSnapshot;

    /**
     * 流程分类逻辑主键
     */
    @TableField(value = "PROC_CATEGORY_ID")
    private String procCategoryId;

    /**
     * 流程分类快照
     */
    @TableField(value = "PROC_CATEGORY_SNAPSHOT")
    private String procCategorySnapshot;

    /**
     * CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF
     */
    @TableField(value = "PROC_DEF_ID")
    private String procDefId;

    /**
     * 流程定义快照
     */
    @TableField(value = "PROC_DEF_SNAPSHOT")
    private String procDefSnapshot;

    /**
     * 额外信息
     */
    @TableField(value = "EXTRA_ATTRS")
    private String extraAttrs;

    /**
     * 创建人ID
     */
    @TableField(value = "CREATOR_ID")
    private String creatorId;

    /**
     * 创建人姓名
     */
    @TableField(value = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "CREATED_TIME")
    private LocalDateTime createdTime;

    /**
     * 更新人id
     */
    @TableField(value = "MODIFIER_ID")
    private String modifierId;

    /**
     * 更新人名称
     */
    @TableField(value = "MODIFIED_BY")
    private String modifiedBy;

    /**
     * 更新时间
     */
    @TableField(value = "MODIFIED_TIME")
    private LocalDateTime modifiedTime;

    /**
     * 逻辑删除标志位
     */
    @TableLogic(value = "0", delval = "id")
    @TableField(value = "IS_DELETED")
    private String isDeleted;

}