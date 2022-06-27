package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IState;
import lombok.extern.slf4j.Slf4j;

/**
 * 状态构造器
 *
 * @author zhihao.mao
 */
@Slf4j
public class StateIBuilder implements IBuilder<IState> {

    /**
     * 状态组件ID
     */
    private String id;

    /**
     * 状态组件描述
     */
    private String description;

    /**
     * 新建状态组件构造器
     *
     * @return 状态组件构造器
     */
    public static StateIBuilder builder() {

        return new StateIBuilder();
    }

    /**
     * 设置状态组件ID
     *
     * @param id 状态组件ID
     * @return 状态组件构造器
     */
    public StateIBuilder id(String id) {
        this.id = id;

        return this;
    }

    /**
     * 设置状态组件描述
     *
     * @param description 状态组件描述
     * @return 状态组件构造器
     */
    public StateIBuilder description(String description) {
        this.description = description;

        return this;

    }

    /**
     * 构建状态组件
     *
     * @return 状态组件
     */
    @Override
    public IState build() {
        Assert.notBlank(id, "构建状态组件失败: id为空");

        log.info("开始构建状态组件: id[{}], description[{}]", id, description);

        return new IState() {
            @Override
            public String getId() {

                return id;
            }

            @Override
            public String getDescription() {

                return description;
            }
        };
    }

}
