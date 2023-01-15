package io.github.zhdotm.ohzh.statemachine.starter.web.transition;

import io.github.zhdotm.ohzh.statemachine.core.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ITransitionAdapter;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineAction;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineCondition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;

/**
 * 记账
 *
 * @author zhihao.mao
 */

@StateMachineTransition(
        stateMachineId = "RENT_ORDER",
        type = TransitionTypeEnum.EXTERNAL,
        from = {"STATE_WAIT_BOOKING"},
        on = "EVENT_BOOKING",
        to = "STATE_FINISHED"
)
public class OrderBookingTransition implements ITransitionAdapter {

    @StateMachineCondition(conditionId = "IS_ABLE_BOOKING")
    public Boolean check(String orderId) {
        System.out.println("检查能否记账订单");

        return Boolean.TRUE;
    }

    @StateMachineAction(actionId = "ACTION_BOOKING")
    public String execute(String orderId) {
        System.out.println("执行订单记账动作");
        System.out.println("订单" + orderId + "执行订单记账动作");

        return "执行结算订单" + orderId + "结束";
    }

}
