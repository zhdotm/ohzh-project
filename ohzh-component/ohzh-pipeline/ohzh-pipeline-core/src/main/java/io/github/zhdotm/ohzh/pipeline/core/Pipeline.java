package io.github.zhdotm.ohzh.pipeline.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 管道
 *
 * @author zhihao.mao
 */

public class Pipeline<Input, Output> implements IPipeline<Input, Output> {

    private final Map<String, IValveContext<Input, Output>> nameValveContextMap = new HashMap<>();
    private final InheritableThreadLocal<Map<String, Object>> attributesThreadLocal = new InheritableThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {

            return new HashMap<>();
        }
    };
    private IValveContext<Input, Output> firstValveContext;
    private IValveContext<Input, Output> lastValveContext;

    @Override
    public IValve<Input, Output> getFirstValve() {
        if (firstValveContext == null) {

            return null;
        }

        return firstValveContext.getValve();
    }

    @Override
    public IValve<Input, Output> getLastValve() {
        if (lastValveContext == null) {

            return null;
        }

        return lastValveContext.getValve();
    }

    @Override
    public IValve<Input, Output> getValve(String name) {
        IValveContext<Input, Output> valveContext = nameValveContextMap.get(name);
        if (valveContext == null) {

            return null;
        }

        return valveContext.getValve();
    }

    @Override
    public synchronized void addFirstValve(String name, IValve<Input, Output> valve) {
        ValveContext<Input, Output> valveContext = ValveContext.create(name, this, valve);
        nameValveContextMap.put(name, valveContext);
        if (firstValveContext == null) {
            firstValveContext = valveContext;
            lastValveContext = valveContext;
            return;
        }

        firstValveContext.setBefore(valveContext);
        valveContext.setNext(firstValveContext);
        firstValveContext = valveContext;
    }

    @Override
    public synchronized void addLastValve(String name, IValve<Input, Output> valve) {
        ValveContext<Input, Output> valveContext = ValveContext.create(name, this, valve);
        nameValveContextMap.put(name, valveContext);
        if (lastValveContext == null) {
            firstValveContext = valveContext;
            lastValveContext = valveContext;
            return;
        }

        lastValveContext.setNext(valveContext);
        valveContext.setBefore(lastValveContext);
        lastValveContext = valveContext;
    }

    @Override
    public Output drawOff(Input input) {
        IValve<Input, Output> valve = firstValveContext.getValve();

        return valve.drawOff(firstValveContext, input);
    }


    @Override
    public <V> void setAttr(String key, V value) {

        attributesThreadLocal.get().put(key, value);
    }


    @Override
    public <V> V getAttr(String key) {

        return (V) attributesThreadLocal.get().get(key);
    }

    @Override
    public Collection<String> getAttrKeys() {

        return attributesThreadLocal.get().keySet();
    }

    @Override
    public Map<String, ?> getAttrs() {

        return attributesThreadLocal.get();
    }

    @Override
    public void removeAttr(String key) {

        attributesThreadLocal.get().remove(key);
    }

    @Override
    public void clearAttrs() {

        attributesThreadLocal.remove();
    }

}
