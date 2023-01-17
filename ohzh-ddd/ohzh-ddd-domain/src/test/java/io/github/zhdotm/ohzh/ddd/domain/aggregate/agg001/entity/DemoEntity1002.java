package io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001.entity;

import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.IDomainEntity;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainEntity;

/**
 * 1号聚合根下的领域实体2
 *
 * @author zhihao.mao
 */

@DomainEntity(code = "demoEntity1002", name = "1号聚合根下的领域实体2")
public class DemoEntity1002 implements IDomainEntity {

    public void step2() {
        System.out.println("DemoEntity1002第二步");
    }
}
