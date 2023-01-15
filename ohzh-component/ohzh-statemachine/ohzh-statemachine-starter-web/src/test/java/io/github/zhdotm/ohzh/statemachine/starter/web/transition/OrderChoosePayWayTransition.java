package io.github.zhdotm.ohzh.statemachine.starter.web.transition;

import io.github.zhdotm.ohzh.statemachine.core.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ITransitionAdapter;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineAction;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineCondition;

/**
 * 选择支付方式
 *
 * @author zhihao.mao
 */

@StateMachineTransition(
        stateMachineId = "RENT_ORDER",
        type = TransitionTypeEnum.INTERNAL,
        from = {"STATE_WAIT_PAY"},
        on = "EVENT_CHOOSE_PAY_WAY"
)
public class OrderChoosePayWayTransition implements ITransitionAdapter {

    @StateMachineCondition(conditionId = "IS_ABLE_CHOOSE_PAY_WAY")
    public Boolean check(String orderId, String payWay) {
        System.out.println("检查能否选择支付订单方式");

        return Boolean.TRUE;
    }

    @StateMachineAction(actionId = "ACTION_CHOOSE_PAY_WAY")
    public String execute(String orderId, String payWay) {
        System.out.println("执行选择订单" + orderId + "支付方式" + payWay + "动作");

        return "执行订单" + orderId + "选择支付方式" + payWay + "动作结束";
    }

}
