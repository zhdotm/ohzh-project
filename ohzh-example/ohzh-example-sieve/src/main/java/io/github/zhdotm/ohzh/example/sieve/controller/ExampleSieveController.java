package io.github.zhdotm.ohzh.example.sieve.controller;

import io.github.zhdotm.ohzh.example.sieve.domain.Engines;
import io.github.zhdotm.ohzh.example.sieve.service.EnginesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhihao.mao
 */

@RestController
@RequestMapping("/example/sieve")
public class ExampleSieveController {

    @Autowired
    private EnginesService enginesService;

    @GetMapping("/selectSieveExample")
    public List<Engines> selectSieveExample() {

        return enginesService.selectSieveExample();
    }
    
}
