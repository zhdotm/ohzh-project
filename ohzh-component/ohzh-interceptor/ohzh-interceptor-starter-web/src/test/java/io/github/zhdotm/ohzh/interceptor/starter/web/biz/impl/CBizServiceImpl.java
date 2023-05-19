package io.github.zhdotm.ohzh.interceptor.starter.web.biz.impl;

import io.github.zhdotm.ohzh.interceptor.starter.web.biz.ICBizService;
import org.springframework.stereotype.Component;

@Component("cBizService1")
public class CBizServiceImpl implements ICBizService {

    @Override
    public String method1(String param1, Integer param2, Boolean param3) {

        return "cBizService1的method1什么都没改";
    }

    @Override
    public String method2() {

        return "cBizService1的method2什么都没改";
    }

}
