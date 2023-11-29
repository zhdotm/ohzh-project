package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_OP_LOG
 */
@TableName(value = "ACT_HI_OP_LOG")
@Data
public class ActHiOpLogDO implements Serializable {
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
    @TableField(value = "DEPLOYMENT_ID_")
    private String deploymentId;
    /**
     *
     */
    @TableField(value = "PROC_DEF_ID_")
    private String procDefId;
    /**
     *
     */
    @TableField(value = "PROC_DEF_KEY_")
    private String procDefKey;
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
    @TableField(value = "CASE_DEF_ID_")
    private String caseDefId;
    /**
     *
     */
    @TableField(value = "CASE_INST_ID_")
    private String caseInstId;
    /**
     *
     */
    @TableField(value = "CASE_EXECUTION_ID_")
    private String caseExecutionId;
    /**
     *
     */
    @TableField(value = "TASK_ID_")
    private String taskId;
    /**
     *
     */
    @TableField(value = "JOB_ID_")
    private String jobId;
    /**
     *
     */
    @TableField(value = "JOB_DEF_ID_")
    private String jobDefId;
    /**
     *
     */
    @TableField(value = "BATCH_ID_")
    private String batchId;
    /**
     *
     */
    @TableField(value = "USER_ID_")
    private String userId;
    /**
     *
     */
    @TableField(value = "TIMESTAMP_")
    private LocalDateTime timestamp;
    /**
     *
     */
    @TableField(value = "OPERATION_TYPE_")
    private String operationType;
    /**
     *
     */
    @TableField(value = "OPERATION_ID_")
    private String operationId;
    /**
     *
     */
    @TableField(value = "ENTITY_TYPE_")
    private String entityType;
    /**
     *
     */
    @TableField(value = "PROPERTY_")
    private String property;
    /**
     *
     */
    @TableField(value = "ORG_VALUE_")
    private String orgValue;
    /**
     *
     */
    @TableField(value = "NEW_VALUE_")
    private String newValue;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
    /**
     *
     */
    @TableField(value = "CATEGORY_")
    private String category;
    /**
     *
     */
    @TableField(value = "EXTERNAL_TASK_ID_")
    private String externalTaskId;
    /**
     *
     */
    @TableField(value = "ANNOTATION_")
    private String annotation;
}