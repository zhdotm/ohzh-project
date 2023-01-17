package io.github.zhdotm.ohzh.ddd.domain;

import io.github.zhdotm.ohzh.ddd.domain.annotation.EnableDDD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 *
 * @author Frank Zhang
 * @date 2020-11-10 3:58 PM
 */

@EnableDDD
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
