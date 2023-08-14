package io.github.zhdotm.ohzh.example.sieve.service.impl;

import io.github.zhdotm.ohzh.example.sieve.dto.SimpleInnodbTablestatsDTO;
import io.github.zhdotm.ohzh.example.sieve.mapper.InnodbTablestatsMapper;
import io.github.zhdotm.ohzh.example.sieve.service.InnodbTablestatsService;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieve;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieves;
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
            sieves = {
                    @Sieve(tableName = "INNODB_TABLES", columnName = "TABLE_ID", valueGetterName = "innodbTablesTableIdValueGetter"),
                    @Sieve(tableName = "INNODB_TABLESTATS", columnName = "NUM_ROWS", valueGetterName = "innodbTablestatsNumRowsValueGetter")
            }
    )
    @Override
    public List<SimpleInnodbTablestatsDTO> selectSieveExample() {

        return innodbTablestatsMapper.selectSieveExample();
    }

}
