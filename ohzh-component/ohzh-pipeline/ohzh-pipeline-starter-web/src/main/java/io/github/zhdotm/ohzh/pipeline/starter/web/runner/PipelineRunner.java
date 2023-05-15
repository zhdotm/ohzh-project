package io.github.zhdotm.ohzh.pipeline.starter.web.runner;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.pipeline.core.IValve;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Collection;

/**
 * @author zhihao.mao
 */

public class PipelineRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Collection<IValve> valves = SpringUtil.getBeansOfType(IValve.class).values();
        if (CollectionUtil.isEmpty(valves)) {
            return;
        }
    }

}
