package io.github.zhdotm.ohzh.ddd.domain;


import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001.DemoAggRoot001;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAbilityExtensionPoint;
import io.github.zhdotm.ohzh.ddd.domain.enums.DomainAbilityExtensionScopeEnum;
import io.github.zhdotm.ohzh.ddd.domain.extension.DomainAbilityExtensionExecutors;
import io.github.zhdotm.ohzh.ddd.domain.extension.IDomainAbilityExtensionPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    private DemoAggRoot001 demoAggRoot001;

    @Test
    public void test() {
        demoAggRoot001.doSomething();
        AggRootExtensionPoint001 aggRootExtension001 = new AggRootExtensionPoint001();
        DomainAbilityExtensionExecutors.registerExtension(null, aggRootExtension001);
        demoAggRoot001.execute(BizScenario.newDefault(), AggRootExtensionPoint001.class, AggRootExtensionPoint001::doAggRootExtension001Thing);
    }

    @DomainAbilityExtensionPoint(code = "aggRoot001Extension001",
            name = "001号聚合根的001号拓展",
            scope = DomainAbilityExtensionScopeEnum.AGGREGATE_ROOT,
            targetCode = "demoAggRoot001")
    public static class AggRootExtensionPoint001 implements IDomainAbilityExtensionPoint {
        public void doAggRootExtension001Thing() {
            System.out.println("001号聚合根的001号拓展的东西");
        }
    }
}
