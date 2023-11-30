package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.extra;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 业务类型的信息
 * @TableName ACT_EXTRA_BUSINESS_TYPE
 */
@TableName(value ="ACT_EXTRA_BUSINESS_TYPE")
@Data
public class ActExtraBusinessTypeDO implements Serializable {
    /**
     * 物理主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 业务类型逻辑主键
     */
    @TableField(value = "TYPE_ID")
    private String typeId;

    /**
     * 业务类型名称
     */
    @TableField(value = "TYPE_NAME")
    private String typeName;

    /**
     * 业务类型描述
     */
    @TableField(value = "TYPE_DESC")
    private String typeDesc;

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