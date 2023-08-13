package io.github.zhdotm.ohzh.example.sieve.mapper;

import io.github.zhdotm.ohzh.example.sieve.domain.Engines;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhihao.mao
 * @description 针对表【ENGINES】的数据库操作Mapper
 * @createDate 2023-08-13 23:51:09
 * @Entity io.github.zhdotm.ohzh.example.sieve.domain.Engines
 */
public interface EnginesMapper {

    @Select(" select * from engines where !isnull(engines.engine) ")
    List<Engines> selectSieveExample();
}




