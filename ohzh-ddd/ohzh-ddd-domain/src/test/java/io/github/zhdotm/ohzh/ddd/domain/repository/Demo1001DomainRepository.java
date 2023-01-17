package io.github.zhdotm.ohzh.ddd.domain.repository;

import io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001.entity.DemoEntity1001;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainRepository;

/**
 * demo1001号仓储层
 *
 * @author zhihao.mao
 */

@DomainRepository(code = "demo1001DomainRepository", name = "demo1001号仓储层")
public class Demo1001DomainRepository implements IDomainRepository {

    public void update(DemoEntity1001 demoEntity1001) {
        System.out.println("更新落库demoEntity1001");
    }

}
