package io.github.zhdotm.ohzh.event.core.domain.stream;

/**
 * 流类型
 *
 * @author zhihao.mao
 */

public interface IEventStreamType {

    /**
     * 流类型编码
     *
     * @return 流类型编码
     */
    String getCode();

    /**
     * 流类型描述
     *
     * @return 流类型描述
     */
    String getDescription();

}
