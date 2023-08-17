package io.github.zhdotm.ohzh.idempotent.jdbc.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @author zhihao.mao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JdbcIdempotentProperties {

    /**
     * 插入一条幂等点信息
     */
    private String insertSql = "insert into idempotent set biz_id = ?, idem_key = ?, method_name = ?";

    /**
     * 更新幂等点执行结果
     */
    private String updateSql = "update idempotent set return_obj_blob = ?, is_done = 1 where biz_id = ? and idem_key = ? and is_deleted = 0";

    /**
     * 查询幂等点执行结果
     */
    private String selectSql = "select biz_id, idem_key, return_obj_blob from idempotent where biz_id = ? and idem_key = ? and is_done = 1 and is_deleted = 0";

    /**
     * 删除幂等点
     */
    private String deleteSql = "update idempotent set is_deleted = id where biz_id =  ? AND idem_key = ? and is_deleted = 0";

}
