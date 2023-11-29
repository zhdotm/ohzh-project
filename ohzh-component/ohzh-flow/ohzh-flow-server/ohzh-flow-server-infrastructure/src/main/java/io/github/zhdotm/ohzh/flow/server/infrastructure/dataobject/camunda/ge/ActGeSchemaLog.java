package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_GE_SCHEMA_LOG
 */
@TableName(value = "ACT_GE_SCHEMA_LOG")
@Data
public class ActGeSchemaLog implements Serializable {
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
    @TableField(value = "TIMESTAMP_")
    private LocalDateTime timestamp;
    /**
     *
     */
    @TableField(value = "VERSION_")
    private String version;
}