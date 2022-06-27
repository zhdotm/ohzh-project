package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

/**
 * 构造器
 *
 * @author zhihao.mao
 */
public interface IBuilder<T> {

    /**
     * 生成实现
     *
     * @return 实现
     */
    T build();
}
