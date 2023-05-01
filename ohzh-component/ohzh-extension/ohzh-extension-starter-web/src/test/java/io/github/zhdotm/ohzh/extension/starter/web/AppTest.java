package io.github.zhdotm.ohzh.extension.starter.web;


import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.executor.IExtensionExecutor;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointA;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    private IExtensionExecutor extensionExecutor;

    @Test
    public void test() {
        extensionExecutor.execute(BizScenario.newDefault(), IPointA.class, IPointA::methodA);
        String defaultResult = extensionExecutor.execute(BizScenario.newDefault(), IPointB.class, IPointB::methodB);
        String jiaResult = extensionExecutor.execute(BizScenario.valueOf("bizId", "useCase", "scenarioJia"), IPointB.class, IPointB::methodB);
        System.out.println(defaultResult);
        System.out.println(jiaResult);
    }

}
