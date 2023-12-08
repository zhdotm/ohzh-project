package io.github.zhdotm.ohzh.ddd.domain.aggregation.entity;

import io.github.zhdotm.ohzh.ddd.domain.aggregation.entity.IEntity;

/**
 * 聚合根
 * 聚合根是实体，作为聚合的管理者，它有实体的特点，具有全局唯一标识，有独立的生命周期。
 * 聚合根在聚合内对实体和值对象采用直接对象引用的方式进行组织和协调，聚合根与聚合根之间通过ID关联的方式实现聚合之间的协同。
 * 聚合根是组成聚合的对象群的根，它在整个领域模型中都可见，可以直接引用。
 * 聚合根负责保证聚合内对象的有效性，持久化所有被封装的对象，以及负责级联更新和删除聚合里的实体。
 * 查询操作只能获取聚合根，访问内部对象必须总是通过聚合根的接口来完成。
 * <p>
 *
 * @author zhihao.mao
 */

public interface IAggregateRoot<Id> extends IEntity<Id> {

}
