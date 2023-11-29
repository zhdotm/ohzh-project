package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 该表用于存储流程引擎级别的属性数据。在初始化表结构时，会默认插入三条记录，包括属性名称、属性值和版本号
 *
 * @TableName ACT_GE_PROPERTY
 */
@TableName(value = "ACT_GE_PROPERTY")
@Data
public class ActGePropertyDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "VALUE_")
    private String value;
    /**
     *
     */
    @TableField(value = "REV_")
    private Integer rev;
}