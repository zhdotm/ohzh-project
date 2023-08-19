package io.github.zhdotm.ohzh.idempotent.core.model;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;

/**
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IdempotentPoint {

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 目标
     */
    private Object target;

    /**
     * 方法
     */
    private Method method;

    /**
     * 参数
     */
    private Object[] args;

    /**
     * 键表达式文本
     */
    private String keyExpressionText;

    /**
     * 键获取器
     */
    private IIdempotentKeyGetter keyGetter;

    /**
     * 键
     */
    private String key;

    /**
     * 过期时间（秒）
     */
    private Long expire;

    public static IdempotentPoint create(String bizId,
                                         Object target,
                                         Method method,
                                         Object[] args,
                                         String keyExpressionText,
                                         IIdempotentKeyGetter keyGetter,
                                         Long expire) {
        IdempotentPoint idempotentPoint = new IdempotentPoint();

        return idempotentPoint
                .setBizId(bizId)
                .setTarget(target)
                .setMethod(method)
                .setArgs(args)
                .setKeyExpressionText(keyExpressionText)
                .setKeyGetter(keyGetter)
                .setExpire(expire);
    }

    /**
     * 获取键
     *
     * @return 键
     */
    public String getKey() {
        if (ObjectUtil.isEmpty(keyGetter)) {

            key = keyExpressionText;
        }
        if (StrUtil.isBlank(key)) {

            key = keyGetter.get(target, method, args, keyExpressionText);
        }

        return key;
    }

    public String getMethodName() {
        if (ObjectUtil.isEmpty(method)) {

            return null;
        }

        return method.getName();
    }

    public Class<?> getReturnType() {
        if (ObjectUtil.isEmpty(method)) {

            return null;
        }

        return method.getReturnType();
    }

}
