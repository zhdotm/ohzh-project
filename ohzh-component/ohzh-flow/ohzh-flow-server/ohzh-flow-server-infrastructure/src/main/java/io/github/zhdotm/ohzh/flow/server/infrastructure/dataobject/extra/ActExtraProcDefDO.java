package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.extra;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 流程定义
 * @TableName ACT_EXTRA_PROC_DEF
 */
@TableName(value ="ACT_EXTRA_PROC_DEF")
@Data
public class ActExtraProcDefDO implements Serializable {
    /**
     * 物理主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF
     */
    @TableField(value = "DEF_ID")
    private String defId;

    /**
     * CAMUNDA中的流程定义KEY，关联到ACT_RE_PROCDEF的KEY
     */
    @TableField(value = "DEF_KEY")
    private String defKey;

    /**
     * CAMUNDA中的流程定义版本，关联到ACT_RE_PROCDEF的VERSION
     */
    @TableField(value = "DEF_VERSION")
    private Integer defVersion;

    /**
     * 流程定义名称
     */
    @TableField(value = "DEF_NAME")
    private String defName;

    /**
     * 流程定义的状态，0-禁用 1-启用
     */
    @TableField(value = "DEF_STATUS")
    private Integer defStatus;

    /**
     * 流程分类ID
     */
    @TableField(value = "PROC_CATEGORY_ID")
    private String procCategoryId;

    /**
     * 当前流程定义所属的业务类型，用于关联具体业务
     */
    @TableField(value = "BUSINESS_TYPE_ID")
    private String businessTypeId;

    /**
     * 分类展示图标
     */
    @TableField(value = "ICON_URL")
    private String iconUrl;

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
    private String isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}