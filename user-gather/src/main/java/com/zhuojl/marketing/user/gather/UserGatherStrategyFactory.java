package com.zhuojl.marketing.user.gather;

import com.zhuojl.marketing.common.User;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户 采集 工厂类
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
@Component
public class UserGatherStrategyFactory {

    private EnumMap<UserGatherType, UserGatherStrategy> strategyEnumMap;

    @Autowired
    public UserGatherStrategyFactory(List<UserGatherStrategy> userFindStrategies) {
        this.strategyEnumMap = new EnumMap<>(UserGatherType.class);
        if (null == userFindStrategies) {
            return;
        }
        userFindStrategies.forEach(item -> this.strategyEnumMap.put(item.getUserSourceType(), item));
    }

    public UserGatherStrategy getStrategy(UserGatherType userGatherType) {
        return strategyEnumMap.getOrDefault(userGatherType, new NullUserGatherStrategy());
    }

    class NullUserGatherStrategy extends AbstractUserGatherStrategy {

        @Override
        public boolean isDataReady(Condition condition) {
            return false;
        }

        @Override
        public Iterator<List<User>> iterator(Condition condition) {
            return null;
        }
    }

}
