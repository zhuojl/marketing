package com.zhuojl.marketing;

import com.zhuojl.marketing.event.EventListenerContainer;
import com.zhuojl.marketing.event.EventType;
import com.zhuojl.marketing.event.listener.order.OrderEventContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author junliang.zhuo
 * @date 2019-05-11 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventListenerContainerTest {

    @Autowired
    private EventListenerContainer eventListenerContainer;

    @Test
    public void listen() {
        OrderEventContext orderEventContext = new OrderEventContext();
        orderEventContext.setEventType(EventType.ORDER);
        orderEventContext.setUserId(1L);
        orderEventContext.setAmount(100L);
        orderEventContext.setOrderNo("orderNo");
        orderEventContext.setPrice(99L);
        eventListenerContainer.listen(orderEventContext);

    }
}