package io.github.zhdotm.ohzh.interceptor;

import java.math.BigDecimal;

public class AppTest {

    public static void main(String[] args) {
        BizService bizService = new BizService();
        InterceptorChain interceptorChain = new InterceptorChain();
        LogInterceptor logInterceptor = new LogInterceptor();
        interceptorChain.addInterceptor(new RiskControlInterceptor());
        interceptorChain.addInterceptor(logInterceptor);
        IBizService bizService1 = interceptorChain.assembleAll(bizService);
        bizService1.getNeedPaidAmount(new BigDecimal("1"), new BigDecimal("2"));
    }
}
