package io.github.zhdotm.ohzh.example.sieve.service;

import io.github.zhdotm.ohzh.example.sieve.domain.Engines;

import java.util.List;

/**
 * @author zhihao.mao
 * @description 针对表【ENGINES】的数据库操作Service
 * @createDate 2023-08-13 23:51:09
 */
public interface EnginesService {

    List<Engines> selectSieveExample();
}
