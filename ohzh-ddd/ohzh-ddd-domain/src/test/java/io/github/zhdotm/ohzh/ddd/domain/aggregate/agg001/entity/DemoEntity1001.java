package io.github.zhdotm.ohzh.ddd.domain.aggregate.agg001.entity;

import io.github.zhdotm.ohzh.ddd.domain.aggregate.entity.IDomainEntity;
import io.github.zhdotm.ohzh.ddd.domain.annotation.DomainEntity;
import io.github.zhdotm.ohzh.ddd.domain.repository.Demo1001DomainRepository;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 1号聚合根下的领域实体1
 *
 * @author zhihao.mao
 */

@Data
@Accessors(chain = true)
@DomainEntity(code = "demoEntity1001", name = "1号聚合根下的领域实体1")
public class DemoEntity1001 implements IDomainEntity {
    private String id;

    public void step1() {
        Demo1001DomainRepository domainRepository = getDomainRepository(Demo1001DomainRepository.class);
        domainRepository.update(this);
        System.out.println("DemoEntity1001第一步");
    }
}
