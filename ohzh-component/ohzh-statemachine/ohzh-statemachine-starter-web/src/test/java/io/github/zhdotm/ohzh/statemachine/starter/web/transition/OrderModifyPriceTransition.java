package io.github.zhdotm.ohzh.statemachine.starter.web.transition;

import io.github.zhdotm.ohzh.statemachine.core.constant.TransitionTypeEnum;
import io.github.zhdotm.ohzh.statemachine.starter.web.adapter.ITransitionAdapter;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineAction;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineTransition;
import io.github.zhdotm.ohzh.statemachine.starter.web.annotation.StateMachineCondition;

/**
 * 修改订单金额
 *
 * @author zhihao.mao
 */

@StateMachineTransition(
        stateMachineId = "RENT_ORDER",
        type = TransitionTypeEnum.INTERNAL,
        from = {"STATE_WAIT_PROMO", "STATE_WAIT_BALANCE", "STATE_WAIT_PAY"},
        on = "EVENT_MODIFY_PRICE"
)
public class OrderModifyPriceTransition implements ITransitionAdapter {

    @StateMachineCondition(conditionId = "IS_ABLE_MODIFY_PRICE")
    public Boolean check(String orderId, Long price) {
        System.out.println("检查能否修改订单金额");

        return Boolean.TRUE;
    }

    @StateMachineAction(actionId = "ACTION_MODIFY_PRICE")
    public String execute(String orderId, Long price) {
        System.out.println("执行修改订单金额动作");
        System.out.println("修改订单金额: 将" + orderId + "的订单金额修改为" + price);

        return "执行修改订单" + orderId + "金额为" + price + "结束";
    }

}
