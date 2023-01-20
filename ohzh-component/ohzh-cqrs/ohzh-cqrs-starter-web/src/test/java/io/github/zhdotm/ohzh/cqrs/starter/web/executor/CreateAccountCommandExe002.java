package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.CommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;

@CommandExecutor(name = "创建账户命令执行器002号",
        code = "createAccountCommandExe",
        bizId = "userCenter",
        useCase = "account",
        scenario = "002")
public class CreateAccountCommandExe002 implements ICreateAccountCommandExecutor {

    @Override
    public void createAccount(CreateAccountCommand cmd) {
        System.out.println("002号执行器===创建账户===");
    }

}
