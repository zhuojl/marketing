package com.zhuojl.marketing.event.listener.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 订单事件的 其他 监听器
 * @see     OrderEventPointListener
 * @author junliang.zhuo
 * @date 2019-05-11 15:01
 */
@Service
@Slf4j
public class OrderEventOtherListener extends AbstractOrderEventListener{

    @Override
    protected void handle(OrderEventContext orderEventContext) {
        log.info("假装handle：{}", orderEventContext);
    }
}
