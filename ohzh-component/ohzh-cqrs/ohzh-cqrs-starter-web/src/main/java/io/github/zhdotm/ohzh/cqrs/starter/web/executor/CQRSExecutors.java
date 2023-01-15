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

    @SneakyThrows
    public <T extends ICommandExecutor> void execute(Class<T> cmdExeClazz,
                                                     BizScenario bizScenario,
                                                     Consumer<T> cmdExeConsumer) {
        T commandExecutor = CQRSExecutorFactory.getCommandExecutor(bizScenario, cmdExeClazz);

        cmdExeConsumer.accept(commandExecutor);
    }

    @SneakyThrows
    public <T extends ICommandExecutor, R> R execute(Class<T> cmdExeClazz,
                                                     BizScenario bizScenario,
                                                     Function<T, R> cmdExeConsumer) {
        T commandExecutor = CQRSExecutorFactory.getCommandExecutor(bizScenario, cmdExeClazz);

        return cmdExeConsumer.apply(commandExecutor);
    }

    public <T extends IQueryExecutor, R> R query(Class<T> queryExeClazz,
                                                 BizScenario bizScenario,
                                                 Function<T, R> cmdExeConsumer) {
        T commandExecutor = CQRSExecutorFactory.getQueryExecutor(bizScenario, queryExeClazz);

        return cmdExeConsumer.apply(commandExecutor);
    }

}
