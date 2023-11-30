package io.github.zhdotm.ohzh.flow.server.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 业务类型
 *
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class BusinessType {

    /**
     * 物理主键
     */
    private Long id;

    /**
     * 业务类型逻辑主键
     */
    private String typeId;

    /**
     * 业务类型名称
     */
    private String typeName;

    /**
     * 业务类型描述
     */
    private String typeDesc;

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
