package com.zhuojl.marketing.event.listener.order;

import com.zhuojl.marketing.event.EventContent;
import com.zhuojl.marketing.event.listener.AbstractEventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单事件抽象监听器 一个订单事件，可能被多个活动,多个业务监控，
 *
 * @author junliang.zhuo
 * @date 2019-04-22 15:26
 */
@Slf4j
public abstract class AbstractOrderEventListener extends AbstractEventListener<OrderEventContext> {

    @Override
    public void listen(EventContent eventContent) {
        // FIXME 这里泛型丢了
        OrderEventContext orderEventContext = (OrderEventContext) eventContent;
        // 验证等
        verify(orderEventContext);
        // 实际处理
        handle(orderEventContext);
    }

    protected abstract void handle(OrderEventContext orderEventContext);


    private void verify(OrderEventContext orderEventContext) {
        log.info("假装参数验证:{}", orderEventContext);
    }

}
