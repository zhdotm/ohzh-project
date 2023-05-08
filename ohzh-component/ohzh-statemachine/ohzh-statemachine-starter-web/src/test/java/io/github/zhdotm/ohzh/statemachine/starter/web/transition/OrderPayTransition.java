package io.github.zhdotm.ohzh.statemachine.starter.web.transition;

import io.github.zhdotm.ohzh.statemachine.core.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ISpringTransition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineAction;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineCondition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;

/**
 * 支付
 *
 * @author zhihao.mao
 */

@StateMachineTransition(
        stateMachineId = "RENT_ORDER",
        type = TransitionTypeEnum.EXTERNAL,
        from = {"STATE_WAIT_PAY"},
        on = "EVENT_PAY",
        to = "STATE_WAIT_BOOKING"
)
public class OrderPayTransition implements ISpringTransition {

    @StateMachineCondition(conditionId = "IS_ABLE_PAY")
    public Boolean check(String arg) {
        System.out.println(getCurrentState() + ": 检查能否关闭订单");

        return Boolean.TRUE;
    }

    @StateMachineAction(actionId = "ACTION_PAY")
    public String execute(String arg) {
        System.out.println(getCurrentState() + ": 执行关闭订单动作");

        return "执行结束";
    }

}
