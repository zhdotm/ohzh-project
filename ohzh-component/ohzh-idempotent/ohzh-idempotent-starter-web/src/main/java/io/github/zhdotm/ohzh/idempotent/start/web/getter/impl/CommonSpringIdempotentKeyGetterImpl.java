package io.github.zhdotm.ohzh.idempotent.start.web.getter.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.expression.ExpressionUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.start.web.getter.ISpringIdempotentKeyGetter;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author zhihao.mao
 */

public class CommonSpringIdempotentKeyGetterImpl implements ISpringIdempotentKeyGetter {

    private static final LocalVariableTableParameterNameDiscoverer DISCOVERER = new LocalVariableTableParameterNameDiscoverer();

    @Override
    public String getName() {

        return IIdempotentKeyGetter.COMMON_NAME;
    }

    @Override
    public String get(Object target, Method method, Object[] args, String keyExpressionText) {
        Map<String, Object> context = MapUtil.newHashMap();
        String[] parameterNames = DISCOVERER.getParameterNames(method);
        if (ArrayUtil.isNotEmpty(parameterNames)) {
            for (int i = 0; i < parameterNames.length; i++) {
                String parameterName = parameterNames[i];
                Object parameterValue = args[i];
                context.put(parameterName, parameterValue);
            }
        }

        return StrUtil.toString(ExpressionUtil.eval(keyExpressionText, context));
    }

}
