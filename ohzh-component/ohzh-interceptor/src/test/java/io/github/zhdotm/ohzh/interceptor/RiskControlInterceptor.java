package io.github.zhdotm.ohzh.interceptor;

import cn.hutool.core.lang.Assert;

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
public class RiskControlInterceptor implements IInterceptor {

    @Override
    public Integer order() {

        return 2;
    }

    @Override
    public Object intercept(InterceptPointInvocation interceptPointInvocation) {
        System.out.println("进入风控拦截器");
        Object[] args = interceptPointInvocation.getArgs();
        BigDecimal originalAmount = (BigDecimal) args[0];
        //原始金额不能小于0
        Assert.isFalse(originalAmount.doubleValue() < 0, "原始金额不能小于0");
        BigDecimal preferentialAmount = (BigDecimal) args[1];
        Assert.isFalse(preferentialAmount.doubleValue() < 0, "优惠金额不能小于0");
        Assert.isFalse(originalAmount.subtract(preferentialAmount).doubleValue() < 0, "优惠金额不能大于原金额不能小于0");

        return interceptPointInvocation.proceed();
    }

    @Override
    public <T> T assemble(T target) {

        return InterceptorAssembler.assemble(target, this);
    }

}
