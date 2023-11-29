package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.re;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RE_DEPLOYMENT
 */
@TableName(value = "ACT_RE_DEPLOYMENT")
@Data
public class ActReDeploymentDO implements Serializable {
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
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "DEPLOY_TIME_")
    private LocalDateTime deployTime;
    /**
     *
     */
    @TableField(value = "SOURCE_")
    private String source;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}