package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 该表用于存储异步任务的执行信息
 *
 * @TableName ACT_RU_JOB
 */
@TableName(value = "ACT_RU_JOB")
@Data
public class ActRuJob implements Serializable {
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
    @TableField(value = "LOCK_EXP_TIME_")
    private LocalDateTime lockExpTime;
    /**
     *
     */
    @TableField(value = "LOCK_OWNER_")
    private String lockOwner;
    /**
     *
     */
    @TableField(value = "EXCLUSIVE_")
    private Integer exclusive;
    /**
     *
     */
    @TableField(value = "EXECUTION_ID_")
    private String executionId;
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
    @TableField(value = "RETRIES_")
    private Integer retries;
    /**
     *
     */
    @TableField(value = "EXCEPTION_STACK_ID_")
    private String exceptionStackId;
    /**
     *
     */
    @TableField(value = "EXCEPTION_MSG_")
    private String exceptionMsg;
    /**
     *
     */
    @TableField(value = "FAILED_ACT_ID_")
    private String failedActId;
    /**
     *
     */
    @TableField(value = "DUEDATE_")
    private LocalDateTime duedate;
    /**
     *
     */
    @TableField(value = "REPEAT_")
    private String repeat;
    /**
     *
     */
    @TableField(value = "REPEAT_OFFSET_")
    private Long repeatOffset;
    /**
     *
     */
    @TableField(value = "HANDLER_TYPE_")
    private String handlerType;
    /**
     *
     */
    @TableField(value = "HANDLER_CFG_")
    private String handlerCfg;
    /**
     *
     */
    @TableField(value = "DEPLOYMENT_ID_")
    private String deploymentId;
    /**
     *
     */
    @TableField(value = "SUSPENSION_STATE_")
    private Integer suspensionState;
    /**
     *
     */
    @TableField(value = "JOB_DEF_ID_")
    private String jobDefId;
    /**
     *
     */
    @TableField(value = "PRIORITY_")
    private Long priority;
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
    @TableField(value = "CREATE_TIME_")
    private LocalDateTime createTime;
    /**
     *
     */
    @TableField(value = "LAST_FAILURE_LOG_ID_")
    private String lastFailureLogId;
}