package io.github.zhdotm.ohzh.cqrs.starter.web;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.core.query.IQuery;
import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.QueryExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.command.CreateAccountCommand;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.CQRSExecutors;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.GetAccountQueryExe;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.ICreateAccountCommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.IQueryExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.query.GetAccountQuery;
import io.github.zhdotm.ohzh.cqrs.starter.web.resp.GetAccountResp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
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

    @Before
    public void register() {

        CQRSExecutors.registerQueryExecutor("queryExecutorDemo01", new QueryExecutorDemo01());
    }

    @Test
    public void command() {
        CreateAccountCommand createAccountCommand = new CreateAccountCommand();
        createAccountCommand
                .setUserId(1L)
                .setUserName("张三")
                .setAccount("zhangsan")
                .setPassword("123456");
        cqrsExecutors.execute(createAccountCommand.getBizScenario(),
                ICreateAccountCommandExecutor.class,
                createAccountCommandExecutor -> {
                    createAccountCommandExecutor.createAccount(createAccountCommand);
                });
    }

    @Test
    public void query() {
        GetAccountQuery getAccountQuery = new GetAccountQuery();
        getAccountQuery.setUserId(1L);

        GetAccountResp getAccountResp = cqrsExecutors.query(getAccountQuery.getBizScenario(),
                GetAccountQueryExe.class,
                getAccountQueryExe -> getAccountQueryExe.getAccount(getAccountQuery));
        System.out.println(getAccountResp);
    }

    @Test
    public void query001() {
        DemoQuery001 demoQuery001 = new DemoQuery001();

        String queryResult = cqrsExecutors.query(demoQuery001.getBizScenario(), QueryExecutorDemo01.class, queryExecutorDemo01 -> queryExecutorDemo01.doSomething(demoQuery001));
        System.out.println(queryResult);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @QueryExecutor(name = "查询执行器例子01", code = "queryExecutorDemo01", bizId = "demo001", useCase = "case001", scenario = "scenario001")
    public static class QueryExecutorDemo01 implements IQueryExecutor {

        private int field01;

        public String doSomething(DemoQuery001 query001) {

            return query001 + ": QueryExecutorDemo01执行: ......";
        }

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DemoQuery001 implements IQuery {

        private String desc = "查询命令001";

        @Override
        public BizScenario getBizScenario() {

            return BizScenario.valueOf("demo001", "case001", "scenario001");
        }

    }

}
