package io.github.zhdotm.ohzh.example.idempotent.configuration;

import io.github.zhdotm.ohzh.example.idempotent.serializer.JsonSerializer;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.jdbc.configuration.JdbcIdempotentProperties;
import io.github.zhdotm.ohzh.idempotent.jdbc.handler.JdbcIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.redis.configuration.RedisIdempotentProperties;
import io.github.zhdotm.ohzh.idempotent.redis.handler.RedisIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.start.web.annotation.EnableIdempotent;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhihao.mao
 */

@EnableIdempotent
@Configuration
public class IdempotentConfiguration {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public RedisIdempotentHandler redisIdempotentHandler(RedissonClient redissonClient) {

        return new RedisIdempotentHandler(IIdempotentHandler.COMMON_NAME, redissonClient, new RedisIdempotentProperties());
    }

    @Bean
    public JdbcIdempotentHandler jdbcIdempotentHandler() {

        return new JdbcIdempotentHandler("jdbcIdempotentHandler", jdbcTemplate, new JsonSerializer(), new JdbcIdempotentProperties());
    }

}
