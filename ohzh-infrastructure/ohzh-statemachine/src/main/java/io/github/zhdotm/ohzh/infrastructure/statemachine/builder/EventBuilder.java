package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IEvent;
import lombok.extern.slf4j.Slf4j;


/**
 * 事件组件构造器
 *
 * @author zhihao.mao
 */
@Slf4j
public class EventBuilder<T> implements IBuilder<IEvent> {

    /**
     * 事件组件ID
     */
    private String id;

    /**
     * 事件组件描述
     */
    private String description;

    /**
     * 事件荷载
     */
    private T payload;

    /**
     * 新建事件组件构造器
     *
     * @param <T> 荷载类型
     * @return 事件组件构造器
     */
    public static <T> EventBuilder<T> builder() {

        return new EventBuilder<>();
    }

    /**
     * 设置事件组件ID
     *
     * @param id 事件组件ID
     * @return 事件组件构造器
     */
    public EventBuilder<T> id(String id) {
        this.id = id;

        return this;
    }

    /**
     * 设置事件组件描述
     *
     * @param description 事件组件描述
     * @return 事件组件构造器
     */
    public EventBuilder<T> description(String description) {
        this.description = description;

        return this;
    }

    /**
     * 设置事件组件荷载
     *
     * @param payload 事件荷载
     * @return 事件组件构造器
     */
    public EventBuilder<T> payload(T payload) {
        this.payload = payload;

        return this;
    }

    /**
     * 构建事件组件
     *
     * @return 事件组件
     */
    @Override
    public IEvent build() {
        Assert.notBlank(id, "构建事件组件失败: id为空");

        return new IEvent() {

            @Override
            public T getPayload() {

                return payload;
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
