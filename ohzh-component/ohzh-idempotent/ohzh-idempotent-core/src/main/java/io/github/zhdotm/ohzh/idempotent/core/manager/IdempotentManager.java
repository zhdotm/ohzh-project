package io.github.zhdotm.ohzh.idempotent.core.manager;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.idempotent.core.annotation.Idempotent;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentInfo;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentPoint;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 幂等管理器
 *
 * @author zhihao.mao
 */

public class IdempotentManager {

    private static final Map<String, IIdempotentHandler> NAME_HANDLER_MAP = MapUtil.newConcurrentHashMap();
    private static final Map<String, IIdempotentKeyGetter> NAME_KEY_GETTER_MAP = MapUtil.newConcurrentHashMap();

    public static void putHandler(IIdempotentHandler handler) {
        if (ObjectUtil.isEmpty(handler)) {

            return;
        }

        NAME_HANDLER_MAP.put(handler.getName(), handler);
    }

    public static IIdempotentHandler getHandler(String handlerName) {

        return NAME_HANDLER_MAP.get(handlerName);
    }

    public static void removeHandler(String handlerName) {

        NAME_HANDLER_MAP.remove(handlerName);
    }

    public static void removeHandler(IIdempotentHandler handler) {
        if (ObjectUtil.isEmpty(handler)) {

            return;
        }

        removeHandler(handler.getName());
    }

    public static void putKeyGetter(IIdempotentKeyGetter keyGetter) {
        if (ObjectUtil.isEmpty(keyGetter)) {

            return;
        }

        NAME_KEY_GETTER_MAP.put(keyGetter.getName(), keyGetter);
    }

    public static IIdempotentKeyGetter getKeyGetter(String keyGetterName) {

        return NAME_KEY_GETTER_MAP.get(keyGetterName);
    }

    public static void removeKeyGetter(String keyGetterName) {

        NAME_KEY_GETTER_MAP.remove(keyGetterName);
    }

    public static void removeKeyGetter(IIdempotentKeyGetter keyGetter) {
        if (ObjectUtil.isEmpty(keyGetter)) {

            return;
        }

        removeKeyGetter(keyGetter.getName());
    }

    public static IdempotentInfo createIdempotentInfo(Idempotent idempotent, Object target, Method method, Object[] args) {
        String keyGetterName = idempotent.keyGetterName();
        IIdempotentKeyGetter iIdempotentKeyGetter = NAME_KEY_GETTER_MAP.get(keyGetterName);
        String handlerName = idempotent.handlerName();
        IIdempotentHandler iIdempotentHandler = NAME_HANDLER_MAP.get(handlerName);
        IdempotentPoint idempotentPoint = IdempotentPoint.create(idempotent.bizId(),
                target,
                method,
                args,
                idempotent.keyExpressionText(),
                iIdempotentKeyGetter,
                idempotent.lockTimeoutMilli());

        return IdempotentInfo.create(idempotentPoint, iIdempotentHandler);
    }

}
