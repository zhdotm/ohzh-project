package io.github.zhdotm.ohzh.idempotent.core.model;

import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 幂等信息
 *
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IdempotentInfo {

    /**
     * 幂等点
     */
    private IdempotentPoint idempotentPoint;

    /**
     * 幂等处理器
     */
    private IIdempotentHandler idempotentHandler;


    public static IdempotentInfo create(IdempotentPoint idempotentPoint,
                                        IIdempotentHandler idempotentHandler) {
        IdempotentInfo idempotentInfo = new IdempotentInfo();

        return idempotentInfo
                .setIdempotentPoint(idempotentPoint)
                .setIdempotentHandler(idempotentHandler);
    }

}
