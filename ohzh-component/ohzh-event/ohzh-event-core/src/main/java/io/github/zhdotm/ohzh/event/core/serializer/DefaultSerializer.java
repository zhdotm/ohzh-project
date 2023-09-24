package io.github.zhdotm.ohzh.event.core.serializer;

import cn.hutool.json.JSONUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author zhihao.mao
 */

public class DefaultSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {

        return JSONUtil.toJsonStr(obj).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {

        return JSONUtil.toBean(new String(bytes, StandardCharsets.UTF_8), clazz);
    }

}
