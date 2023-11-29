package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_ACTINST
 */
@TableName(value = "ACT_HI_ACTINST")
@Data
public class ActHiActinst implements Serializable {
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
    @TableField(value = "PARENT_ACT_INST_ID_")
    private String parentActInstId;
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
    @TableField(value = "ACT_ID_")
    private String actId;
    /**
     *
     */
    @TableField(value = "TASK_ID_")
    private String taskId;
    /**
     *
     */
    @TableField(value = "CALL_PROC_INST_ID_")
    private String callProcInstId;
    /**
     *
     */
    @TableField(value = "CALL_CASE_INST_ID_")
    private String callCaseInstId;
    /**
     *
     */
    @TableField(value = "ACT_NAME_")
    private String actName;
    /**
     *
     */
    @TableField(value = "ACT_TYPE_")
    private String actType;
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
    @TableField(value = "ACT_INST_STATE_")
    private Integer actInstState;
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
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
}