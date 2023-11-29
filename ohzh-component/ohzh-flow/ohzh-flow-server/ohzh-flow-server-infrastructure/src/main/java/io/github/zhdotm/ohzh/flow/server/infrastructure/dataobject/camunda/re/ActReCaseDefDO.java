package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.re;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_RE_CASE_DEF
 */
@TableName(value = "ACT_RE_CASE_DEF")
@Data
public class ActReCaseDefDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "ID_")
    private String id;
    /**
     *
     */
    @TableField(value = "REV_")
    private Integer rev;
    /**
     *
     */
    @TableField(value = "CATEGORY_")
    private String category;
    /**
     *
     */
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "KEY_")
    private String key;
    /**
     *
     */
    @TableField(value = "VERSION_")
    private Integer version;
    /**
     *
     */
    @TableField(value = "DEPLOYMENT_ID_")
    private String deploymentId;
    /**
     *
     */
    @TableField(value = "RESOURCE_NAME_")
    private String resourceName;
    /**
     *
     */
    @TableField(value = "DGRM_RESOURCE_NAME_")
    private String dgrmResourceName;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "HISTORY_TTL_")
    private Integer historyTtl;
}