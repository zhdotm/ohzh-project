package io.github.zhdotm.ohzh.example.sieve.getter;

import cn.hutool.core.collection.ListUtil;
import io.github.zhdotm.ohzh.sieve.starter.web.getter.ISpringExpressionTextSieveValueGetter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhihao.mao
 */

@Component
public class EnginesSupportExpressionTextSieveValueGetter implements ISpringExpressionTextSieveValueGetter {

    @Override
    public List<String> get() {
        return ListUtil.of(" 1 = 1 ", " engines.support = 'YES' ", " TRANSACTIONS = 'YES' ");
    }
}
