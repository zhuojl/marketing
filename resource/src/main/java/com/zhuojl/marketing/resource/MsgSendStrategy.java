package com.zhuojl.marketing.resource;

import com.zhuojl.marketing.common.User;
import com.zhuojl.marketing.resource.MsgSendStrategy.MsgResource;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 短信发送策略
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:17
 */
@Service
@Slf4j
public class MsgSendStrategy extends AbstractResourceSendStrategy<MsgResource> {


    @Override
    public boolean isSourceReady(MsgResource source) {
        log.info("pretend we searched");
        return true;
    }

    @Override
    public void sendResource(MsgResource source, List<User> list) {
        list.forEach(user -> log.info("user:{}, send msg:{}", user.getId(), source));
    }

    @Getter
    @Setter
    @ToString
    static class MsgResource extends com.zhuojl.marketing.resource.ResourceSendStrategy.Resource {

        private String content;
        private String anotherContent;
    }
}
