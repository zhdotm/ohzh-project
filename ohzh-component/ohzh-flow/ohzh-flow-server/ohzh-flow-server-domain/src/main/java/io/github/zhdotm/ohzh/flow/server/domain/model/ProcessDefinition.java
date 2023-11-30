package io.github.zhdotm.ohzh.flow.server.domain.model;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.flow.server.domain.facade.gateway.IBusinessTypeGateway;
import io.github.zhdotm.ohzh.flow.server.domain.facade.gateway.IProcessCategoryGateway;
import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.BusinessType;
import io.github.zhdotm.ohzh.flow.server.domain.model.valueobject.ProcessCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 流程定义
 *
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class ProcessDefinition {

    /**
     * CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF
     */
    private String defId;

    /**
     * CAMUNDA中的流程定义KEY，关联到ACT_RE_PROCDEF的KEY
     */
    private String defKey;

    /**
     * CAMUNDA中的流程定义版本，关联到ACT_RE_PROCDEF的VERSION
     */
    private Integer defVersion;

    /**
     * 流程定义名称
     */
    private String defName;

    /**
     * 流程定义的状态，0-禁用 1-启用
     */
    private Boolean defStatus;

    /**
     * 流程分类ID
     */
    private String procCategoryId;

    /**
     * 流程分类
     */
    private ProcessCategory processCategory;

    /**
     * 当前流程定义所属的业务类型，用于关联具体业务
     */
    private String businessTypeId;

    /**
     * 业务类型
     */
    private BusinessType businessType;

    /**
     * 分类展示图标
     */
    private String iconUrl;

    /**
     * 额外信息
     */
    private String extraAttrs;

    /**
     * 流程定义描述
     */
    private String defDesc;

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

    public synchronized ProcessCategory getProcessCategory() {
        if (ObjectUtil.isEmpty(processCategory)) {
            IProcessCategoryGateway processCategoryRepository = SpringUtil.getBean(IProcessCategoryGateway.class);
            processCategory = processCategoryRepository.findByProcCategoryId(procCategoryId);
        }

        return processCategory;
    }

    public synchronized BusinessType getBusinessType() {
        if (ObjectUtil.isEmpty(businessType)) {
            IBusinessTypeGateway businessTypeRepository = SpringUtil.getBean(IBusinessTypeGateway.class);
            businessType = businessTypeRepository.findByBusinessTypeId(businessTypeId);
        }

        return businessType;
    }

}
