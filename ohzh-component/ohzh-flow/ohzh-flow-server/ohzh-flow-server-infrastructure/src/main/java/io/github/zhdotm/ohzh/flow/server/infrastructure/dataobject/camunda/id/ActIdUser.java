package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName ACT_ID_USER
 */
@TableName(value = "ACT_ID_USER")
@Data
public class ActIdUser implements Serializable {
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
    @TableField(value = "FIRST_")
    private String first;
    /**
     *
     */
    @TableField(value = "LAST_")
    private String last;
    /**
     *
     */
    @TableField(value = "EMAIL_")
    private String email;
    /**
     *
     */
    @TableField(value = "PWD_")
    private String pwd;
    /**
     *
     */
    @TableField(value = "SALT_")
    private String salt;
    /**
     *
     */
    @TableField(value = "LOCK_EXP_TIME_")
    private LocalDateTime lockExpTime;
    /**
     *
     */
    @TableField(value = "ATTEMPTS_")
    private Integer attempts;
    /**
     *
     */
    @TableField(value = "PICTURE_ID_")
    private String pictureId;
}