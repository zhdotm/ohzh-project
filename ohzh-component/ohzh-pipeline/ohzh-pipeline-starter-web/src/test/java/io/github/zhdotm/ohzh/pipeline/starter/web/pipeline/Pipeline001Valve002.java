package io.github.zhdotm.ohzh.pipeline.starter.web.pipeline;

import io.github.zhdotm.ohzh.pipeline.core.IValveContext;
import io.github.zhdotm.ohzh.pipeline.starter.web.adapter.ISpringValve;
import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.Valve;

@Valve(pipelineName = "pipeline001", name = "valve002", order = 2)
public class Pipeline001Valve002 implements ISpringValve<String, Integer> {

    @Override
    public Integer drawOff(IValveContext<String, Integer> context, String input) {
        input = input + "\n 经过valve002处理 \n";
        context.setAttr("valve002", "valve002处理后的中间值");

        return context.fireDrawOff(input);
    }

}
