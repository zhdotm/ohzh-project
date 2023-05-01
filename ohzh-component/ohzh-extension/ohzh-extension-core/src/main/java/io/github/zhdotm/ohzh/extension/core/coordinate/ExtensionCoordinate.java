package io.github.zhdotm.ohzh.extension.core.coordinate;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.point.IExtensionPoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 扩展点坐标
 *
 * @author zhihao.mao
 */

@Accessors(chain = true)
@EqualsAndHashCode
@ToString
@Data
public class ExtensionCoordinate implements Serializable {

    /**
     * 拓展点业务身份
     */
    private final BizScenario bizScenario;
    /**
     * 拓展点目标接口
     */
    private Class<? extends IExtensionPoint> targetClazz;

    private ExtensionCoordinate(BizScenario bizScenario, Class<? extends IExtensionPoint> targetClazz) {
        this.bizScenario = bizScenario;
        this.targetClazz = targetClazz;
    }

    /**
     * 创建拓展点坐标
     *
     * @param bizScenario 拓展点业务身份
     * @param targetClazz 拓展点目标接口
     * @return 拓展点坐标
     */
    public static ExtensionCoordinate create(BizScenario bizScenario, Class<? extends IExtensionPoint> targetClazz) {

        return new ExtensionCoordinate(bizScenario, targetClazz);
    }
}
