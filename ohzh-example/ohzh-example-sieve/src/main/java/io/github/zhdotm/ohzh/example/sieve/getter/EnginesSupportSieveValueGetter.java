package io.github.zhdotm.ohzh.example.sieve.getter;

import cn.hutool.core.collection.ListUtil;
import io.github.zhdotm.ohzh.sieve.starter.web.getter.ISpringSieveValueGetter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhihao.mao
 */

@Component
public class EnginesSupportSieveValueGetter implements ISpringSieveValueGetter {

    @Override
    public List<String> get() {

        return ListUtil.of("YES", "DEFAULT");
    }

}
