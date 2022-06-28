package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IAction;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * 动作组件构造器
 *
 * @author zhihao.mao
 */

@Slf4j
public class ActionBuilder implements IBuilder<IAction> {

    /**
     * 动作组件ID
     */
    private String id;

    /**
     * 动作组件描述
     */
    private String description;

    /**
     * 动作组件事件处理函数
     */
    private Consumer<IEvent> onEventFunction;

    /**
     * 新建动作组件构造器
     *
     * @return 动作组件构造器
     */
    public static ActionBuilder builder() {

        return new ActionBuilder();
    }

    /**
     * 设置动作组件ID
     *
     * @param id 动作组件ID
     * @return 动作组件构造器
     */
    public ActionBuilder id(String id) {
        this.id = id;

        return this;
    }

    /**
     * 设置动作组件描述
     *
     * @param description 动作组件描述
     * @return 动作组件构造器
     */
    public ActionBuilder description(String description) {
        this.description = description;

        return this;
    }

    /**
     * 设置动作组件事件处理函数
     *
     * @param onEventFunction 事件处理函数
     * @return 动作组件构造器
     */
    public ActionBuilder onEvent(Consumer<IEvent> onEventFunction) {
        this.onEventFunction = onEventFunction;

        return this;
    }

    /**
     * 构建动作组件
     *
     * @return 动作组件
     */
    @Override
    public IAction build() {
        Assert.notBlank(id, "构建动作组件失败: id为空");
        Assert.notNull(onEventFunction, "构建动作组件失败: 事件处理函数为空");

        log.info("开始构建动作组件: id[{}], description[{}]", id, description);

        return new IAction() {
            @Override
            public void onEvent(IEvent event) {
                onEventFunction.accept(event);
            }

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
