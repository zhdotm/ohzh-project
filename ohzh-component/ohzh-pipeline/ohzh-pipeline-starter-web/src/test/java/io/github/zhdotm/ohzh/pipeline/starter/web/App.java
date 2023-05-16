package io.github.zhdotm.ohzh.pipeline.starter.web;

import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.EnablePipeline;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhihao.mao
 */

@SpringBootApplication
@EnablePipeline
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
