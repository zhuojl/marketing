package com.zhuojl.marketing.event.listener.sign;

import com.zhuojl.marketing.event.EventContent;
import com.zhuojl.marketing.event.listener.AbstractEventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 签到事件监听器
 *
 * @author junliang.zhuo
 * @date 2019-04-22 15:26
 */
@Slf4j
public abstract class AbstractSignEventListener extends AbstractEventListener<SignEventContext> {

    @Override
    public void listen(EventContent eventContent) {

    }
}
