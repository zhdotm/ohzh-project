package io.github.zhdotm.ohzh.interceptor.starter.web;


import io.github.zhdotm.ohzh.interceptor.starter.web.biz.IABizService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    private IABizService aBizService1;

    @Test
    public void test() {
        System.out.println(aBizService1.method1("张三", 3, Boolean.TRUE));
    }
}
