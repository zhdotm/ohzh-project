package io.github.zhdotm.ohzh.pipeline.starter.web.pipeline;

import io.github.zhdotm.ohzh.pipeline.core.IValveContext;
import io.github.zhdotm.ohzh.pipeline.starter.web.adapter.ISpringValve;
import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.SpringValve;

@SpringValve(pipelineName = "pipeline001", name = "valve001", order = 1)
public class Pipeline001Valve001 implements ISpringValve<String, Integer> {

    @Override
    public Integer drawOff(IValveContext<String, Integer> context, String input) {
        input = input + "\n 经过valve001处理 \n";
        context.setAttr("valve001", "valve001处理后的中间值");

        return context.fireDrawOff(input);
    }

}
