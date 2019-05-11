package com.zhuojl.marketing.event;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * 事件监听器容器
 *
 * @author junliang.zhuo
 * @date 2019-04-22 15:26
 */
@Component
@Slf4j
public class EventListenerContainer {

    private EnumMap<EventType, List<EventListener>> eventTypeListEnumMap = new EnumMap<>(EventType.class);

    @Autowired
    public EventListenerContainer(List<EventListener> listeners) {
        if (CollectionUtils.isEmpty(listeners)) {
            return;
        }
        listeners.forEach(item -> {
            List<EventListener> tempListenerList = eventTypeListEnumMap.computeIfAbsent(item.listenedEventType(), eventType -> new ArrayList<>());
            tempListenerList.add(item);
        });
    }


    public void listen(EventContent eventContent) {
        if (!eventTypeListEnumMap.containsKey(eventContent.getEventType())) {
            log.error("unkown eventType:{}", eventContent.getEventType());
            return;
        }
        eventTypeListEnumMap.get(eventContent.getEventType())
            .forEach(eventListener -> eventListener.listen(eventContent));
    }

}
