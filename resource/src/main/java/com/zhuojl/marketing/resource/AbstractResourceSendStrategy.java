package com.zhuojl.marketing.resource;

import com.alibaba.fastjson.JSONObject;
import com.zhuojl.marketing.common.TypeMissMatchException;
import com.zhuojl.marketing.resource.ResourceSendStrategy.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.GenericTypeResolver;

/**
 * 抽象资源发送者
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
@Slf4j
public abstract class AbstractResourceSendStrategy<T extends Resource> implements ResourceSendStrategy<T>, InitializingBean {

    private Class<T> cls;

    @Override
    public ResourceType getResourceType() {
        return ResourceType.getTypeByCls(this.cls).orElseThrow(TypeMissMatchException::new);
    }

    @Override
    public T parseSource(String config) {
        return JSONObject.parseObject(config, cls);
    }

    @Override
    public void handleException(Exception e) {
        log.info("tobe continue");
    }

    @Override
    public void afterPropertiesSet() {
        this.cls = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractResourceSendStrategy.class);
    }
}
