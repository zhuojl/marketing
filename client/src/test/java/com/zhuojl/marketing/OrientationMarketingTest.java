package com.zhuojl.marketing;

import com.zhuojl.marketing.resource.ResourceType;
import com.zhuojl.marketing.user.gather.UserGatherType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO 类命名修改 定向营销工具单元测试。
 *
 * @author junliang.zhuo
 * @date 2019-04-13 23:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrientationMarketingTest {

    @Autowired
    private OrientationMarketing taskExecutor;

    @Test
    public void test() {
        String userGatherConfig = "{\"orderCount\":\"1\",\"customerPrice\":\"101\"}";
        String sourceConfig = "{\"content\":\"this is content\", \"anotherContent\":\"this is anotherContent\"}";
        taskExecutor.send(ResourceType.MSG, UserGatherType.TRADE, userGatherConfig, sourceConfig);
    }

}
