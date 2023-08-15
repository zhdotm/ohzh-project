package io.github.zhdotm.ohzh.example.sieve.getter;

import cn.hutool.core.collection.ListUtil;
import io.github.zhdotm.ohzh.sieve.starter.web.getter.ISpringSieveValueGetter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhihao.mao
 */

@Component
public class InnodbTablesTableIdSieveValueGetter implements ISpringSieveValueGetter {

    @Override
    public List<String> get() {

        return ListUtil.of("1038", "1039", "1040", "1041", "1042", "1043", "1044", "1045");
    }

}
