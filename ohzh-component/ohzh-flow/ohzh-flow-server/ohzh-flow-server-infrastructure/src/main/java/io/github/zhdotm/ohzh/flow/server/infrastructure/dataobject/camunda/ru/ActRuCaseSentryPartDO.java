package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_RU_CASE_SENTRY_PART
 */
@TableName(value = "ACT_RU_CASE_SENTRY_PART")
@Data
public class ActRuCaseSentryPartDO implements Serializable {
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
    @TableField(value = "CASE_EXEC_ID_")
    private String caseExecId;
    /**
     *
     */
    @TableField(value = "SENTRY_ID_")
    private String sentryId;
    /**
     *
     */
    @TableField(value = "TYPE_")
    private String type;
    /**
     *
     */
    @TableField(value = "SOURCE_CASE_EXEC_ID_")
    private String sourceCaseExecId;
    /**
     *
     */
    @TableField(value = "STANDARD_EVENT_")
    private String standardEvent;
    /**
     *
     */
    @TableField(value = "SOURCE_")
    private String source;
    /**
     *
     */
    @TableField(value = "VARIABLE_EVENT_")
    private String variableEvent;
    /**
     *
     */
    @TableField(value = "VARIABLE_NAME_")
    private String variableName;
    /**
     *
     */
    @TableField(value = "SATISFIED_")
    private Integer satisfied;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}