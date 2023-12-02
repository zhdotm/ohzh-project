package io.github.zhdotm.ohzh.ddd.domain.aggregation.entity;

/**
 * 领域实体
 * 有 ID 标识，通过 ID 判断相等性，ID 在聚合内唯一即可。
 * 状态可变，它依附于聚合根，其生命周期由聚合根管理。
 * 实体一般会持久化，但与数据库持久化对象不一定是一对一的关系。
 * 实体可以引用聚合内的聚合根、实体和值对象。
 * 实体之间的交互应该通过聚合根来进行，以确保聚合的完整性和一致性。
 * 聚合根起到了一个中介的角色，负责协调和同步聚合内的实体和值对象之间的交互。
 *
 * @author zhihao.mao
 */
public interface IEntity<Id> {

    /**
     * 获取ID标识
     *
     * @return ID标识
     */
    Id getUniqueId();

}
