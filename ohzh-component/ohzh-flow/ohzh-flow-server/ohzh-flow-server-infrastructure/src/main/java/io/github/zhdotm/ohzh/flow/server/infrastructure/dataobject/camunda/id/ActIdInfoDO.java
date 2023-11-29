package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_ID_INFO
 */
@TableName(value = "ACT_ID_INFO")
@Data
public class ActIdInfoDO implements Serializable {
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
    @TableField(value = "USER_ID_")
    private String userId;
    /**
     *
     */
    @TableField(value = "TYPE_")
    private String type;
    /**
     *
     */
    @TableField(value = "KEY_")
    private String key;
    /**
     *
     */
    @TableField(value = "VALUE_")
    private String value;
    /**
     *
     */
    @TableField(value = "PARENT_ID_")
    private String parentId;
    /**
     *
     */
    @TableField(value = "PASSWORD_")
    private byte[] password;
}