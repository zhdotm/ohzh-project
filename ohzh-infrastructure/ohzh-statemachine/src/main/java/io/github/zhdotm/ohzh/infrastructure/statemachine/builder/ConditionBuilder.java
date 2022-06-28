package io.github.zhdotm.ohzh.infrastructure.statemachine.builder;

import cn.hutool.core.lang.Assert;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.ICondition;
import io.github.zhdotm.ohzh.infrastructure.statemachine.model.IEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * 条件组件构造器
 *
 * @author zhihao.mao
 */
@Slf4j
public class ConditionBuilder implements IBuilder<ICondition> {

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
    private Function<IEvent, Boolean> isAllowedFunction;

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
    public ConditionBuilder isAllowed(Function<IEvent, Boolean> isAllowedFunction) {
        this.isAllowedFunction = isAllowedFunction;

        return this;
    }

    /**
     * 构建条件组件
     *
     * @return 条件组件
     */
    @Override
    public ICondition build() {
        Assert.notBlank(id, "构建条件组件失败: id为空");
        Assert.notNull(isAllowedFunction, "构建条件组件失败: 判断函数为空");

        return new ICondition() {
            @Override
            public Boolean isAllowed(IEvent event) {

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
