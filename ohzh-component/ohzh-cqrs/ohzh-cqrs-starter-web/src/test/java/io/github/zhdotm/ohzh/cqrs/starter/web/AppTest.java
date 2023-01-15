package io.github.zhdotm.ohzh.cqrs.starter.web;

import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.CQRSExecutors;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.CreateAccountCommandExe;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.GetAccountQueryExe;
import io.github.zhdotm.ohzh.cqrs.starter.web.query.GetAccountQuery;
import io.github.zhdotm.ohzh.cqrs.starter.web.resp.GetAccountResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    private CQRSExecutors cqrsExecutors;

    @Test
    public void command() {
        CreateAccountCommand createAccountCommand = new CreateAccountCommand();
        createAccountCommand
                .setUserId(1L)
                .setUserName("张三")
                .setAccount("zhangsan")
                .setPassword("123456");
        cqrsExecutors
                .execute(CreateAccountCommandExe.class, createAccountCommand.getBizScenario(), createAccountCommandExe -> {
                    createAccountCommandExe.createAccount(createAccountCommand);
                });
    }

    @Test
    public void query() {
        GetAccountQuery getAccountQuery = new GetAccountQuery();
        getAccountQuery.setUserId(1L);

        GetAccountResp getAccountResp = cqrsExecutors.query(GetAccountQueryExe.class, getAccountQuery.getBizScenario(), getAccountQueryExe -> getAccountQueryExe.getAccount(getAccountQuery));
        System.out.println(getAccountResp);
    }

}
