package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_AUTHORIZATION
 */
@TableName(value = "ACT_RU_AUTHORIZATION")
@Data
public class ActRuAuthorization implements Serializable {
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
    private Integer type;
    /**
     *
     */
    @TableField(value = "GROUP_ID_")
    private String groupId;
    /**
     *
     */
    @TableField(value = "USER_ID_")
    private String userId;
    /**
     *
     */
    @TableField(value = "RESOURCE_TYPE_")
    private Integer resourceType;
    /**
     *
     */
    @TableField(value = "RESOURCE_ID_")
    private String resourceId;
    /**
     *
     */
    @TableField(value = "PERMS_")
    private Integer perms;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
    /**
     *
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
}