package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_METER_LOG
 */
@TableName(value = "ACT_RU_METER_LOG")
@Data
public class ActRuMeterLogDO implements Serializable {
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
    @TableField(value = "NAME_")
    private String name;
    /**
     *
     */
    @TableField(value = "REPORTER_")
    private String reporter;
    /**
     *
     */
    @TableField(value = "VALUE_")
    private Long value;
    /**
     *
     */
    @TableField(value = "TIMESTAMP_")
    private LocalDateTime timestamp;
    /**
     *
     */
    @TableField(value = "MILLISECONDS_")
    private Long milliseconds;
}