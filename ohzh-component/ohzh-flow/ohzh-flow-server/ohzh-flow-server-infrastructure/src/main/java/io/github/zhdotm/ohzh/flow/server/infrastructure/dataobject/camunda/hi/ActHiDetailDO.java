package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_DETAIL
 */
@TableName(value = "ACT_HI_DETAIL")
@Data
public class ActHiDetailDO implements Serializable {
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
    @TableField(value = "TYPE_")
    private String type;
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
    @TableField(value = "TASK_ID_")
    private String taskId;
    /**
     *
     */
    @TableField(value = "ACT_INST_ID_")
    private String actInstId;
    /**
     *
     */
    @TableField(value = "VAR_INST_ID_")
    private String varInstId;
    /**
     *
     */
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "VAR_TYPE_")
    private String varType;
    /**
     *
     */
    @TableField(value = "REV_")
    private Integer rev;
    /**
     *
     */
    @TableField(value = "TIME_")
    private LocalDateTime time;

    /**
     *
     */
    @TableField(value = "DOUBLE_")
    private Double double_;

    /**
     *
     */
    @TableField(value = "LONG_")
    private Long long_;
    /**
     *
     */
    @TableField(value = "BYTEARRAY_ID_")
    private String bytearrayId;
    /**
     *
     */
    @TableField(value = "TEXT_")
    private String text;
    /**
     *
     */
    @TableField(value = "TEXT2_")
    private String text2;
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
    @TableField(value = "OPERATION_ID_")
    private String operationId;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
    /**
     *
     */
    @TableField(value = "INITIAL_")
    private Integer initial;
}