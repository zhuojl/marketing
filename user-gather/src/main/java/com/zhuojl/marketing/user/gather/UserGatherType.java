package com.zhuojl.marketing.user.gather;

import com.zhuojl.marketing.user.gather.NearbyUserGatherStrategy.NearbyCondition;
import com.zhuojl.marketing.user.gather.TradeUserGatherStrategy.TradeCondition;
import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户数据 采集方式
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:18
 */
@Getter
@AllArgsConstructor
public enum UserGatherType {

    /**
     * 订单次数司机
     */
    TRADE(TradeCondition.class),
    /**
     * 大数据司机
     */
    NEARBY(NearbyCondition.class);

    /**
     * 查询条件类
     */
    private Class<? extends Condition> cls;

    public static Optional<UserGatherType> getTypeByCls(Class cls) {
        return Arrays.stream(values()).filter(e -> e.getCls() == cls).findAny();
    }
}
