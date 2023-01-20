package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.CommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;

@CommandExecutor(name = "创建账户命令执行器001号",
        code = "createAccountCommandExe001",
        bizId = "userCenter",
        useCase = "account",
        scenario = "001")
public class CreateAccountCommandExe001 implements ICreateAccountCommandExecutor {

    @Override
    public void createAccount(CreateAccountCommand cmd) {
        System.out.println("001号执行器===创建账户===");
    }

}
