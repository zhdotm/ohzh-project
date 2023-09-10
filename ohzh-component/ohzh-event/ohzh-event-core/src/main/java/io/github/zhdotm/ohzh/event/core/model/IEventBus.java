package io.github.zhdotm.ohzh.event.core.model;

/**
 * 事件总线
 * 事件集（Event Bus）
 * 事件集负责接收来自事件源的事件。事件集包括以下类型：
 * 云服务事件集：您可以选择创建的事件集为云服务事件集，用于接收您的腾讯云云服务的事件。
 * 自定义事件集：需要您自行创建并管理的事件总线，用于接收您自己的应用程序的事件或业务事件。您自己的应用程序的事件只能发布到自定义事件集。
 * <p>
 * https://www.alibabacloud.com/help/zh/eventbridge/latest/event-bus?spm=a2c63.p38356.0.0.14b2584dmGXVcY
 *
 * @author zhihao.mao
 */

public interface IEventBus {
}
