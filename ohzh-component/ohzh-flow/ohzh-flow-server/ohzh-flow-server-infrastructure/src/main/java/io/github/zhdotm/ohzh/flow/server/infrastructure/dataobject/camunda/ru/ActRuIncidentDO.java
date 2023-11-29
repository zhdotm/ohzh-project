package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_INCIDENT
 */
@TableName(value = "ACT_RU_INCIDENT")
@Data
public class ActRuIncidentDO implements Serializable {
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
    @TableField(value = "INCIDENT_TIMESTAMP_")
    private LocalDateTime incidentTimestamp;
    /**
     *
     */
    @TableField(value = "INCIDENT_MSG_")
    private String incidentMsg;
    /**
     *
     */
    @TableField(value = "INCIDENT_TYPE_")
    private String incidentType;
    /**
     *
     */
    @TableField(value = "EXECUTION_ID_")
    private String executionId;
    /**
     *
     */
    @TableField(value = "ACTIVITY_ID_")
    private String activityId;
    /**
     *
     */
    @TableField(value = "FAILED_ACTIVITY_ID_")
    private String failedActivityId;
    /**
     *
     */
    @TableField(value = "PROC_INST_ID_")
    private String procInstId;
    /**
     *
     */
    @TableField(value = "PROC_DEF_ID_")
    private String procDefId;
    /**
     *
     */
    @TableField(value = "CAUSE_INCIDENT_ID_")
    private String causeIncidentId;
    /**
     *
     */
    @TableField(value = "ROOT_CAUSE_INCIDENT_ID_")
    private String rootCauseIncidentId;
    /**
     *
     */
    @TableField(value = "CONFIGURATION_")
    private String configuration;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "JOB_DEF_ID_")
    private String jobDefId;
    /**
     *
     */
    @TableField(value = "ANNOTATION_")
    private String annotation;
}