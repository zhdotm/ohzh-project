package io.github.zhdotm.ohzh.event.core;

import java.util.Map;

/**
 * 事件
 * https://www.alibabacloud.com/help/zh/eventbridge/latest/event-overview?spm=a2c63.p38356.0.0.9f4c5c78wgwrYA
 *
 * @author zhihao.mao
 */

public interface IEvent {

    /**
     * 事件ID。
     * 标识事件的唯一值。
     * 发送端必须确保source+id是唯一的，如果由于网络等原因事件被重新发送，可能会产生两个相同id的事件。
     * 接收端会认为具有相同source和id的事件是重复的。事件通过规则路由到目标、事件被处理时，需要根据id跟踪事件。
     *
     * @return 45ef4dewdwe1-7c35-447a-bd93-fab****
     */
    String getId();

    /**
     * 事件源。
     * 提供事件的服务。
     * 标识事件发生的内容。
     * 一般会包含事件源的类型，发布事件的机制或生产事件的过程。
     * 发送端必须确保每个事件的source+id是唯一的。
     *
     * @return acs:aliyuncvc
     */
    <T extends IEventSource> T getSource();

    /**
     * CloudEvents协议版本。
     *
     * @return 1.0
     */
    default String getSpecversion() {

        return "1.0";
    }

    /**
     * 事件类型。
     * 描述事件源相关的事件类型。
     * 该参数用于路由、事件查询和策略执行等。
     * 格式由生产者定义且包含版本等信息。
     *
     * @return aliyuncvc:MeetingEvent:MemberOperate
     */
    String getType();

    /**
     * 参数data的内容形式。
     * datacontenttype只支持application/json格式。
     *
     * @return application/json;charset=utf-8
     */
    default String getDatacontenttype() {

        return "application/json;charset=utf-8";
    }

    /**
     * 参数data遵循的模式。
     *
     * @return dataschema
     */
    default <T extends IEventSchema> T getDataschema() {

        return null;
    }

    /**
     * 事件主题。
     * JSON数据包含标识事件中涉及的资源的ARN。
     * 在发布订阅模式中，订阅者通常订阅source发出的事件。
     * 当source中包含子结构时，只使用source无法对具体事件进行清晰的定义。
     * subject参数在订阅过滤场景中对data无法解释的内容提供说明。
     *
     * @return acs.aliyuncvc:cn-hangzhou:{AccountId}:215672
     */
    String getSubject();

    /**
     * 事件产生的时间。
     * 如果无法确定事件发生的时间，CloudEvents生产者可以把time设置为其他时间（例如当前时间），但是同一个source的所有生产者设置的值必须是一致的。
     *
     * @return 2020-11-19T21:04:41+08:00
     */
    Long getTime();

    /**
     * 事件内容。
     * JSON对象，内容由发起事件的服务决定。
     * CloudEvents可能包含事件发生时由事件生产者给定的上下文，data中封装了这些信息。
     *
     * @param <T> 事件内容类型
     * @return 事件内容
     */
    <T> T getData();

    /**
     * 额外属性
     *
     * @return 额外属性
     */
    Map<String, Object> getExtraProperties();
}
