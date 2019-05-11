package com.zhuojl.marketing.resource;

import com.zhuojl.marketing.resource.ResourceSendStrategy.Resource;
import java.util.EnumMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 资源发送者工厂
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
@Component
public class ResourceSendStrategyFactory {

    private EnumMap<ResourceType, ResourceSendStrategy> sendStrategyMap;

    @Autowired
    public ResourceSendStrategyFactory(List<ResourceSendStrategy> userFindStrategies) {
        this.sendStrategyMap = new EnumMap<>(ResourceType.class);
        if (null != userFindStrategies) {
            userFindStrategies.forEach(item -> this.sendStrategyMap.put(item.getResourceType(), item));
        }
    }

    public ResourceSendStrategy getStrategy(ResourceType type) {
        return sendStrategyMap.getOrDefault(type, new NullSendStrategy());
    }

    class NullSendStrategy extends AbstractResourceSendStrategy<Resource> {

        @Override
        public boolean isSourceReady(Resource source) {
            return false;
        }

        @Override
        public void sendResource(Resource source, List list) {
            // None
        }
    }

}
