package io.github.zhdotm.ohzh.sieve.starter.web.manager.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetter;
import io.github.zhdotm.ohzh.sieve.core.manager.IValueGetterManager;
import io.github.zhdotm.ohzh.sieve.core.manager.impl.CommonValueGetterManagerImpl;
import io.github.zhdotm.ohzh.sieve.starter.web.getter.ISpringValueGetter;
import io.github.zhdotm.ohzh.sieve.starter.web.manager.ISpringValueGetterManager;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Map;

/**
 * @author zhihao.mao
 */

public class SpringValueGetterManagerImpl implements ISpringValueGetterManager, ApplicationRunner {

    private IValueGetterManager valueGetterManager;

    @Override
    public void putValueGetter(IValueGetter valueGetter) {
        valueGetterManager.putValueGetter(valueGetter);
        SpringUtil.registerBean(valueGetter.getName(), valueGetter);
    }

    @Override
    public IValueGetter getValueGetter(String valueGetterName) {
        IValueGetter valueGetter = valueGetterManager.getValueGetter(valueGetterName);
        if (ObjectUtil.isEmpty(valueGetter)) {
            valueGetter = SpringUtil.getBean(valueGetterName, IValueGetter.class);
            if (ObjectUtil.isNotEmpty(valueGetter)) {
                valueGetterManager.putValueGetter(valueGetter);
            }
        }

        return valueGetter;
    }

    @Override
    public void removeValueGetter(String valueGetterName) {
        valueGetterManager.removeValueGetter(valueGetterName);
        SpringUtil.unregisterBean(valueGetterName);
    }

    @Override
    public void removeValueGetter(IValueGetter valueGetter) {
        removeValueGetter(valueGetter.getName());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, ISpringValueGetter> nameValueGetterMap = SpringUtil.getBeansOfType(ISpringValueGetter.class);
        if (CollectionUtil.isEmpty(nameValueGetterMap)) {

            return;
        }
        if (ObjectUtil.isEmpty(valueGetterManager)) {
            valueGetterManager = CommonValueGetterManagerImpl.getValueGetterManager();
        }
        nameValueGetterMap.values().forEach(valueGetterManager::putValueGetter);
    }
}
