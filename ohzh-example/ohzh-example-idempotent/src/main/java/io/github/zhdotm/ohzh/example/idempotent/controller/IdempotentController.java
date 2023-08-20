package io.github.zhdotm.ohzh.example.idempotent.controller;

import cn.hutool.core.map.MapUtil;
import io.github.zhdotm.ohzh.example.idempotent.service.IIdempotentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhihao.mao
 */

@RestController
@RequestMapping("/idempotent")
public class IdempotentController {

    @Autowired
    private IIdempotentService idempotentService;

    @GetMapping("/test01")
    public String test01(@RequestParam String userId, @RequestParam String userName) {
        Map<String, Object> dataMap = MapUtil.newHashMap();
        dataMap.put("userId", userId);
        dataMap.put("userName", userName);

        return idempotentService.test01(dataMap);
    }

}
