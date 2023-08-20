package io.github.zhdotm.ohzh.example.idempotent.serializer;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import io.github.zhdotm.ohzh.idempotent.core.serializer.Serializer;

import java.nio.charset.StandardCharsets;

/**
 * @author zhihao.mao
 */

public class JsonSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) {
        if (ObjectUtil.isEmpty(obj)) {

            return null;
        }

        return JSONUtil.toJsonStr(obj).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        if (ObjectUtil.isEmpty(bytes)) {

            return null;
        }

        return JSONUtil.toBean(new String(bytes), clazz);
    }

}
