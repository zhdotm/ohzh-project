package io.github.zhdotm.ohzh.statemachine.starter.web.transition;

import io.github.zhdotm.ohzh.statemachine.core.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ITransitionAdapter;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineAction;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineCondition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;

/**
 * 关闭订单
 *
 * @author zhihao.mao
 */

@StateMachineTransition(
        stateMachineId = "RENT_ORDER",
        type = TransitionTypeEnum.EXTERNAL,
        from = {"STATE_WAIT_INIT", "STATE_WAIT_PROMO", "STATE_WAIT_BALANCE", "STATE_WAIT_PAY"},
        on = "EVENT_CLOSE",
        to = "STATE_CLOSED"
)
public class OrderCloseTransition implements ITransitionAdapter {

    @StateMachineCondition(conditionId = "IS_ABLE_CLOSE")
    public Boolean check(String orderId) {
        System.out.println("检查能否关闭订单");

        return Boolean.TRUE;
    }

    @StateMachineAction(actionId = "ACTION_CLOSE")
    public String execute(String orderId) {
        System.out.println("执行关闭订单动作");
        System.out.println("关闭订单: " + orderId);

        return "关闭订单" + orderId + "执行结束";
    }

}
