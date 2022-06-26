package io.github.zhdotm.ohzh.infrastructure.statemachine.model;

import org.apache.commons.lang3.StringUtils;

/**
 * 唯一标识
 *
 * @author zhihao.mao
 */
public interface Identity {

    /**
     * 获取唯一标识
     *
     * @return id
     */
    String getId();

    /**
     * 获取唯一标识描述
     *
     * @return 描述
     */
    default String getDescription() {

        return StringUtils.EMPTY;
    }

}
