package io.github.zhdotm.ohzh.flow.server.start;

import cn.hutool.extra.spring.EnableSpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhihao.mao
 */

@EnableSpringUtil
@SpringBootApplication
public class FlowServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowServerApplication.class, args);
    }

}
