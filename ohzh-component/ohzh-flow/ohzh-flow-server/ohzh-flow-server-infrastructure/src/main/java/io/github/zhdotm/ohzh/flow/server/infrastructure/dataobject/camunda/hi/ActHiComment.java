package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_COMMENT
 */
@TableName(value = "ACT_HI_COMMENT")
@Data
public class ActHiComment implements Serializable {
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
    @TableField(value = "TIME_")
    private LocalDateTime time;
    /**
     *
     */
    @TableField(value = "USER_ID_")
    private String userId;
    /**
     *
     */
    @TableField(value = "TASK_ID_")
    private String taskId;
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
    @TableField(value = "ACTION_")
    private String action;
    /**
     *
     */
    @TableField(value = "MESSAGE_")
    private String message;
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
    /**
     *
     */
    @TableField(value = "FULL_MSG_")
    private byte[] fullMsg;
}