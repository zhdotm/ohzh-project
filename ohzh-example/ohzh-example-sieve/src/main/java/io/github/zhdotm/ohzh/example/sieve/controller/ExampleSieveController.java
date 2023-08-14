package io.github.zhdotm.ohzh.example.sieve.controller;

import io.github.zhdotm.ohzh.example.sieve.domain.Engines;
import io.github.zhdotm.ohzh.example.sieve.dto.SimpleInnodbTablestatsDTO;
import io.github.zhdotm.ohzh.example.sieve.service.EnginesService;
import io.github.zhdotm.ohzh.example.sieve.service.InnodbTablestatsService;
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

    @Autowired
    private InnodbTablestatsService innodbTablestatsService;

    @GetMapping("/selectSieveExample/engines")
    public List<Engines> selectSieveExampleEngines() {

        return enginesService.selectSieveExample();
    }

    @GetMapping("/selectSieveExample/simpleInnodbTablestats")
    public List<SimpleInnodbTablestatsDTO> selectSieveExampleSimpleInnodbTablestats() {

        return innodbTablestatsService.selectSieveExample();
    }

}
