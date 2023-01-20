package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.CommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;

@CommandExecutor(name = "创建账户命令执行器（默认）",
        code = "defaultCreateAccountCommandExe",
        bizId = "userCenter",
        useCase = "account")
public class CreateAccountCommandExe000 implements ICreateAccountCommandExecutor {

    @Override
    public void createAccount(CreateAccountCommand cmd) {
        System.out.println("默认执行器===创建账户===");
    }

}
