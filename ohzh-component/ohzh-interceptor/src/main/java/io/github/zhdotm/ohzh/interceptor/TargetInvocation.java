package io.github.zhdotm.ohzh.interceptor;

import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 包含了一组Interceptor和一个Target对象，确保在Target处理请求前后，按照定义顺序调用Interceptor做前置和后置处理
 *
 * @param <Input>  入参
 * @param <Output> 出参
 * @author zhihao.mao
 */

public class TargetInvocation<Input, Output> {

    /**
     * 前值处理器
     */
    private final List<BeforeInterceptor<Input>> beforeInterceptors = new ArrayList<>();

    /**
     * 后置处理器
     */
    private final List<AfterInterceptor<Input, Output>> afterInterceptors = new ArrayList<>();

    @Setter
    private Target<Input, Output> target;

    public Output invoke(Input input) {

        for (BeforeInterceptor<Input> beforeInterceptor : beforeInterceptors) {
            input = beforeInterceptor.before(input);
        }
        Output output = target.execute(input);
        for (AfterInterceptor<Input, Output> afterInterceptor : afterInterceptors) {
            output = afterInterceptor.after(input, output);
        }

        return output;
    }


    public void addInterceptor(Interceptor<Input, Output> interceptor) {
        addBeforeInterceptor(interceptor);
        addAfterInterceptor(interceptor);
    }

    public void addBeforeInterceptor(BeforeInterceptor<Input> beforeInterceptor) {
        beforeInterceptors.add(beforeInterceptor);
        beforeInterceptors.sort(Comparator.comparingInt(BeforeInterceptor::order));
    }

    public void addAfterInterceptor(AfterInterceptor<Input, Output> afterInterceptor) {
        afterInterceptors.add(afterInterceptor);
        afterInterceptors.sort(Comparator.comparingInt(AfterInterceptor::order));
    }

}
