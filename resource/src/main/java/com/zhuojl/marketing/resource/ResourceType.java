package com.zhuojl.marketing.resource;

import com.zhuojl.marketing.resource.MsgSendStrategy.MsgResource;
import com.zhuojl.marketing.resource.PushSendStrategy.PushResource;
import com.zhuojl.marketing.resource.ResourceSendStrategy.Resource;
import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 资源类型
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:16
 */
@Getter
@AllArgsConstructor
public enum ResourceType {

    /**
     * 短信
     */
    MSG(1 << 1, MsgResource.class),
    /**
     * push
     */
    PUSH(1 << 2, PushResource.class);

    /**
     * 类型
     */
    Integer type;
    /**
     * 处理类
     */
    Class<? extends Resource> cls;

    public static Optional<ResourceType> getTypeByCls(Class cls) {
        return Arrays.stream(values()).filter(e -> e.getCls().equals(cls)).findAny();
    }

}
