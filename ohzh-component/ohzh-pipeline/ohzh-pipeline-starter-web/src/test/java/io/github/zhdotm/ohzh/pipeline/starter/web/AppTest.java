package io.github.zhdotm.ohzh.pipeline.starter.web;


import io.github.zhdotm.ohzh.pipeline.core.Pipeline;
import io.github.zhdotm.ohzh.pipeline.starter.web.support.SpringPipelineSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Test
    public void test() {
        Integer output = SpringPipelineSupport.drawOff("pipeline001", "张三");
        System.out.println(output);

        Pipeline<String, Integer> pipeline001 = SpringPipelineSupport.getPipeline("pipeline001");
        System.out.println(pipeline001.drawOff("lisi"));
    }
}
