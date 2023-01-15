package io.github.zhdotm.ohzh.cqrs.starter.web;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.EnableCQRS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 *
 * @author Frank Zhang
 * @date 2020-11-10 3:58 PM
 */
@EnableCQRS
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
