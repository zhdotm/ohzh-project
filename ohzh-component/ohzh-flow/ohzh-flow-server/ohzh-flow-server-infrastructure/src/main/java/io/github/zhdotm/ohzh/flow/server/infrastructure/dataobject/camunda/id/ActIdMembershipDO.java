package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 联合主键目前mp不支持
 *
 * @TableName ACT_ID_MEMBERSHIP
 */
@TableName(value = "ACT_ID_MEMBERSHIP")
@Data
public class ActIdMembershipDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
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