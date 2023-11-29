package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_TASKINST
 */
@TableName(value = "ACT_HI_TASKINST")
@Data
public class ActHiTaskinstDO implements Serializable {
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
    @TableField(value = "TASK_DEF_KEY_")
    private String taskDefKey;
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
    @TableField(value = "CASE_DEF_KEY_")
    private String caseDefKey;
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
    @TableField(value = "ACT_INST_ID_")
    private String actInstId;
    /**
     *
     */
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "PARENT_TASK_ID_")
    private String parentTaskId;
    /**
     *
     */
    @TableField(value = "DESCRIPTION_")
    private String description;
    /**
     *
     */
    @TableField(value = "OWNER_")
    private String owner;
    /**
     *
     */
    @TableField(value = "ASSIGNEE_")
    private String assignee;
    /**
     *
     */
    @TableField(value = "START_TIME_")
    private LocalDateTime startTime;
    /**
     *
     */
    @TableField(value = "END_TIME_")
    private LocalDateTime endTime;
    /**
     *
     */
    @TableField(value = "DURATION_")
    private Long duration;
    /**
     *
     */
    @TableField(value = "DELETE_REASON_")
    private String deleteReason;
    /**
     *
     */
    @TableField(value = "PRIORITY_")
    private Integer priority;
    /**
     *
     */
    @TableField(value = "DUE_DATE_")
    private LocalDateTime dueDate;
    /**
     *
     */
    @TableField(value = "FOLLOW_UP_DATE_")
    private LocalDateTime followUpDate;
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
}