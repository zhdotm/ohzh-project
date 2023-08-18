package io.github.zhdotm.ohzh.idempotent.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
public class ReturnObj {

    private String bizId;

    private String idemKey;

    private byte[] returnObjBlob;
}