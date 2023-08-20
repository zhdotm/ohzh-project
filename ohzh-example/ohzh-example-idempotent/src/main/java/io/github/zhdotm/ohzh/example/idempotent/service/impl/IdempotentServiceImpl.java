package io.github.zhdotm.ohzh.example.idempotent.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.example.idempotent.service.IIdempotentService;
import io.github.zhdotm.ohzh.idempotent.core.annotation.Idempotent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhihao.mao
 */

@Component
public class IdempotentServiceImpl implements IIdempotentService {

    @Transactional(rollbackFor = Exception.class)
    @Idempotent(bizId = "test", keyExpressionText = "#map[userId]"
//            , handlerName = "jdbcIdempotentHandler"
    )
    @Override
    public String test01(Map<String, Object> map) {
        ThreadUtil.sleep(10 * 1000);
        map = Optional.ofNullable(map)
                .orElse(new HashMap<>());
        map.put("method", "test01");

        return JSONUtil.toJsonStr(map);
    }

}
