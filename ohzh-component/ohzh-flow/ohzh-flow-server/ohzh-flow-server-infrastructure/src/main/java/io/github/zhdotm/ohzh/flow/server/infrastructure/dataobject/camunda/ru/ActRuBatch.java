package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_RU_BATCH
 */
@TableName(value = "ACT_RU_BATCH")
@Data
public class ActRuBatch implements Serializable {
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
    private String type;
    /**
     *
     */
    @TableField(value = "TOTAL_JOBS_")
    private Integer totalJobs;
    /**
     *
     */
    @TableField(value = "JOBS_CREATED_")
    private Integer jobsCreated;
    /**
     *
     */
    @TableField(value = "JOBS_PER_SEED_")
    private Integer jobsPerSeed;
    /**
     *
     */
    @TableField(value = "INVOCATIONS_PER_JOB_")
    private Integer invocationsPerJob;
    /**
     *
     */
    @TableField(value = "SEED_JOB_DEF_ID_")
    private String seedJobDefId;
    /**
     *
     */
    @TableField(value = "BATCH_JOB_DEF_ID_")
    private String batchJobDefId;
    /**
     *
     */
    @TableField(value = "MONITOR_JOB_DEF_ID_")
    private String monitorJobDefId;
    /**
     *
     */
    @TableField(value = "SUSPENSION_STATE_")
    private Integer suspensionState;
    /**
     *
     */
    @TableField(value = "CONFIGURATION_")
    private String configuration;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "CREATE_USER_ID_")
    private String createUserId;
    /**
     *
     */
    @TableField(value = "START_TIME_")
    private LocalDateTime startTime;
    /**
     *
     */
    @TableField(value = "EXEC_START_TIME_")
    private LocalDateTime execStartTime;
}