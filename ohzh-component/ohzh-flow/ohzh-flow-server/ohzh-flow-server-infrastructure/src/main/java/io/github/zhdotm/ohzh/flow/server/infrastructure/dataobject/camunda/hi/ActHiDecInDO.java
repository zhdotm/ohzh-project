package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.hi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_HI_DEC_IN
 */
@TableName(value = "ACT_HI_DEC_IN")
@Data
public class ActHiDecInDO implements Serializable {
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
    @TableField(value = "DEC_INST_ID_")
    private String decInstId;
    /**
     *
     */
    @TableField(value = "CLAUSE_ID_")
    private String clauseId;
    /**
     *
     */
    @TableField(value = "CLAUSE_NAME_")
    private String clauseName;
    /**
     *
     */
    @TableField(value = "VAR_TYPE_")
    private String varType;

    /**
     *
     */
    @TableField(value = "DOUBLE_")
    private Double double_;

    /**
     *
     */
    @TableField(value = "LONG_")
    private Long long_;
    /**
     *
     */
    @TableField(value = "BYTEARRAY_ID_")
    private String bytearrayId;
    /**
     *
     */
    @TableField(value = "TEXT_")
    private String text;
    /**
     *
     */
    @TableField(value = "TEXT2_")
    private String text2;
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
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
}