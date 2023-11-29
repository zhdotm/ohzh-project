package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_CASEINST
 */
@TableName(value = "ACT_HI_CASEINST")
@Data
public class ActHiCaseinst implements Serializable {
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
    @TableField(value = "CASE_INST_ID_")
    private String caseInstId;
    /**
     *
     */
    @TableField(value = "BUSINESS_KEY_")
    private String businessKey;
    /**
     *
     */
    @TableField(value = "CASE_DEF_ID_")
    private String caseDefId;
    /**
     *
     */
    @TableField(value = "CREATE_TIME_")
    private LocalDateTime createTime;
    /**
     *
     */
    @TableField(value = "CLOSE_TIME_")
    private LocalDateTime closeTime;
    /**
     *
     */
    @TableField(value = "DURATION_")
    private Long duration;
    /**
     *
     */
    @TableField(value = "STATE_")
    private Integer state;
    /**
     *
     */
    @TableField(value = "CREATE_USER_ID_")
    private String createUserId;
    /**
     *
     */
    @TableField(value = "SUPER_CASE_INSTANCE_ID_")
    private String superCaseInstanceId;
    /**
     *
     */
    @TableField(value = "SUPER_PROCESS_INSTANCE_ID_")
    private String superProcessInstanceId;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}