package io.github.zhdotm.ohzh.idempotent.core.getter;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;

/**
 * 键获取器
 *
 * @author zhihao.mao
 */

public interface IIdempotentKeyGetter {

    /**
     * 名称
     *
     * @return 名称
     */
    default String getName() {

        return StrUtil.lowerFirst(ClassUtil.getClassName(this, Boolean.TRUE));
    }

    /**
     * 键
     *
     * @param target            目标
     * @param method            方法
     * @param args              参数
     * @param keyExpressionText 键表达式文本
     * @return 键
     */
    String get(Object target, Method method, Object[] args, String keyExpressionText);

}
