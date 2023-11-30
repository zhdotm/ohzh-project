package io.github.zhdotm.ohzh.flow.server.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 独立表单
 *
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class ExtraIndependentForm {

    /**
     * 表单逻辑主键
     */
    private String formId;

    /**
     * 表单的KEY
     */
    private String formKey;

    /**
     * 表单的版本
     */
    private Integer formVersion;

    /**
     * 表单名称
     */
    private String formName;

    /**
     * 表单的JSON串
     */
    private String formJson;

    /**
     * 描述
     */
    private String formDesc;

    /**
     * 额外信息
     */
    private String extraAttrs;

    /**
     * 创建人ID
     */
    private String creatorId;

    /**
     * 创建人姓名
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人id
     */
    private String modifierId;

    /**
     * 更新人名称
     */
    private String modifiedBy;

    /**
     * 更新时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 逻辑删除标志位
     */
    private String isDeleted;

}
