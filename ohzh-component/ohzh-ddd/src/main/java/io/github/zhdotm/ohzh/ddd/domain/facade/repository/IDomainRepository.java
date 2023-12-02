package io.github.zhdotm.ohzh.ddd.domain.facade.repository;

import io.github.zhdotm.ohzh.ddd.domain.facade.IDomainFacade;

/**
 * 仓储（继承领域门面，可以被领域服务、用户应用调用）
 * 主要用于获取、持久化领域对象
 *
 * @author zhihao.mao
 */

public interface IDomainRepository extends IDomainFacade {
}
