package io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001;

import io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001.entity.DemoEntity1001;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001.entity.DemoEntity1002;
import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.IDomainAggregateRoot;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainAggregateRoot;

/**
 * 聚合根用于访问实体001
 *
 * @author zhihao.mao
 */

@DomainAggregateRoot(code = "demoAggRoot001", name = "案例聚合根001号")
public class DemoAggRoot001 implements IDomainAggregateRoot {

    public void doSomething() {
        DemoEntity1001 domainEntity1001 = createDomainEntity(DemoEntity1001.class);
        DemoEntity1002 domainEntity1002 = createDomainEntity(DemoEntity1002.class);
        domainEntity1001.setId("xxxxxx");
        domainEntity1001.step1();
        domainEntity1002.step2();
    }

}
