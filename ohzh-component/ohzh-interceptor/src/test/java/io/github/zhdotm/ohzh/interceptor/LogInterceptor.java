package io.github.zhdotm.ohzh.interceptor;

import java.math.BigDecimal;

/**
 * 风控拦截器
 *
 * @author zhihao.mao
 */

@Interceptor(
        points = {
                @Interceptor.InterceptPoint(
                        type = IBizService.class,
                        method = "getNeedPaidAmount",
                        args = {BigDecimal.class, BigDecimal.class}
                )
        }
)
public class LogInterceptor implements IInterceptor {

    @Override
    public Integer order() {
        return 1;
    }

    @Override
    public Object intercept(InterceptPointInvocation interceptPointInvocation) {
        System.out.println("进入日志拦截器");

        return interceptPointInvocation.proceed();
    }

    @Override
    public <T> T assemble(T target) {

        return InterceptorAssembler.assemble(target, this);
    }

}
