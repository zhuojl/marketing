package com.zhuojl.marketing.event.listener.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 订单事件的积分监听器 这里就是积分的逻辑了，一个订单该按什么规则奖励多少积分？
 *
 * @author junliang.zhuo
 * @date 2019-05-11 15:01
 */
@Service
@Slf4j
public class OrderEventPointListener extends AbstractOrderEventListener {

    @Override
    protected void handle(OrderEventContext orderEventContext) {
        // 获取积分奖励配置
        Object rule = new Object();
        log.info("根据规则奖励, userId:{}, rule:{}, context:{}", orderEventContext.getUserId(), rule, orderEventContext);
    }
}
