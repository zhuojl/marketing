package com.zhuojl.marketing.event.listener;

import com.zhuojl.marketing.event.EventContent;
import com.zhuojl.marketing.event.EventListener;
import com.zhuojl.marketing.event.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.GenericTypeResolver;

/**
 * 抽象事件监听器
 *
 * @author junliang.zhuo
 * @date 2019-04-12 16:30
 */
@Slf4j
public abstract class AbstractEventListener<T extends EventContent> implements EventListener, InitializingBean {

    private EventType eventType;

    @Override
    public EventType listenedEventType() {
        return this.eventType;
    }

    @Override
    public void afterPropertiesSet() {
        Class<T> cls= (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractEventListener.class);
        this.eventType = EventType.getByCls(cls);
    }


}
