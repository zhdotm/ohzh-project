package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_EVENT_SUBSCR
 */
@TableName(value = "ACT_RU_EVENT_SUBSCR")
@Data
public class ActRuEventSubscr implements Serializable {
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
    @TableField(value = "EVENT_TYPE_")
    private String eventType;
    /**
     *
     */
    @TableField(value = "EVENT_NAME_")
    private String eventName;
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
    @TableField(value = "ACTIVITY_ID_")
    private String activityId;
    /**
     *
     */
    @TableField(value = "CONFIGURATION_")
    private String configuration;
    /**
     *
     */
    @TableField(value = "CREATED_")
    private LocalDateTime created;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}