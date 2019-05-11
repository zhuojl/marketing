package com.zhuojl.marketing.resource;

import com.zhuojl.marketing.common.User;
import com.zhuojl.marketing.resource.PushSendStrategy.PushResource;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * push发送策略
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
@Service
@Slf4j
public class PushSendStrategy extends AbstractResourceSendStrategy<PushResource> {


    @Override
    public boolean isSourceReady(PushResource source) {
        return false;
    }

    @Override
    public void sendResource(PushResource source, List<User> list) {
        list.stream().forEach(user -> log.info("user:{}, send push:{}", user.getId(), source));
    }

    @Setter
    @Getter
    @ToString
    static class PushResource extends com.zhuojl.marketing.resource.ResourceSendStrategy.Resource {

        private String content;
        private String jumpUrl;
        private String button;
    }

}
