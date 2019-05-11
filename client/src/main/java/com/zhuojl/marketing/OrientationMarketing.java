package com.zhuojl.marketing;

import com.zhuojl.marketing.resource.ResourceSendStrategy;
import com.zhuojl.marketing.resource.ResourceSendStrategy.Resource;
import com.zhuojl.marketing.resource.ResourceSendStrategyFactory;
import com.zhuojl.marketing.resource.ResourceType;
import com.zhuojl.marketing.user.gather.Condition;
import com.zhuojl.marketing.user.gather.UserGatherStrategy;
import com.zhuojl.marketing.user.gather.UserGatherStrategyFactory;
import com.zhuojl.marketing.user.gather.UserGatherType;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

/**
 * 定向营销，根据条件查询用户，并触发某个奖励，或者动作
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:46
 */
@Component
public class OrientationMarketing {

    @Autowired
    private ResourceSendStrategyFactory strategyFactory;
    @Autowired
    private UserGatherStrategyFactory userGatherStrategyFactory;

    public void send(ResourceType resourceType, UserGatherType userGatherType, String userFindConfig, String sourceConfig) {
        // 用户查找策略
        UserGatherStrategy userGatherStrategy = userGatherStrategyFactory.getStrategy(userGatherType);
        Condition condition = userGatherStrategy.parseCondition(userFindConfig);
        // 资源发送策略
        ResourceSendStrategy resourceSendStrategy = strategyFactory.getStrategy(resourceType);
        Resource source = resourceSendStrategy.parseSource(sourceConfig);
        if (!userGatherStrategy.isDataReady(condition) || !resourceSendStrategy.isSourceReady(source)) {
            return;
        }
        // 主表更新为发送中，
        List<User> userList = null;
        Iterator<List<User>> iterator = userGatherStrategy.iterator(condition);
        while (iterator.hasNext()) {
            try {
                userList = iterator.next();
            } catch (Exception e) {
                userGatherStrategy.handleException(e);
            }
            try {
                resourceSendStrategy.sendResource(source, userList);
            } catch (Exception e) {
                resourceSendStrategy.handleException(e);
            }
        }
        // 时刻表更新为已发送
    }

}
