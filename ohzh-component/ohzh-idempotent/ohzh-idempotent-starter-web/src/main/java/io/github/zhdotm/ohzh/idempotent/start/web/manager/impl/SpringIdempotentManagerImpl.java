package io.github.zhdotm.ohzh.idempotent.start.web.manager.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.manager.IIdempotentManager;
import io.github.zhdotm.ohzh.idempotent.core.manager.impl.CommonIdempotentManagerImpl;
import io.github.zhdotm.ohzh.idempotent.start.web.getter.ISpringIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.start.web.handler.ISpringIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.start.web.manager.ISpringIdempotentManager;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Map;

/**
 * @author zhihao.mao
 */

public class SpringIdempotentManagerImpl implements ISpringIdempotentManager, ApplicationRunner {

    private IIdempotentManager innerIdempotentManager;

    @Override
    public synchronized void putHandler(ISpringIdempotentHandler handler) {
        SpringUtil.registerBean(handler.getName(), handler);
        innerIdempotentManager.putHandler(handler);
    }

    @Override
    public IIdempotentHandler getHandler(String handlerName) {
        IIdempotentHandler handler = innerIdempotentManager.getHandler(handlerName);
        if (ObjectUtil.isEmpty(handler)) {
            synchronized (this) {
                handler = innerIdempotentManager.getHandler(handlerName);
                if (ObjectUtil.isNotEmpty(handler)) {

                    return handler;
                }
                handler = SpringUtil.getBean(handlerName, ISpringIdempotentHandler.class);
                if (ObjectUtil.isNotEmpty(handler)) {
                    innerIdempotentManager.putHandler(handler);
                }
            }
        }

        return handler;
    }

    @Override
    public synchronized void removeHandler(String handlerName) {
        innerIdempotentManager.removeHandler(handlerName);
        SpringUtil.unregisterBean(handlerName);
    }

    @Override
    public synchronized void putKeyGetter(ISpringIdempotentKeyGetter keyGetter) {
        SpringUtil.registerBean(keyGetter.getName(), keyGetter);
        innerIdempotentManager.putKeyGetter(keyGetter);
    }

    @Override
    public IIdempotentKeyGetter getKeyGetter(String keyGetterName) {
        IIdempotentKeyGetter keyGetter = innerIdempotentManager.getKeyGetter(keyGetterName);
        if (ObjectUtil.isEmpty(keyGetter)) {
            synchronized (this) {
                keyGetter = innerIdempotentManager.getKeyGetter(keyGetterName);
                if (ObjectUtil.isNotEmpty(keyGetter)) {

                    return keyGetter;
                }
                keyGetter = SpringUtil.getBean(keyGetterName, ISpringIdempotentKeyGetter.class);
                if (ObjectUtil.isNotEmpty(keyGetter)) {
                    innerIdempotentManager.putKeyGetter(keyGetter);
                }
            }
        }

        return keyGetter;
    }

    @Override
    public synchronized void removeKeyGetter(String keyGetterName) {
        innerIdempotentManager.removeKeyGetter(keyGetterName);
        SpringUtil.unregisterBean(keyGetterName);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        innerIdempotentManager = CommonIdempotentManagerImpl.getManager();

        Map<String, IIdempotentKeyGetter> idempotentKeyGetterMap = SpringUtil.getBeansOfType(IIdempotentKeyGetter.class);
        if (CollectionUtil.isNotEmpty(idempotentKeyGetterMap)) {
            idempotentKeyGetterMap.values().forEach(innerIdempotentManager::putKeyGetter);
        }

        Map<String, IIdempotentHandler> idempotentHandlerMap = SpringUtil.getBeansOfType(IIdempotentHandler.class);
        if (CollectionUtil.isNotEmpty(idempotentHandlerMap)) {
            idempotentHandlerMap.values().forEach(innerIdempotentManager::putHandler);
        }
    }

}
