package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.extra;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 流程实例信息
 * @TableName ACT_EXTRA_PROC_INST
 */
@TableName(value ="ACT_EXTRA_PROC_INST")
@Data
public class ActExtraProcInstDO implements Serializable {
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
     * 业务类型名称
     */
    @TableField(value = "BUSINESS_TYPE_NAME")
    private String businessTypeName;

    /**
     * 流程分类逻辑主键
     */
    @TableField(value = "PROC_CATEGORY_ID")
    private String procCategoryId;

    /**
     * 分类名称
     */
    @TableField(value = "PROC_CATEGORY_NAME")
    private String procCategoryName;

    /**
     * 分类展示图标
     */
    @TableField(value = "PROC_CATEGORY_ICON_URL")
    private String procCategoryIconUrl;

    /**
     * CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF
     */
    @TableField(value = "PROC_DEF_ID")
    private String procDefId;

    /**
     * CAMUNDA中的流程定义KEY，关联到ACT_RE_PROCDEF的KEY
     */
    @TableField(value = "PROC_DEF_KEY")
    private String procDefKey;

    /**
     * CAMUNDA中的流程定义版本，关联到ACT_RE_PROCDEF的VERSION
     */
    @TableField(value = "PROC_DEF_VERSION")
    private Integer procDefVersion;

    /**
     * 流程定义名称
     */
    @TableField(value = "PROC_DEF_NAME")
    private String procDefName;

    /**
     * 分类展示图标
     */
    @TableField(value = "PROC_DEF_ICON_URL")
    private String procDefIconUrl;

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
    @TableField(value = "IS_DELETED")
    @TableLogic(value = "0", delval = "id")
    private String isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}