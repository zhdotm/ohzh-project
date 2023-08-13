package io.github.zhdotm.ohzh.sieve.core.getter.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetter;
import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetterManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author zhihao.mao
 */

public class CommonValueGetterManagerImplTest {

    private IValueGetterManager valueGetterManager;

    @Before
    public void createCommonValueGetterManager() {
        valueGetterManager = CommonValueGetterManagerImpl.getValueGetterManager();
    }

    @Test
    public void putValueGetter() {
        valueGetterManager.putValueGetter(new IValueGetter() {
            @Override
            public String getName() {

                return "valueGetter_1";
            }

            @Override
            public Collection<String> get() {
                return ListUtil.of("1", "2", "3");
            }
        });

        valueGetterManager.putValueGetter(new IValueGetter() {
            @Override
            public String getName() {

                return "valueGetter_2";
            }

            @Override
            public Collection<String> get() {
                return ListUtil.of("a", "b", "c");
            }
        });

        valueGetterManager.putValueGetter(new IValueGetter() {
            @Override
            public String getName() {

                return "valueGetter_3";
            }

            @Override
            public Collection<String> get() {
                return ListUtil.of("x", "y", "z");
            }
        });
    }

    @Test
    public void getValueGetter() {
        putValueGetter();
        Assert.isTrue("[x, y, z]".equals(Arrays.toString(valueGetterManager.getValueGetter("valueGetter_3").get().toArray())));
    }

    @Test
    public void removeValueGetter() {
        putValueGetter();
        Assert.isTrue("[x, y, z]".equals(Arrays.toString(valueGetterManager.getValueGetter("valueGetter_3").get().toArray())));
        valueGetterManager.removeValueGetter("valueGetter_3");
        Assert.isTrue(ObjectUtil.isEmpty(valueGetterManager.getValueGetter("valueGetter_3")));
    }

}