package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 该表用于存储流程实例中的任务信息
 *
 * @TableName ACT_RU_TASK
 */
@TableName(value = "ACT_RU_TASK")
@Data
public class ActRuTaskDO implements Serializable {
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
    @TableField(value = "EXECUTION_ID_")
    private String executionId;
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
    @TableField(value = "CASE_EXECUTION_ID_")
    private String caseExecutionId;
    /**
     *
     */
    @TableField(value = "CASE_INST_ID_")
    private String caseInstId;
    /**
     *
     */
    @TableField(value = "CASE_DEF_ID_")
    private String caseDefId;
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
    @TableField(value = "TASK_DEF_KEY_")
    private String taskDefKey;
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
    @TableField(value = "DELEGATION_")
    private String delegation;
    /**
     *
     */
    @TableField(value = "PRIORITY_")
    private Integer priority;
    /**
     *
     */
    @TableField(value = "CREATE_TIME_")
    private LocalDateTime createTime;
    /**
     *
     */
    @TableField(value = "LAST_UPDATED_")
    private LocalDateTime lastUpdated;
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
    @TableField(value = "SUSPENSION_STATE_")
    private Integer suspensionState;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}