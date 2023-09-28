/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.zhdotm.ohzh.statemachine.starter.web.mq.producer;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 消息发送结果
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class EventSendResult {


    /**
     * 主题
     */
    private String topic;

    /**
     * 分区
     */
    private Integer partition;

    /**
     * 消息ID
     */
    private String messageId;

    /**
     * 偏移量
     */
    private Long offset;
    
}
