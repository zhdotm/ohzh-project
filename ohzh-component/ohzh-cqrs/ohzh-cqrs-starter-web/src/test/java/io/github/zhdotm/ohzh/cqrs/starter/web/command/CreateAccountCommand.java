package io.github.zhdotm.ohzh.cqrs.starter.web.command;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.core.command.ICommand;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CreateAccountCommand implements ICommand {

    private Long userId;
    private String userName;
    private String account;
    private String password;

    @Override
    public BizScenario getBizScenario() {

        return BizScenario.valueOf("userCenter", "account", "enterprise111");
    }

}
