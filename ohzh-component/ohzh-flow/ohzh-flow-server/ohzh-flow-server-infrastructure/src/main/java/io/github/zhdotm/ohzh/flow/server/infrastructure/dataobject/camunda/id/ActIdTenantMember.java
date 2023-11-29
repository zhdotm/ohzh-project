package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_ID_TENANT_MEMBER
 */
@TableName(value = "ACT_ID_TENANT_MEMBER")
@Data
public class ActIdTenantMember implements Serializable {
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
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "USER_ID_")
    private String userId;
    /**
     *
     */
    @TableField(value = "GROUP_ID_")
    private String groupId;
}