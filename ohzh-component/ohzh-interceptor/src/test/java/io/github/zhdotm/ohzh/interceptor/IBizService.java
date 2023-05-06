package io.github.zhdotm.ohzh.interceptor;

import java.math.BigDecimal;

/**
 * 业务逻辑
 *
 * @author zhihao.mao
 */

public interface IBizService {

    BigDecimal getNeedPaidAmount(BigDecimal originalAmount, BigDecimal preferentialAmount);

}
