package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.re;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_RE_PROCDEF
 */
@TableName(value = "ACT_RE_PROCDEF")
@Data
public class ActReProcdef implements Serializable {
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
    @TableField(value = "HAS_START_FORM_KEY_")
    private Integer hasStartFormKey;
    /**
     *
     */
    @TableField(value = "SUSPENSION_STATE_")
    private Integer suspensionState;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "VERSION_TAG_")
    private String versionTag;
    /**
     *
     */
    @TableField(value = "HISTORY_TTL_")
    private Integer historyTtl;
    /**
     *
     */
    @TableField(value = "STARTABLE_")
    private Integer startable;
}