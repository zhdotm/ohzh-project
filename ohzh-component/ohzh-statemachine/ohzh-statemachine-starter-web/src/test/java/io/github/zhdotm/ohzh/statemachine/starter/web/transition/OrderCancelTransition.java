package io.github.zhdotm.ohzh.statemachine.starter.web.transition;

import io.github.zhdotm.ohzh.statemachine.core.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ITransitionAdapter;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineAction;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineCondition;

/**
 * 取消
 *
 * @author zhihao.mao
 */

@StateMachineTransition(stateMachineId = "RENT_ORDER",
        type = TransitionTypeEnum.EXTERNAL,
        from = {"STATE_WAIT_INIT", "STATE_WAIT_PROMO", "STATE_WAIT_BALANCE", "STATE_WAIT_PAY"},
        on = "EVENT_CANCEL",
        to = "STATE_CANCELED")
public class OrderCancelTransition implements ITransitionAdapter {

    @StateMachineCondition(conditionId = "IS_ABLE_CANCEL")
    public Boolean check(String orderId) {
        System.out.println("检查能否取消订单");

        return Boolean.TRUE;
    }

    @StateMachineAction(actionId = "ACTION_CANCEL")
    public String execute(String orderId) {
        System.out.println("执行取消订单动作");
        System.out.println("取消订单: " + orderId);

        return "取消订单" + orderId + "执行结束";
    }

}
