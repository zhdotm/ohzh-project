package io.github.zhdotm.ohzh.event.core.model;

/**
 * 事件规则
 * 事件规则用于过滤和转换事件。
 * https://www.alibabacloud.com/help/zh/eventbridge/latest/event-rule?spm=a2c63.p38356.0.0.44a521f2rCOjOO
 * <p>
 * 事件规则包括以下内容：
 * 事件规则中的过滤功能由事件模式提供。更多信息，请参见事件模式。
 * 事件规则中的转换功能将CloudEvents转换为事件目标可以接收的格式。
 * 用于监控特定类型的事件。当发生匹配事件时，事件会被路由到与事件规则关联的事件目标。规则可以与一个或多个事件目标关联。事件规则包括：
 * 事件匹配：匹配事件模式，决定哪些事件可以被触发到事件目标。
 * 事件目标：事件的处理终端，负责消费事件。
 *
 * @author zhihao.mao
 */

public interface IEventRule {
}
