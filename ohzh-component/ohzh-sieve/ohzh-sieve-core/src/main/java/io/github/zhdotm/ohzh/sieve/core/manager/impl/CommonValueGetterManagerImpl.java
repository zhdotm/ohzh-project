package io.github.zhdotm.ohzh.sieve.core.manager.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetter;
import io.github.zhdotm.ohzh.sieve.core.manager.IValueGetterManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhihao.mao
 */

public class CommonValueGetterManagerImpl implements IValueGetterManager {

    private static final Map<String, IValueGetter> VALUE_GETTER_MAP = new HashMap<>();

    private static CommonValueGetterManagerImpl commonValueGetterManager;

    public synchronized static IValueGetterManager getValueGetterManager() {
        commonValueGetterManager = Optional.ofNullable(commonValueGetterManager)
                .orElse(new CommonValueGetterManagerImpl());

        return commonValueGetterManager;
    }

    private CommonValueGetterManagerImpl() {

    }

    @Override
    public void putValueGetter(IValueGetter valueGetter) {
        if (ObjectUtil.isEmpty(valueGetter)) {

            return;
        }

        VALUE_GETTER_MAP.put(valueGetter.getName(), valueGetter);
    }

    @Override
    public IValueGetter getValueGetter(String valueGetterName) {

        return VALUE_GETTER_MAP.get(valueGetterName);
    }

    @Override
    public void removeValueGetter(String valueGetterName) {
        if (StrUtil.isEmpty(valueGetterName)) {
            return;
        }

        VALUE_GETTER_MAP.remove(valueGetterName);
    }

    @Override
    public void removeValueGetter(IValueGetter valueGetter) {
        if (ObjectUtil.isEmpty(valueGetter)) {

            return;
        }
        
        removeValueGetter(valueGetter.getName());
    }

}
