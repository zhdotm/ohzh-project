package io.github.zhdotm.ohzh.interceptor;

import java.math.BigDecimal;

/**
 * 业务逻辑
 *
 * @author zhihao.mao
 */

public class BizService implements IBizService {

    @Override
    public BigDecimal getNeedPaidAmount(BigDecimal originalAmount, BigDecimal preferentialAmount) {

        return originalAmount.subtract(preferentialAmount);
    }

}
