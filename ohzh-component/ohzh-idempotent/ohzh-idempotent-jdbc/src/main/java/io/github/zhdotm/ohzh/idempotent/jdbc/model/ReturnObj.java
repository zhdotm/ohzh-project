package io.github.zhdotm.ohzh.idempotent.jdbc.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Blob;
import java.sql.ResultSet;

/**
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ReturnObj {

    private String bizId;

    private String idemKey;

    private byte[] returnObjBlob;

    @SneakyThrows
    public static ReturnObj create(ResultSet resultSet) {
        ReturnObj returnObj = new ReturnObj();
        String bizId = resultSet.getString(column.BIZ_ID.columnName);
        returnObj.setBizId(bizId);
        String idemKey = resultSet.getString(column.IDEM_KEY.columnName);
        returnObj.setIdemKey(idemKey);
        Blob returnObjBlob = resultSet.getBlob(column.RETURN_OBJ_BLOB.columnName);
        returnObj.setReturnObjBlob(returnObjBlob);

        return returnObj;
    }

    public void setReturnObjBlob(byte[] returnObjBlob) {
        this.returnObjBlob = returnObjBlob;
    }

    @SneakyThrows
    public void setReturnObjBlob(Blob returnObjBlob) {

        this.returnObjBlob = returnObjBlob.getBytes(1, (int) returnObjBlob.length());
    }

    @Getter
    @AllArgsConstructor
    public static enum column {
        /**
         * 字段
         */
        BIZ_ID("bizId", "biz_id"),
        IDEM_KEY("idemKey", "idem_key"),
        RETURN_OBJ_BLOB("returnObjBlob", "return_obj_blob");

        private final String javaName;
        private final String columnName;
    }

}
