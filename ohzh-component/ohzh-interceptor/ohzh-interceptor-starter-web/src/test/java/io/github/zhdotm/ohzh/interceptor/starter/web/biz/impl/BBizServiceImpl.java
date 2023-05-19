package io.github.zhdotm.ohzh.interceptor.starter.web.biz.impl;

import io.github.zhdotm.ohzh.interceptor.starter.web.biz.IBBizService;
import org.springframework.stereotype.Component;

@Component("bBizService1")
public class BBizServiceImpl implements IBBizService {

    @Override
    public String method1(String param1, Integer param2, Boolean param3) {

        return "bBizService1的method1什么都没改";
    }

    @Override
    public String method2() {

        return "bBizService1的method2什么都没改";
    }

}
