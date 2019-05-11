package com.zhuojl.marketing.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 事件上下文
 *
 * @author junliang.zhuo
 * @date 2019-04-22 15:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventContent {

    private Long userId;

    private EventType eventType;
}
