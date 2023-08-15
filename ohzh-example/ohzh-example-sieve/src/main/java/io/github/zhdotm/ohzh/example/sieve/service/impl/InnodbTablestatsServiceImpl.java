package io.github.zhdotm.ohzh.example.sieve.service.impl;

import io.github.zhdotm.ohzh.example.sieve.dto.SimpleInnodbTablestatsDTO;
import io.github.zhdotm.ohzh.example.sieve.mapper.InnodbTablestatsMapper;
import io.github.zhdotm.ohzh.example.sieve.service.InnodbTablestatsService;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieves;
import io.github.zhdotm.ohzh.sieve.core.annotation.ValueSieve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhihao.mao
 */

@Component
public class InnodbTablestatsServiceImpl implements InnodbTablestatsService {

    @Autowired
    private InnodbTablestatsMapper innodbTablestatsMapper;

    @Sieves(
            valueSieves = {
                    @ValueSieve(tableName = "INNODB_TABLES", columnName = "TABLE_ID", valueGetterName = "innodbTablesTableIdSieveValueGetter"),
                    @ValueSieve(tableName = "INNODB_TABLESTATS", columnName = "NUM_ROWS", valueGetterName = "innodbTablestatsNumRowsSieveValueGetter")
            }
    )
    @Override
    public List<SimpleInnodbTablestatsDTO> selectSieveExample() {

        return innodbTablestatsMapper.selectSieveExample();
    }

}
