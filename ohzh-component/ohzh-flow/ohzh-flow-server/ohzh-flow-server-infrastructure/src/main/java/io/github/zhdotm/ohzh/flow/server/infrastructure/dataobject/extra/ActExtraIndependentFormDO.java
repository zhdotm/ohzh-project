package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.extra;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 独立表单信息
 *
 * @TableName ACT_EXTRA_INDEPENDENT_FORM
 */
@TableName(value = "ACT_EXTRA_INDEPENDENT_FORM")
@Data
public class ActExtraIndependentFormDO implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 表单逻辑主键
     */
    @TableField(value = "FORM_ID")
    private String formId;

    /**
     * 表单的KEY
     */
    @TableField(value = "FORM_KEY")
    private String formKey;

    /**
     * 表单的版本
     */
    @TableField(value = "FORM_VERSION")
    private Integer formVersion;

    /**
     * 表单名称
     */
    @TableField(value = "FORM_NAME")
    private String formName;

    /**
     * 表单的JSON串
     */
    @TableField(value = "FORM_JSON")
    private String formJson;

    /**
     * 描述
     */
    @TableField(value = "FORM_DESC")
    private String formDesc;

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