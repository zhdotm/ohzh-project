package io.github.zhdotm.ohzh.flow.server.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 流程分类
 *
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class ProcessCategory {

    /**
     * 物理主键
     */
    private Long id;

    /**
     * 流程分类逻辑主键
     */
    private String categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类展示图标
     */
    private String iconUrl;

    /**
     * 流程分类描述
     */
    private String categoryDesc;

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
