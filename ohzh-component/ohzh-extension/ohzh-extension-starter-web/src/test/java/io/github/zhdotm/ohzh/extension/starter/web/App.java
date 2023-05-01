package io.github.zhdotm.ohzh.extension.starter.web;

import io.github.zhdotm.ohzh.extension.starter.web.annotation.EnableSpringExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhihao.mao
 */

@EnableSpringExtension
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
