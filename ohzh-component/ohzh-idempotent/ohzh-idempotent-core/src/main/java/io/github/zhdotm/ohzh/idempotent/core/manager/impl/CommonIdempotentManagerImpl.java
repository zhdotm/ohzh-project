package io.github.zhdotm.ohzh.idempotent.core.manager.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.manager.IIdempotentManager;

import java.util.Map;

/**
 * 幂等管理器
 *
 * @author zhihao.mao
 */

public class CommonIdempotentManagerImpl implements IIdempotentManager {

    private static final Map<String, IIdempotentHandler> NAME_HANDLER_MAP = MapUtil.newConcurrentHashMap();
    private static final Map<String, IIdempotentKeyGetter> NAME_KEY_GETTER_MAP = MapUtil.newConcurrentHashMap();

    private static volatile IIdempotentManager idempotentManager;

    private CommonIdempotentManagerImpl() {
    }

    public synchronized static IIdempotentManager getManager() {
        if (ObjectUtil.isEmpty(idempotentManager)) {
            idempotentManager = new CommonIdempotentManagerImpl();
        }

        return idempotentManager;
    }

    @Override
    public synchronized void putHandler(IIdempotentHandler handler) {
        if (ObjectUtil.isEmpty(handler)) {

            return;
        }

        NAME_HANDLER_MAP.put(handler.getName(), handler);
    }

    @Override
    public IIdempotentHandler getHandler(String handlerName) {

        return NAME_HANDLER_MAP.get(handlerName);
    }

    @Override
    public synchronized void removeHandler(String handlerName) {

        NAME_HANDLER_MAP.remove(handlerName);
    }

    @Override
    public synchronized void putKeyGetter(IIdempotentKeyGetter keyGetter) {
        if (ObjectUtil.isEmpty(keyGetter)) {

            return;
        }

        NAME_KEY_GETTER_MAP.put(keyGetter.getName(), keyGetter);
    }

    @Override
    public IIdempotentKeyGetter getKeyGetter(String keyGetterName) {

        return NAME_KEY_GETTER_MAP.get(keyGetterName);
    }

    @Override
    public synchronized void removeKeyGetter(String keyGetterName) {

        NAME_KEY_GETTER_MAP.remove(keyGetterName);
    }

}
