/**
 * 仓储
 * <p>
 * 它存放所在聚合的查询或持久化领域对象的代码，通常包括仓储接口和仓储实现方法。为了方便聚合的拆分和组合，我们设定了一个原则：一个聚合对应一个仓储。
 * <p>
 * 特别说明：按照 DDD 分层架构，仓储实现本应该属于基础层代码。
 *
 * @author zhihao.mao
 */

package io.github.zhdotm.ohzh.ddd.domain.repository;