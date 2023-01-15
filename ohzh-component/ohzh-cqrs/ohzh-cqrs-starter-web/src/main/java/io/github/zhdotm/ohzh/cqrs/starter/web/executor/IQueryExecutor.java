package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.QueryExecutor;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 查询执行器抽象接口
 *
 * @author zhihao.mao
 */

public interface IQueryExecutor extends ICQRSExecutor {

    /**
     * 获取执行器名称
     *
     * @return 执行器名称
     */
    default String getName() {
        QueryExecutor queryExecutor = AnnotationUtils.getAnnotation(this.getClass(), QueryExecutor.class);

        return queryExecutor.name();
    }

    /**
     * 获取执行器编码
     *
     * @return 执行器编码
     */
    default String getCode() {
        QueryExecutor queryExecutor = AnnotationUtils.getAnnotation(this.getClass(), QueryExecutor.class);

        return queryExecutor.code();
    }

}
