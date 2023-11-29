package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.re;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_RE_CAMFORMDEF
 */
@TableName(value = "ACT_RE_CAMFORMDEF")
@Data
public class ActReCamformdefDO implements Serializable {
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
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}