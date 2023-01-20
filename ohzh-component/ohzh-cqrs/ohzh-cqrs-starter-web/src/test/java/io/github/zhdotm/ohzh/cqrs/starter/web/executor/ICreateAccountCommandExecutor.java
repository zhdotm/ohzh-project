package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;

/**
 * 创建账户执行器抽象
 */

public interface ICreateAccountCommandExecutor extends ICommandExecutor {

    void createAccount(CreateAccountCommand cmd);

}
