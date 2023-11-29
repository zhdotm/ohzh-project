package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName ACT_RU_FILTER
 */
@TableName(value = "ACT_RU_FILTER")
@Data
public class ActRuFilterDO implements Serializable {
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
    @TableField(value = "RESOURCE_TYPE_")
    private String resourceType;
    /**
     *
     */
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "OWNER_")
    private String owner;
    /**
     *
     */
    @TableField(value = "QUERY_")
    private String query;
    /**
     *
     */
    @TableField(value = "PROPERTIES_")
    private String properties;
}