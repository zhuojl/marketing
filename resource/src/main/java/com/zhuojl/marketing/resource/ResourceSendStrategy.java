package com.zhuojl.marketing.resource;

import com.zhuojl.marketing.common.User;
import com.zhuojl.marketing.resource.ResourceSendStrategy.Resource;
import java.util.List;

/**
 * 资源发送策略
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
public interface ResourceSendStrategy<T extends Resource> {

    /**
     * 返回资源类型
     */
    ResourceType getResourceType();

    /**
     * 解析资源
     */
    T parseSource(String config);

    /**
     * 资源是否就绪
     */
    boolean isSourceReady(T source);

    /**
     * 发送遇到异常时，如何处理
     */
    void handleException(Exception e);

    /**
     * 发送资源
     */
    void sendResource(T source, List<User> userList);

    class Resource {

    }

}
