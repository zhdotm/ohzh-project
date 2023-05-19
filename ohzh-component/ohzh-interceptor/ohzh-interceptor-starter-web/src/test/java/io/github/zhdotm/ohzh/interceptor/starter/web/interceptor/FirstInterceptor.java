package io.github.zhdotm.ohzh.interceptor.starter.web.interceptor;

import io.github.zhdotm.ohzh.interceptor.core.IInterceptor;
import io.github.zhdotm.ohzh.interceptor.core.annotation.InterceptPoint;
import io.github.zhdotm.ohzh.interceptor.core.assembler.InterceptorAssembler;
import io.github.zhdotm.ohzh.interceptor.core.invocation.InterceptPointInvocation;
import io.github.zhdotm.ohzh.interceptor.starter.web.annotation.SpringInterceptor;
import io.github.zhdotm.ohzh.interceptor.starter.web.biz.IABizService;

import java.util.Arrays;

@SpringInterceptor(
        name = "firstInterceptor",
        points = {
                @InterceptPoint(type = IABizService.class, method = "method2", args = {}),
                @InterceptPoint(type = IABizService.class, method = "method1", args = {String.class, Integer.class, Boolean.class}),
        })
public class FirstInterceptor implements IInterceptor {

    @Override
    public Object intercept(InterceptPointInvocation interceptPointInvocation) {
        Object[] args = interceptPointInvocation.getArgs();
        System.out.println("输入参数: " + Arrays.toString(args));

        return "修改后的值";
    }

    @Override
    public <T> T assemble(T target) {

        return InterceptorAssembler.getInstance().assemble(target, this);
    }

}
