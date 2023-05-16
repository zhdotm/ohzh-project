package io.github.zhdotm.ohzh.pipeline.starter.web.runner;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.pipeline.core.Pipeline;
import io.github.zhdotm.ohzh.pipeline.starter.web.adapter.ISpringValve;
import io.github.zhdotm.ohzh.pipeline.starter.web.annotation.Valve;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 管道组装器
 *
 * @author zhihao.mao
 */

@Slf4j
public class SpringPipelineRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<ISpringValve<?, ?>> valves = SpringUtil
                .getConfigurableBeanFactory()
                .getBeansWithAnnotation(Valve.class)
                .values()
                .stream()
                .filter(obj -> obj instanceof ISpringValve)
                .map(obj -> (ISpringValve<?, ?>) obj)
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(valves)) {

            return;
        }

        Map<String, List<ISpringValve<?, ?>>> pipelineNameValvesMap = valves
                .stream()
                .collect(Collectors.groupingBy(ISpringValve::getPipelineName));
        pipelineNameValvesMap.forEach((pipelineName, valvesTemp) -> {
            valvesTemp.sort(Comparator.comparingInt(ISpringValve::getOrder));
            Pipeline pipeline = new Pipeline();
            pipeline.setName(pipelineName);
            valvesTemp.forEach(valve -> pipeline.addLastValve(valve.getName(), valve));

            SpringUtil.registerBean(pipelineName, pipeline);
        });
    }

}
