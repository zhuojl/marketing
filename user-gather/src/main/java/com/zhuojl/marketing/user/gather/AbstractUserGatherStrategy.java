package com.zhuojl.marketing.user.gather;

import com.alibaba.fastjson.JSONObject;
import com.zhuojl.marketing.common.TypeMissMatchException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.GenericTypeResolver;

/**
 * 查找策略抽象
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:58
 */
public abstract class AbstractUserGatherStrategy<T extends Condition> implements UserGatherStrategy<T>, InitializingBean {

    private Class<T> cls;

    @Override
    public UserGatherType getUserSourceType() {
        return UserGatherType.getTypeByCls(this.cls).orElseThrow(TypeMissMatchException::new);
    }

    @Override
    public void handleException(Exception e) {

    }

    @Override
    public T parseCondition(String config) {
        return JSONObject.parseObject(config, cls);
    }

    @Override
    public void afterPropertiesSet() {
        this.cls = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractUserGatherStrategy.class);
    }

}
