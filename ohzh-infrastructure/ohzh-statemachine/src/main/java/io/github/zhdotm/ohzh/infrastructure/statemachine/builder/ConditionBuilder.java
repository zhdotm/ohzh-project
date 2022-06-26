package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.Condition;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * 条件组件构造器
 *
 * @author zhihao.mao
 */
@Slf4j
public class ConditionBuilder implements Builder<Condition> {

    /**
     * 条件组件ID
     */
    private String id;

    /**
     * 条件组件描述
     */
    private String description;

    /**
     * 条件组件判断函数
     */
    private Function<Event, Boolean> isAllowedFunction;

    /**
     * 新建条件组件构造器
     *
     * @return 条件组件构造器
     */
    public static ConditionBuilder builder() {

        return new ConditionBuilder();
    }

    /**
     * 设置条件组件ID
     *
     * @param id 条件组件ID
     * @return 条件组件构造器
     */
    public ConditionBuilder id(String id) {
        this.id = id;

        return this;
    }

    /**
     * 设置条件组件描述
     *
     * @param description 条件组件描述
     * @return 条件组件构造器
     */
    public ConditionBuilder description(String description) {
        this.description = description;

        return this;

    }

    /**
     * 设置条件组件判断函数
     *
     * @param isAllowedFunction 条件组件判断函数
     * @return 条件组件构造器
     */
    public ConditionBuilder isAllowed(Function<Event, Boolean> isAllowedFunction) {
        this.isAllowedFunction = isAllowedFunction;

        return this;
    }

    /**
     * 构建条件组件
     *
     * @return 条件组件
     */
    @Override
    public Condition build() {
        Assert.notBlank(id, "构建条件组件失败: id为空");
        Assert.notNull(isAllowedFunction, "构建条件组件失败: 判断函数为空");

        log.info("开始构建条件组件: id[{}], description[{}]", id, description);

        return new Condition() {
            @Override
            public Boolean isAllowed(Event event) {

                return isAllowedFunction.apply(event);
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
