package io.github.zhdotm.ohzh.example.idempotent.service;

import java.util.Map;

/**
 * @author zhihao.mao
 */

public interface IIdempotentService {

    String test01(Map<String, Object> map);
}
