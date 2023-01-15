package io.github.zhdotm.ohzh.cqrs.starter.web.query;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.core.query.IQuery;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GetAccountQuery implements IQuery {

    @Getter
    private Long userId;

    @Override
    public BizScenario getBizScenario() {

        return BizScenario.valueOf("userCenter", "account", "enterprise");
    }

}
