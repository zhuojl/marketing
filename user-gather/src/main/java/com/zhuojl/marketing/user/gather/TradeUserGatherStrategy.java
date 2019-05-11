package com.zhuojl.marketing.user.gather;

import com.google.common.collect.Lists;
import com.zhuojl.marketing.common.User;
import com.zhuojl.marketing.user.gather.TradeUserGatherStrategy.TradeCondition;
import java.util.Iterator;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 根据订单次数查询司机
 *
 * @author junliang.zhuo
 * @date 2019-03-22 17:58
 */
@Service
@Slf4j
public class TradeUserGatherStrategy extends AbstractUserGatherStrategy<TradeCondition> {

    @Override
    public boolean isDataReady(TradeCondition condition) {
        return true;
    }

    @Override
    public Iterator<List<User>> iterator(TradeCondition condition) {
        return new TradeIterator(condition);
    }

    @Setter
    @Getter
    @ToString
    static class TradeCondition implements Condition {

        private Integer orderCount;
        private Long customerPrice;
    }

    @Data
    class TradeIterator implements Iterator<List<User>> {

        TradeCondition condition;
        private Integer pageSize;
        private Integer pn;


        private TradeIterator(TradeCondition condition) {
            this.condition = condition;
            this.pn = 1;
        }

        @Override
        public boolean hasNext() {
            // for test 最多只查2页
            return pn < 3;
        }

        @Override
        public List<User> next() {
            if (!hasNext()) {
                throw new UnsupportedOperationException();
            }
            pn++;
            List<User> userList = Lists.newArrayList();
            for (int i = 0; i < pn; i++) {
                userList.add(new User(pn * 100 + i));
            }
            log.info("find userList:{} pn:{}, condition:{}", userList, pn, condition);
            return userList;
        }
    }

}
