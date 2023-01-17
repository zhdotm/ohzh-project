package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.cqrs.core.exception.CQRSException;
import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.CommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.enums.CQRSExceptionEnum;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.function.Supplier;

/**
 * 命令执行器抽象接口
 *
 * @author zhihao.mao
 */

public interface ICommandExecutor extends ICQRSExecutor {

    /**
     * 获取执行器名称
     *
     * @return 执行器名称
     */
    default String getName() {
        CommandExecutor commandExecutorAnnotation = getCommandExecutorAnnotation();

        return commandExecutorAnnotation.name();
    }

    /**
     * 获取执行器编码
     *
     * @return 执行器编码
     */
    default String getCode() {
        CommandExecutor commandExecutorAnnotation = getCommandExecutorAnnotation();

        return commandExecutorAnnotation.code();
    }

    /**
     * 获取命令执行器注解
     *
     * @return 命令执行器注解
     */
    @SneakyThrows
    default CommandExecutor getCommandExecutorAnnotation() {
        CommandExecutor commandExecutor = AnnotationUtils.getAnnotation(this.getClass(), CommandExecutor.class);
        String simpleName = this.getClass().getSimpleName();
        Assert.notNull(commandExecutor, (Supplier<Throwable>) () -> new CQRSException(CQRSExceptionEnum.COMMAND_EXECUTOR_ANNOTATION_NOT_EXIST.getCode(), CQRSExceptionEnum.COMMAND_EXECUTOR_ANNOTATION_NOT_EXIST.getMessage(simpleName)));

        return commandExecutor;
    }

    /**
     * 是否存在CommandExecutor注解
     *
     * @return 是/否
     */
    default Boolean isExistCommandExecutorAnnotation() {
        CommandExecutor commandExecutor = AnnotationUtils.getAnnotation(this.getClass(), CommandExecutor.class);

        return ObjectUtil.isNotEmpty(commandExecutor);
    }

}
