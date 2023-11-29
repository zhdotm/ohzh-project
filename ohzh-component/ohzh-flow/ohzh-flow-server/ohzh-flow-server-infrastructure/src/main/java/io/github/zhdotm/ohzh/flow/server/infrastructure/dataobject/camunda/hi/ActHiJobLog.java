package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_JOB_LOG
 */
@TableName(value = "ACT_HI_JOB_LOG")
@Data
public class ActHiJobLog implements Serializable {
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
    @TableField(value = "TIMESTAMP_")
    private LocalDateTime timestamp;
    /**
     *
     */
    @TableField(value = "JOB_ID_")
    private String jobId;
    /**
     *
     */
    @TableField(value = "JOB_DUEDATE_")
    private LocalDateTime jobDuedate;
    /**
     *
     */
    @TableField(value = "JOB_RETRIES_")
    private Integer jobRetries;
    /**
     *
     */
    @TableField(value = "JOB_PRIORITY_")
    private Long jobPriority;
    /**
     *
     */
    @TableField(value = "JOB_EXCEPTION_MSG_")
    private String jobExceptionMsg;
    /**
     *
     */
    @TableField(value = "JOB_EXCEPTION_STACK_ID_")
    private String jobExceptionStackId;
    /**
     *
     */
    @TableField(value = "JOB_STATE_")
    private Integer jobState;
    /**
     *
     */
    @TableField(value = "JOB_DEF_ID_")
    private String jobDefId;
    /**
     *
     */
    @TableField(value = "JOB_DEF_TYPE_")
    private String jobDefType;
    /**
     *
     */
    @TableField(value = "JOB_DEF_CONFIGURATION_")
    private String jobDefConfiguration;
    /**
     *
     */
    @TableField(value = "ACT_ID_")
    private String actId;
    /**
     *
     */
    @TableField(value = "FAILED_ACT_ID_")
    private String failedActId;
    /**
     *
     */
    @TableField(value = "EXECUTION_ID_")
    private String executionId;
    /**
     *
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     *
     */
    @TableField(value = "PROCESS_INSTANCE_ID_")
    private String processInstanceId;
    /**
     *
     */
    @TableField(value = "PROCESS_DEF_ID_")
    private String processDefId;
    /**
     *
     */
    @TableField(value = "PROCESS_DEF_KEY_")
    private String processDefKey;
    /**
     *
     */
    @TableField(value = "DEPLOYMENT_ID_")
    private String deploymentId;
    /**
     *
     */
    @TableField(value = "SEQUENCE_COUNTER_")
    private Long sequenceCounter;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "HOSTNAME_")
    private String hostname;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
}