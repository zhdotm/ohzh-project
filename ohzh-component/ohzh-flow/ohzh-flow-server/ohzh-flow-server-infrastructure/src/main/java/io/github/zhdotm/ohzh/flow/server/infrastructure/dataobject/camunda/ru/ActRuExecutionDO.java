package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 该表用于存储流程实例的执行情况
 *
 * @TableName ACT_RU_EXECUTION
 */
@TableName(value = "ACT_RU_EXECUTION")
@Data
public class ActRuExecutionDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键，自增长
     */
    @TableId(value = "ID_")
    private String id;
    /**
     *
     */
    @TableField(value = "REV_")
    private Integer rev;
    /**
     * 根流程实例ID
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     * 流程实例ID
     */
    @TableField(value = "PROC_INST_ID_")
    private String procInstId;
    /**
     *
     */
    @TableField(value = "BUSINESS_KEY_")
    private String businessKey;
    /**
     * 父执行实例ID
     */
    @TableField(value = "PARENT_ID_")
    private String parentId;
    /**
     * 流程定义ID
     */
    @TableField(value = "PROC_DEF_ID_")
    private String procDefId;
    /**
     *
     */
    @TableField(value = "SUPER_EXEC_")
    private String superExec;
    /**
     *
     */
    @TableField(value = "SUPER_CASE_EXEC_")
    private String superCaseExec;
    /**
     *
     */
    @TableField(value = "CASE_INST_ID_")
    private String caseInstId;
    /**
     *
     */
    @TableField(value = "ACT_ID_")
    private String actId;
    /**
     *
     */
    @TableField(value = "ACT_INST_ID_")
    private String actInstId;
    /**
     *
     */
    @TableField(value = "IS_ACTIVE_")
    private Integer isActive;
    /**
     *
     */
    @TableField(value = "IS_CONCURRENT_")
    private Integer isConcurrent;
    /**
     *
     */
    @TableField(value = "IS_SCOPE_")
    private Integer isScope;
    /**
     *
     */
    @TableField(value = "IS_EVENT_SCOPE_")
    private Integer isEventScope;
    /**
     *
     */
    @TableField(value = "SUSPENSION_STATE_")
    private Integer suspensionState;
    /**
     *
     */
    @TableField(value = "CACHED_ENT_STATE_")
    private Integer cachedEntState;
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
}