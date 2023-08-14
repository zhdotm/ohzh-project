package io.github.zhdotm.ohzh.example.sieve.getter;

import cn.hutool.core.collection.ListUtil;
import io.github.zhdotm.ohzh.sieve.starter.web.getter.ISpringValueGetter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhihao.mao
 */

@Component
public class EnginesEngineExpressionTextValueGetter implements ISpringValueGetter {

    @Override
    public List<String> get() {

        return ListUtil.of("MyISAM", "InnoDB", "MEMORY");
    }

}
