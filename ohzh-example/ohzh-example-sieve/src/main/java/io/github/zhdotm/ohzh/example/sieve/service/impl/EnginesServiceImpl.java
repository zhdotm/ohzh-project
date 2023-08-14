package io.github.zhdotm.ohzh.example.sieve.service.impl;

import io.github.zhdotm.ohzh.example.sieve.domain.Engines;
import io.github.zhdotm.ohzh.example.sieve.mapper.EnginesMapper;
import io.github.zhdotm.ohzh.example.sieve.service.EnginesService;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieve;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhihao.mao
 * @description 针对表【ENGINES】的数据库操作Service实现
 * @createDate 2023-08-13 23:51:09
 */
@Service
public class EnginesServiceImpl implements EnginesService {

    @Autowired
    private EnginesMapper enginesMapper;

    @Sieves(
            sieves = {
                    @Sieve(tableName = "engines", columnName = "support", valueGetterName = "enginesSupportValueGetter"),
                    @Sieve(tableName = "engines", columnName = "engine", valueGetterName = "enginesEngineValueGetter")
            }
    )
    @Override
    public List<Engines> selectSieveExample() {

        return enginesMapper.selectSieveExample();
    }
}




