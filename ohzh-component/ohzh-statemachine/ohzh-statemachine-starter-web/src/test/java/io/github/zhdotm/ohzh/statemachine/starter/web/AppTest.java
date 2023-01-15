package io.github.zhdotm.ohzh.statemachine.starter.web;


import io.github.zhdotm.ohzh.statemachine.starter.web.support.StateMachineSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Test
    public void fireEvent() {
        StateMachineSupport.fireEvent("RENT_ORDER", "STATE_WAIT_BALANCE", "EVENT_CLOSE", "订单:000011111");
    }

    @Test
    public void print() {
        StateMachineSupport
                .getStateMachine("RENT_ORDER")
                .print();
    }
}
