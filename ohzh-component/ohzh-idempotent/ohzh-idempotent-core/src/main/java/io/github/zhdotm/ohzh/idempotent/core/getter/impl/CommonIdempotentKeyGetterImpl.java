package io.github.zhdotm.ohzh.idempotent.core.getter.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.expression.ExpressionUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author zhihao.mao
 */

public class CommonIdempotentKeyGetterImpl implements IIdempotentKeyGetter {

    private static volatile IIdempotentKeyGetter keyGetter;

    private CommonIdempotentKeyGetterImpl() {
    }

    public synchronized static IIdempotentKeyGetter getKeyGetter() {
        if (ObjectUtil.isEmpty(keyGetter)) {

            keyGetter = new CommonIdempotentKeyGetterImpl();
        }

        return keyGetter;
    }

    @Override
    public String get(Object target, Method method, Object[] args, String keyExpressionText) {
        Map<String, Object> context = MapUtil.newHashMap();
        context.put("target", target);
        context.put("method", method);
        context.put("args", args);

        return StrUtil.toString(ExpressionUtil.eval(keyExpressionText, context));
    }

}
