package com.zhuojl.marketing.event.listener.order;

import com.zhuojl.marketing.event.EventContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author junliang.zhuo
 * @date 2019-04-22 15:26
 */
@Setter
@Getter
@NoArgsConstructor
public class OrderEventContext extends EventContent {

    private String orderNo;
    private Long amount;
    private Long price;

}

