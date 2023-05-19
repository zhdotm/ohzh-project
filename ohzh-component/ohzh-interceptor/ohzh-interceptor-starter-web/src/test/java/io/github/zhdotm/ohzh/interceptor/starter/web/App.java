package io.github.zhdotm.ohzh.interceptor.starter.web;

import io.github.zhdotm.ohzh.interceptor.starter.web.annotation.EnableInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhihao.mao
 */

@SpringBootApplication
@EnableInterceptor
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
