package io.github.zhdotm.ohzh.idempotent.core.getter.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.expression.ExpressionUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
        Parameter[] parameters = method.getParameters();
        if (ObjectUtil.isNotEmpty(parameters)) {
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                String parameterName = parameter.getName();
                Object parameterValue = args[i];
                context.put(parameterName, parameterValue);
            }
        }

        return StrUtil.toString(ExpressionUtil.eval(keyExpressionText, context));
    }

}
