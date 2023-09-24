package io.github.zhdotm.ohzh.event.core.model.event;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhihao.mao
 */

@Data
@Accessors(chain = true)
public class DefaultEvent<T> implements IEvent {

    private Long eventId;

    private String subject;

    private LocalDateTime when;

    private T data;

    private Map<String, String> extraProperties = new HashMap<>();

    public static <T> DefaultEvent<T> create(Long eventId, String subject, LocalDateTime when, T data) {
        DefaultEvent<T> event = new DefaultEvent<>();

        return event.setEventId(eventId)
                .setSubject(subject)
                .setWhen(when)
                .setData(data);
    }

    void putProperty(String name, String value) {
        extraProperties.put(name, value);
    }
    
}
