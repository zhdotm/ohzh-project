package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_EXT_TASK_LOG
 */
@TableName(value = "ACT_HI_EXT_TASK_LOG")
@Data
public class ActHiExtTaskLog implements Serializable {
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
    @TableField(value = "TIMESTAMP_")
    private LocalDateTime timestamp;
    /**
     *
     */
    @TableField(value = "EXT_TASK_ID_")
    private String extTaskId;
    /**
     *
     */
    @TableField(value = "RETRIES_")
    private Integer retries;
    /**
     *
     */
    @TableField(value = "TOPIC_NAME_")
    private String topicName;
    /**
     *
     */
    @TableField(value = "WORKER_ID_")
    private String workerId;
    /**
     *
     */
    @TableField(value = "PRIORITY_")
    private Long priority;
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
    @TableField(value = "EXECUTION_ID_")
    private String executionId;
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
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "STATE_")
    private Integer state;
    /**
     *
     */
    @TableField(value = "REV_")
    private Integer rev;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
}