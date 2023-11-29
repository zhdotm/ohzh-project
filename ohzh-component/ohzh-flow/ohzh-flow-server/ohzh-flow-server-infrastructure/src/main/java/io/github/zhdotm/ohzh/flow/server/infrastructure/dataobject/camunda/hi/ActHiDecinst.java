package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_DECINST
 */
@TableName(value = "ACT_HI_DECINST")
@Data
public class ActHiDecinst implements Serializable {
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
    @TableField(value = "DEC_DEF_ID_")
    private String decDefId;
    /**
     *
     */
    @TableField(value = "DEC_DEF_KEY_")
    private String decDefKey;
    /**
     *
     */
    @TableField(value = "DEC_DEF_NAME_")
    private String decDefName;
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
    @TableField(value = "PROC_INST_ID_")
    private String procInstId;
    /**
     *
     */
    @TableField(value = "CASE_DEF_KEY_")
    private String caseDefKey;
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
    @TableField(value = "ACT_INST_ID_")
    private String actInstId;
    /**
     *
     */
    @TableField(value = "ACT_ID_")
    private String actId;
    /**
     *
     */
    @TableField(value = "EVAL_TIME_")
    private LocalDateTime evalTime;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
    /**
     *
     */
    @TableField(value = "COLLECT_VALUE_")
    private Double collectValue;
    /**
     *
     */
    @TableField(value = "USER_ID_")
    private String userId;
    /**
     *
     */
    @TableField(value = "ROOT_DEC_INST_ID_")
    private String rootDecInstId;
    /**
     *
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     *
     */
    @TableField(value = "DEC_REQ_ID_")
    private String decReqId;
    /**
     *
     */
    @TableField(value = "DEC_REQ_KEY_")
    private String decReqKey;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
}