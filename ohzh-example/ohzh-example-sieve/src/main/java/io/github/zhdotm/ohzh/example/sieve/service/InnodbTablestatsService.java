package io.github.zhdotm.ohzh.example.sieve.service;

import io.github.zhdotm.ohzh.example.sieve.dto.SimpleInnodbTablestatsDTO;

import java.util.List;

/**
 * @author zhihao.mao
 */

public interface InnodbTablestatsService {

    List<SimpleInnodbTablestatsDTO> selectSieveExample();
}
