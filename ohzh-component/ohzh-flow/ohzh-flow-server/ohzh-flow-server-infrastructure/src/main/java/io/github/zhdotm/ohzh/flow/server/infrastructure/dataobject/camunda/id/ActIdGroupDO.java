package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_ID_GROUP
 */
@TableName(value = "ACT_ID_GROUP")
@Data
public class ActIdGroupDO implements Serializable {
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
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "TYPE_")
    private String type;
}