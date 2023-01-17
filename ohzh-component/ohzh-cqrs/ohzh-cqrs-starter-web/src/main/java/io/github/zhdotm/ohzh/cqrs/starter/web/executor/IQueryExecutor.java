package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.cqrs.core.exception.CQRSException;
import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.QueryExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.enums.CQRSExceptionEnum;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.function.Supplier;

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
        QueryExecutor queryExecutorAnnotation = getQueryExecutorAnnotation();

        return queryExecutorAnnotation.name();
    }

    /**
     * 获取执行器编码
     *
     * @return 执行器编码
     */
    default String getCode() {
        QueryExecutor queryExecutorAnnotation = getQueryExecutorAnnotation();

        return queryExecutorAnnotation.code();
    }

    /**
     * 获取查询执行器注解
     *
     * @return 查询执行器注解
     */
    @SneakyThrows
    default QueryExecutor getQueryExecutorAnnotation() {
        QueryExecutor queryExecutor = AnnotationUtils.getAnnotation(this.getClass(), QueryExecutor.class);
        String simpleName = this.getClass().getSimpleName();
        Assert.notNull(queryExecutor, (Supplier<Throwable>) () -> new CQRSException(CQRSExceptionEnum.QUERY_EXECUTOR_ANNOTATION_NOT_EXIST.getCode(), CQRSExceptionEnum.COMMAND_EXECUTOR_ANNOTATION_NOT_EXIST.getMessage(simpleName)));

        return queryExecutor;
    }

    /**
     * 是否存在QueryExecutor注解
     *
     * @return 是/否
     */
    default Boolean isExistQueryExecutorAnnotation() {
        QueryExecutor queryExecutor = AnnotationUtils.getAnnotation(this.getClass(), QueryExecutor.class);

        return ObjectUtil.isNotEmpty(queryExecutor);
    }

}
