package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_INCIDENT
 */
@TableName(value = "ACT_HI_INCIDENT")
@Data
public class ActHiIncident implements Serializable {
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
    @TableField(value = "PROC_DEF_KEY_")
    private String procDefKey;
    /**
     *
     */
    @TableField(value = "PROC_DEF_ID_")
    private String procDefId;
    /**
     *
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     *
     */
    @TableField(value = "PROC_INST_ID_")
    private String procInstId;
    /**
     *
     */
    @TableField(value = "EXECUTION_ID_")
    private String executionId;
    /**
     *
     */
    @TableField(value = "CREATE_TIME_")
    private LocalDateTime createTime;
    /**
     *
     */
    @TableField(value = "END_TIME_")
    private LocalDateTime endTime;
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
    @TableField(value = "HISTORY_CONFIGURATION_")
    private String historyConfiguration;
    /**
     *
     */
    @TableField(value = "INCIDENT_STATE_")
    private Integer incidentState;
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
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
}