package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.extra;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 流程分类
 * @TableName ACT_EXTRA_PROC_CATEGORY
 */
@TableName(value ="ACT_EXTRA_PROC_CATEGORY")
@Data
public class ActExtraProcCategoryDO implements Serializable {
    /**
     * 物理主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 流程分类逻辑主键
     */
    @TableField(value = "CATEGORY_ID")
    private String categoryId;

    /**
     * 分类名称
     */
    @TableField(value = "CATEGORY_NAME")
    private String categoryName;

    /**
     * 分类展示图标
     */
    @TableField(value = "ICON_URL")
    private String iconUrl;

    /**
     * 流程分类描述
     */
    @TableField(value = "CATEGORY_DESC")
    private String categoryDesc;

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