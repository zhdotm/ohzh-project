package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_CASEACTINST
 */
@TableName(value = "ACT_HI_CASEACTINST")
@Data
public class ActHiCaseactinstDO implements Serializable {
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
    @TableField(value = "PARENT_ACT_INST_ID_")
    private String parentActInstId;
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
    @TableField(value = "CASE_ACT_ID_")
    private String caseActId;
    /**
     *
     */
    @TableField(value = "TASK_ID_")
    private String taskId;
    /**
     *
     */
    @TableField(value = "CALL_PROC_INST_ID_")
    private String callProcInstId;
    /**
     *
     */
    @TableField(value = "CALL_CASE_INST_ID_")
    private String callCaseInstId;
    /**
     *
     */
    @TableField(value = "CASE_ACT_NAME_")
    private String caseActName;
    /**
     *
     */
    @TableField(value = "CASE_ACT_TYPE_")
    private String caseActType;
    /**
     *
     */
    @TableField(value = "CREATE_TIME_")
    private LocalDateTime createTime;
    /**
     *
     */
    @TableField(value = "END_TIME_")
    private LocalDateTime endTime;
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
    @TableField(value = "REQUIRED_")
    private Integer required;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}