package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_RU_CASE_EXECUTION
 */
@TableName(value = "ACT_RU_CASE_EXECUTION")
@Data
public class ActRuCaseExecution implements Serializable {
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
    @TableField(value = "CASE_INST_ID_")
    private String caseInstId;
    /**
     *
     */
    @TableField(value = "SUPER_CASE_EXEC_")
    private String superCaseExec;
    /**
     *
     */
    @TableField(value = "SUPER_EXEC_")
    private String superExec;
    /**
     *
     */
    @TableField(value = "BUSINESS_KEY_")
    private String businessKey;
    /**
     *
     */
    @TableField(value = "PARENT_ID_")
    private String parentId;
    /**
     *
     */
    @TableField(value = "CASE_DEF_ID_")
    private String caseDefId;
    /**
     *
     */
    @TableField(value = "ACT_ID_")
    private String actId;
    /**
     *
     */
    @TableField(value = "PREV_STATE_")
    private Integer prevState;
    /**
     *
     */
    @TableField(value = "CURRENT_STATE_")
    private Integer currentState;
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