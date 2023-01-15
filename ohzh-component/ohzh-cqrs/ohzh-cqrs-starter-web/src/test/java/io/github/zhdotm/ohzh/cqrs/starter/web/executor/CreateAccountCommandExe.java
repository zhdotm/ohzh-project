package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.CommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;

@CommandExecutor(name = "创建账户命令执行器",
        code = "createAccountCommandExe",
        bizId = "userCenter",
        useCase = "account")
public class CreateAccountCommandExe implements ICommandExecutor {

    public void createAccount(CreateAccountCommand cmd) {
        System.out.println("===创建账户===");
    }
}
