package io.github.zhdotm.ohzh.pipeline;

import io.github.zhdotm.ohzh.pipeline.abs.AbstractPipeline;
import io.github.zhdotm.ohzh.pipeline.abs.AbstractValve;

public class MyPipeline extends AbstractPipeline<String, Integer, String> {
    public static void main(String[] args) {
        MyPipeline myPipeline = new MyPipeline();
        HeadValve headValve = new HeadValve();
        SecondValve secondValve = new SecondValve();
        TailValve tailValve = new TailValve();
        myPipeline.addValve(headValve);
        myPipeline.addValve(secondValve);
        myPipeline.addValve(tailValve);
        System.out.println(myPipeline.invoke("输入参数001"));
    }

    public static class HeadValve extends AbstractValve<String, Integer, String> {

        @Override
        public String invoke(String input, Integer tempInput) {
            System.out.println("头部管道阀门: 输入[" + input + "], 临时输入[" + tempInput + "]");
            IValve<String, Integer, String> next = getNext();
            return next.invoke(input, 1);
        }
    }

    public static class SecondValve extends AbstractValve<String, Integer, String> {

        @Override
        public String invoke(String input, Integer tempInput) {
            System.out.println("第二结点管道阀门: 输入[" + input + "], 临时输入[" + tempInput + "]");
            IValve<String, Integer, String> next = getNext();
            return next.invoke(input, tempInput + 2);
        }
    }

    public static class TailValve extends AbstractValve<String, Integer, String> {

        @Override
        public String invoke(String input, Integer tempInput) {
            System.out.println("尾部管道阀门: 输入[" + input + "], 临时输入[" + tempInput + "]");
            return input + "####" + tempInput;
        }
    }

}
