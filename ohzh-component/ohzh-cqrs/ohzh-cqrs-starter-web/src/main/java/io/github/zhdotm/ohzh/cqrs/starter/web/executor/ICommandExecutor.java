package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.CommandExecutor;
import org.springframework.core.annotation.AnnotationUtils;

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
        CommandExecutor commandExecutor = AnnotationUtils.getAnnotation(this.getClass(), CommandExecutor.class);

        return commandExecutor.name();
    }

    /**
     * 获取执行器编码
     *
     * @return 执行器编码
     */
    default String getCode() {
        CommandExecutor commandExecutor = AnnotationUtils.getAnnotation(this.getClass(), CommandExecutor.class);

        return commandExecutor.code();
    }

}
