package com.zhuojl.marketing.user.gather;

import com.google.common.collect.Lists;
import com.zhuojl.marketing.common.User;
import com.zhuojl.marketing.user.gather.NearbyUserGatherStrategy.NearbyCondition;
import java.util.Iterator;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 根据大数据标签查找司机
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:58
 */
@Service
@Slf4j
public class NearbyUserGatherStrategy extends AbstractUserGatherStrategy<NearbyCondition> {

    @Override
    public boolean isDataReady(NearbyCondition condition) {
        log.info("pretend we searched");
        return true;
    }

    @Override
    public Iterator<List<User>> iterator(NearbyCondition condition) {
        return new NearbyIterator(condition);
    }

    @Setter
    @Getter
    @ToString
    static class NearbyCondition implements Condition {

        private Integer distance;
        private List<String> addressList;
    }

    @Data
    class NearbyIterator implements Iterator<List<User>> {

        // for tests
        int index = 0;
        NearbyCondition nearbyCondition;

        private NearbyIterator(NearbyCondition nearbyCondition) {
            this.nearbyCondition = nearbyCondition;
        }

        @Override
        public boolean hasNext() {
            return index < nearbyCondition.getAddressList().size();
        }

        @Override
        public List<User> next() {
            if (!hasNext()) {
                throw new UnsupportedOperationException();
            }
            index++;
            List<User> userList = Lists.newArrayList();
            for (int i = 0; i < index; i++) {
                userList.add(new User(index * 10 + i));
            }
            log.info("find userList:{} in address:{}", userList, nearbyCondition.getAddressList());
            return userList;
        }
    }

}
