package io.github.zhdotm.ohzh.cqrs.starter.web.executor;

import io.github.zhdotm.ohzh.cqrs.starter.web.annotations.QueryExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.query.GetAccountQuery;
import io.github.zhdotm.ohzh.cqrs.starter.web.resp.GetAccountResp;

@QueryExecutor(name = "查询账户请求执行器",
        code = "getAccountQueryExe",
        bizId = "userCenter",
        useCase = "account",
        scenario = "enterprise")
public class GetAccountQueryExe implements IQueryExecutor {

    public GetAccountResp getAccount(GetAccountQuery getAccountQuery) {
        System.out.println("===查询账户===");

        return null;
    }

}
