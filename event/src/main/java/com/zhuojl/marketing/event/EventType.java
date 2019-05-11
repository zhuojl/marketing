package com.zhuojl.marketing.event;

import com.zhuojl.marketing.common.MyRuntimeException;
import com.zhuojl.marketing.event.listener.order.OrderEventContext;
import com.zhuojl.marketing.event.listener.sign.SignEventContext;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 事件类型，
 *
 * @author junliang.zhuo
 * @date 2019-04-22 14:42
 */
@Getter
@AllArgsConstructor
public enum EventType {

    ORDER(OrderEventContext.class),
    SIGN(SignEventContext.class);

    /**
     * 事件上下文的类
     */
    private Class<? extends EventContent> cls;

    public static EventType getByCls(Class<? extends EventContent> cls) {
        return Arrays.stream(values()).filter(item -> item.getCls().equals(cls)).findAny().orElseThrow(MyRuntimeException::new);
    }

}
