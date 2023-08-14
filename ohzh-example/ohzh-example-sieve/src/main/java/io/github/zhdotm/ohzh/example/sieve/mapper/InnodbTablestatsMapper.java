package io.github.zhdotm.ohzh.example.sieve.mapper;

import io.github.zhdotm.ohzh.example.sieve.dto.SimpleInnodbTablestatsDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhihao.mao
 * @description 针对表【INNODB_TABLESTATS】的数据库操作Mapper
 * @createDate 2023-08-14 23:28:54
 * @Entity io.github.zhdotm.ohzh.example.sieve.domain.InnodbTablestats
 */
public interface InnodbTablestatsMapper {

    @Select(" select INNODB_TABLES.TABLE_ID, INNODB_TABLES.NAME, INNODB_TABLES.FLAG, INNODB_TABLES.N_COLS, INNODB_TABLES.SPACE, INNODB_TABLESTATS.STATS_INITIALIZED, INNODB_TABLESTATS.NUM_ROWS from INNODB_TABLESTATS left join INNODB_TABLES on INNODB_TABLESTATS.TABLE_ID = INNODB_TABLES.TABLE_ID where INNODB_TABLESTATS.NAME like '%time%'")
    List<SimpleInnodbTablestatsDTO> selectSieveExample();
}




