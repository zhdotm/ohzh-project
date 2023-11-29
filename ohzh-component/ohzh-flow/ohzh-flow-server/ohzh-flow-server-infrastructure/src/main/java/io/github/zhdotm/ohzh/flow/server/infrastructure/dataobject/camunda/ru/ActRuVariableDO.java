package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 该表用于存储流程实例中的变量信息
 *
 * @TableName ACT_RU_VARIABLE
 */
@TableName(value = "ACT_RU_VARIABLE")
@Data
public class ActRuVariableDO implements Serializable {
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
    @TableField(value = "TYPE_")
    private String type;
    /**
     *
     */
    @TableField(value = "NAME_")
    private String name;
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
    @TableField(value = "TASK_ID_")
    private String taskId;
    /**
     *
     */
    @TableField(value = "BATCH_ID_")
    private String batchId;

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
    @TableField(value = "VAR_SCOPE_")
    private String varScope;
    /**
     *
     */
    @TableField(value = "SEQUENCE_COUNTER_")
    private Long sequenceCounter;
    /**
     *
     */
    @TableField(value = "IS_CONCURRENT_LOCAL_")
    private Integer isConcurrentLocal;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}