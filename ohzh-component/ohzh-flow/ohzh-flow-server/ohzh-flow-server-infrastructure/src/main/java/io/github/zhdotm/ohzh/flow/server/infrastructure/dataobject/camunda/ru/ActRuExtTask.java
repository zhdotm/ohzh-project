package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_EXT_TASK
 */
@TableName(value = "ACT_RU_EXT_TASK")
@Data
public class ActRuExtTask implements Serializable {
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
    @TableField(value = "WORKER_ID_")
    private String workerId;
    /**
     *
     */
    @TableField(value = "TOPIC_NAME_")
    private String topicName;
    /**
     *
     */
    @TableField(value = "RETRIES_")
    private Integer retries;
    /**
     *
     */
    @TableField(value = "ERROR_MSG_")
    private String errorMsg;
    /**
     *
     */
    @TableField(value = "ERROR_DETAILS_ID_")
    private String errorDetailsId;
    /**
     *
     */
    @TableField(value = "LOCK_EXP_TIME_")
    private LocalDateTime lockExpTime;
    /**
     *
     */
    @TableField(value = "SUSPENSION_STATE_")
    private Integer suspensionState;
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
    @TableField(value = "PROC_DEF_KEY_")
    private String procDefKey;
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
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "PRIORITY_")
    private Long priority;
    /**
     *
     */
    @TableField(value = "LAST_FAILURE_LOG_ID_")
    private String lastFailureLogId;
}