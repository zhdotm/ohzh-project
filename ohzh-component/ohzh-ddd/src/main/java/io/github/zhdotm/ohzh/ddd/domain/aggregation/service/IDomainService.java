package io.github.zhdotm.ohzh.ddd.domain.aggregation.service;

import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.ddd.domain.facade.IDomainFacade;

/**
 * 领域服务
 * <p>
 * 领域服务主要用于实现特定于某个领域的任务，封装业务策略和过程。
 * 当领域中某个操作过程或转化过程不是实体或值对象的职责时，通常将该操作放在一个单独的元素中，即领域服务。
 * 领域服务是无状态的，表示领域中具有显著流程的行为。它与通用语言保持一致，包括命名和内部逻辑。
 * 领域服务与聚合在同一包中。在某些情况下，如果某个操作不适合放在聚合和值对象上，最好的方式便是将其建模成领域服务。
 *
 * @author zhihao.mao
 */

public interface IDomainService {

    /**
     * 获取领域门面
     *
     * @param clazz 领域门面类
     * @param <T>   领域门面类型
     * @return 领域门面
     */
    default <T extends IDomainFacade> T getDomainFacade(Class<T> clazz) {

        return SpringUtil.getBean(clazz);
    }

}
