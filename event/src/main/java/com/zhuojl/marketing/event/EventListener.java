package com.zhuojl.marketing.event;

/**
 * 事件监听器
 * FIXME 需要考虑 遇到错误是否需要中断，中断后需不需要重试，充实就要考虑幂等，还有事务问题等。
 * 如果异步首先考虑mq吧。事件监听本来就是mq的逻辑了。
 * @author junliang.zhuo
 * @date 2019-04-22 15:26
 */
public interface EventListener<T extends EventContent> {

    /**
     * 监听的事件类型
     */
    EventType listenedEventType();

    /**
     * 监听
     */
    void listen(T eventContent);

}
