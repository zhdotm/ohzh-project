package io.github.zhdotm.ohzh.idempotent.redis.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RedisIdempotentProperties {

    /**
     * 锁定键前缀
     */
    private String lockKeyPrefix = "idempotent:lock:";

    /**
     * 缓存键
     */
    private String cacheKeyPrefix = "idempotent:cache:";
}
