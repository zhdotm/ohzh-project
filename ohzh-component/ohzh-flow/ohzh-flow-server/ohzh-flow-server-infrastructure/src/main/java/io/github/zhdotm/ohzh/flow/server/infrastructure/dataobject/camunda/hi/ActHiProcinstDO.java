package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_PROCINST
 */
@TableName(value = "ACT_HI_PROCINST")
@Data
public class ActHiProcinstDO implements Serializable {
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
    @TableField(value = "PROC_INST_ID_")
    private String procInstId;
    /**
     *
     */
    @TableField(value = "BUSINESS_KEY_")
    private String businessKey;
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
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
    /**
     *
     */
    @TableField(value = "DURATION_")
    private Long duration;
    /**
     *
     */
    @TableField(value = "START_USER_ID_")
    private String startUserId;
    /**
     *
     */
    @TableField(value = "START_ACT_ID_")
    private String startActId;
    /**
     *
     */
    @TableField(value = "END_ACT_ID_")
    private String endActId;
    /**
     *
     */
    @TableField(value = "SUPER_PROCESS_INSTANCE_ID_")
    private String superProcessInstanceId;
    /**
     *
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     *
     */
    @TableField(value = "SUPER_CASE_INSTANCE_ID_")
    private String superCaseInstanceId;
    /**
     *
     */
    @TableField(value = "CASE_INST_ID_")
    private String caseInstId;
    /**
     *
     */
    @TableField(value = "DELETE_REASON_")
    private String deleteReason;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "STATE_")
    private String state;
}