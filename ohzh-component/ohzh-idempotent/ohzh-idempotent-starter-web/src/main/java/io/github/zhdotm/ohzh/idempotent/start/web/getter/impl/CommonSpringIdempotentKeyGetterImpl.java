package io.github.zhdotm.ohzh.idempotent.start.web.getter.impl;

import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.getter.impl.CommonIdempotentKeyGetterImpl;
import io.github.zhdotm.ohzh.idempotent.start.web.getter.ISpringIdempotentKeyGetter;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author zhihao.mao
 */

public class CommonSpringIdempotentKeyGetterImpl implements ISpringIdempotentKeyGetter {

    private IIdempotentKeyGetter innerKeyGetter;

    @Override
    public String get(Object target, Method method, Object[] args, String keyExpressionText) {
        innerKeyGetter = Optional.ofNullable(innerKeyGetter)
                .orElse(CommonIdempotentKeyGetterImpl.getKeyGetter());

        return innerKeyGetter.get(target, method, args, keyExpressionText);
    }

}
