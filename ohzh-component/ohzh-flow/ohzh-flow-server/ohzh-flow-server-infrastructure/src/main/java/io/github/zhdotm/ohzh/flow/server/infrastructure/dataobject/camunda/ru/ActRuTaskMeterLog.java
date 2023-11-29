package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_TASK_METER_LOG
 */
@TableName(value = "ACT_RU_TASK_METER_LOG")
@Data
public class ActRuTaskMeterLog implements Serializable {
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
    @TableField(value = "ASSIGNEE_HASH_")
    private Long assigneeHash;
    /**
     *
     */
    @TableField(value = "TIMESTAMP_")
    private LocalDateTime timestamp;
}