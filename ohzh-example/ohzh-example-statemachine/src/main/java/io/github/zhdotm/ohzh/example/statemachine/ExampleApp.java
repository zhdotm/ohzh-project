package io.github.zhdotm.ohzh.example.statemachine;

import io.github.zhdotm.ohzh.starter.statemachine.annotation.EnableStateMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhihao.mao
 */
@SpringBootApplication
@EnableStateMachine
public class ExampleApp {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }

}
