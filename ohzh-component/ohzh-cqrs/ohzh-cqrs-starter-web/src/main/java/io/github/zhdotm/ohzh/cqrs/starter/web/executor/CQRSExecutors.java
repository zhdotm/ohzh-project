package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.starter.web.CQRSExecutorFactory;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * CQRS执行器
 *
 * @author zhihao.mao
 */

@Component
public class CQRSExecutors {

    /**
     * 注册查询执行器
     *
     * @param name     执行器名称
     * @param queryExe 执行器
     */
    @SneakyThrows
    public static void registerQueryExecutor(String name, IQueryExecutor queryExe) {

        CQRSExecutorFactory.registerQueryExecutor(name, queryExe);
    }

    /**
     * 注册命令执行器
     *
     * @param name   执行器名称
     * @param cmdExe 执行器
     */
    @SneakyThrows
    public static void registerCommandExecutor(String name, ICommandExecutor cmdExe) {

        CQRSExecutorFactory.registerCommandExecutor(name, cmdExe);
    }

    /**
     * 执行命令执行器（无返回）
     *
     * @param bizScenario    业务身份
     * @param cmdExeClazz    命令执行器类型
     * @param cmdExeConsumer 命令执行器消费者
     * @param <T>            命令执行器类型
     */
    @SneakyThrows
    public <T extends ICommandExecutor> void execute(BizScenario bizScenario,
                                                     Class<T> cmdExeClazz,
                                                     Consumer<T> cmdExeConsumer) {
        T commandExecutor = CQRSExecutorFactory.getCommandExecutor(bizScenario, cmdExeClazz);

        cmdExeConsumer.accept(commandExecutor);
    }

    /**
     * 执行命令执行器（有返回）
     *
     * @param bizScenario    业务身份
     * @param cmdExeClazz    命令执行器类型
     * @param cmdExeFunction 命令执行器方法
     * @param <T>            命令执行器类型
     * @param <R>            出参类型
     * @return 出参
     */
    @SneakyThrows
    public <T extends ICommandExecutor, R> R execute(BizScenario bizScenario,
                                                     Class<T> cmdExeClazz,
                                                     Function<T, R> cmdExeFunction) {
        T commandExecutor = CQRSExecutorFactory.getCommandExecutor(bizScenario, cmdExeClazz);

        return cmdExeFunction.apply(commandExecutor);
    }

    /**
     * 执行查询执行器
     *
     * @param bizScenario    业务身份
     * @param queryExeClazz  查询执行器类型
     * @param cmdExeConsumer 查询执行器消费者
     * @param <T>            查询执行器类型
     * @param <R>            出参类型
     * @return 出参
     */
    public <T extends IQueryExecutor, R> R query(BizScenario bizScenario,
                                                 Class<T> queryExeClazz,
                                                 Function<T, R> cmdExeConsumer) {
        T commandExecutor = CQRSExecutorFactory.getQueryExecutor(bizScenario, queryExeClazz);

        return cmdExeConsumer.apply(commandExecutor);
    }

}
