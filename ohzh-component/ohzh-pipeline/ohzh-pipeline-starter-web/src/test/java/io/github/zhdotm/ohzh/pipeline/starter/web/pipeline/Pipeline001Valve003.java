package io.github.zhdotm.ohzh.pipeline.starter.web.pipeline;

import io.github.zhdotm.ohzh.pipeline.core.IValveContext;
import io.github.zhdotm.ohzh.pipeline.starter.web.adapter.ISpringValve;
import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.SpringValve;

@SpringValve(pipelineName = "pipeline001", name = "valve003", order = 3)
public class Pipeline001Valve003 implements ISpringValve<String, Integer> {

    @Override
    public Integer drawOff(IValveContext<String, Integer> context, String input) {
        input = input + "\n 经过valve003处理 \n";

        System.out.println(context.getAttrs());
        System.out.println(input);
        return input.length();
    }

}
