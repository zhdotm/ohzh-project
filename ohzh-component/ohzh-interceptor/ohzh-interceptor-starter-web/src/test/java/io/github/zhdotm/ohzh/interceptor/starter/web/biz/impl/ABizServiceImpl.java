package io.github.zhdotm.ohzh.interceptor.starter.web.biz.impl;

import io.github.zhdotm.ohzh.interceptor.starter.web.biz.IABizService;
import org.springframework.stereotype.Component;

@Component("aBizService1")
public class ABizServiceImpl implements IABizService {

    @Override
    public String method1(String param1, Integer param2, Boolean param3) {

        return "aBizService1的method1什么都没改";
    }

    @Override
    public String method2() {

        return "aBizService1的method2什么都没改";
    }

}
