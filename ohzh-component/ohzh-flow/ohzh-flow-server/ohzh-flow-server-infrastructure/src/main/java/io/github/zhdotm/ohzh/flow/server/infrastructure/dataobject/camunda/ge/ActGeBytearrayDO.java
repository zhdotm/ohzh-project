package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 该表用于存储部署文件的二进制数据
 *
 * @TableName ACT_GE_BYTEARRAY
 */
@TableName(value = "ACT_GE_BYTEARRAY")
@Data
public class ActGeBytearrayDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 资源文件编号，自增长。
     */
    @TableId(value = "ID_")
    private String id;
    /**
     * 版本号
     */
    @TableField(value = "REV_")
    private Integer rev;
    /**
     * 资源文件名称
     */
    @TableField(value = "NAME_")
    private String name;
    /**
     * 来自于父表 act_re_deployment 的主键
     */
    @TableField(value = "DEPLOYMENT_ID_")
    private String deploymentId;
    /**
     *
     */
    @TableField(value = "GENERATED_")
    private Integer generated;
    /**
     *
     */
    @TableField(value = "TENANT_ID_")
    private String tenantId;
    /**
     *
     */
    @TableField(value = "TYPE_")
    private Integer type;
    /**
     *
     */
    @TableField(value = "CREATE_TIME_")
    private LocalDateTime createTime;
    /**
     *
     */
    @TableField(value = "ROOT_PROC_INST_ID_")
    private String rootProcInstId;
    /**
     *
     */
    @TableField(value = "REMOVAL_TIME_")
    private LocalDateTime removalTime;
    /**
     * 大文本类型，用于存储文本字节流
     */
    @TableField(value = "BYTES_")
    private byte[] bytes;
}