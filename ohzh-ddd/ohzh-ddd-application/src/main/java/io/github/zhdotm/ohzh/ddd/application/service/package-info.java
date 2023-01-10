/**
 * 应用服务
 * <p>
 * 这层的服务是应用服务。应用服务会对多个领域服务或外部应用服务进行封装、编排和组合，对外提供粗粒度的服务。
 * 应用服务主要实现服务组合和编排，是一段独立的业务逻辑。
 * 你可以将所有应用服务放在一个应用服务类里，也可以把一个应用服务设计为一个应用服务类，以防应用服务类代码量过大。
 *
 * @author zhihao.mao
 */
package io.github.zhdotm.ohzh.ddd.application.service;