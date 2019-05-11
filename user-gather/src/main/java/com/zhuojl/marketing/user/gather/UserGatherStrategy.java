package com.zhuojl.marketing.user.gather;

import com.zhuojl.marketing.common.User;
import java.util.Iterator;
import java.util.List;

/**
 * 用户 采集 策略
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
public interface UserGatherStrategy<T extends Condition> {

    /**
     * 获取用户查找策略所查找的类型
     */
    UserGatherType getUserSourceType();

    /**
     * 数据是否就绪
     */
    boolean isDataReady(T condition);

    /**
     * 用户查找迭代器
     */
    Iterator<List<User>> iterator(T condition);

    /**
     * 解析条件配置
     */
    T parseCondition(String config);

    /**
     * 当用户查询遇到异常时，如何处理
     */
    void handleException(Exception e);

}
