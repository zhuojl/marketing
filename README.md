# 写在前面
当前自己的工作是做营销后台系统，由于工作中的种种原因（排期，影响范围，重构风险等等），有些时候发现好的思路，想法，
并不能在工作中实施，所以索性不如自己做一个做个简陋的营销小系统，把工作中好的经验/教训（对，教训也是好的 = =）借鉴过来，
当然这里肯定不会出现公司相关的源码。

# 代码结构
- common 是公共模块，包括异常定义，用户POJO等。
- resource 是资源模块，包括短信，push（优惠券，积分，抽奖次数，话费，实物，现金 #未实现#）等。
- user-gather 是用户采集模块，根据条件采集赛选用户，包括交易属性查找，用户定位上报数据查找策略（用户标签查找，用户行为数据 #未实现#）等。
可以用于实现主动营销，定向触达
- filter 是条件过滤模块，动态判断条件是否满足。可以用各种广告，活动参与条件，奖励条件过滤等。
- event 是事件监听模块，当发生某个动作时，触发某类操作，当用户下单/签到/分享/其他时，触发一个动作（可以是一个或者多个奖励/通知/其他）
- activity 是活动模块，内部由各类小活动组成，根据以往经验，这里不宜做过多抽象，因为各类活动之间的差距往往比较大，模型和
统计需求也往往不同，可以走分别的逻辑。
- client 是客户端，模拟客户端调用。


# 业务结构
业务逻辑精简到client中了，目前的划分为以下几个模块
- 定向营销，
- 事件触达
- 广告
- 小活动，（优惠券，抽奖，积分，推荐，分享，抢购，拼团）（**未实现**）
- **数据统计与分析（未实现）** 营销的主要目的不是搞活动，而是为了特定目标，如何验证营销的效果十分重要，在之前的工作中，页面流量等数据，都是由公司大数据部门出的，业务上只用做少量统计，
需要注意的是：考虑统计需求，保留过程数据，以便大数据统计。
- 推荐算法（**未实现**）

## 定向营销
大致的需求是: 根据各种条件，赛选用户，发送对应的resource，适用于用户数据可以单个查询的情况，如果要进行复合查询，
比如说交易属性和用户属性混合来查询，暂时就不支持，一种思路就是做数据合并，将关心的各种属性维护到一个系统中，
避免大数据量下多系统之间求交集或者并集。

## 事件触达
大致需求是：当用户完成某项事件时，如果满足一定的触发条件，触发某类操作（略，同营销工具等）。
包括：事件类型，触发条件，resource

## 广告位（资源位）推荐
大致需求是：当用户进入某个页面时，可以看到某个广告，即 针对广告的 条件限制 赛选出用户能访问的广告。
核心就是过滤系统

# 写在后面
由于最近公司调整，去支付部门了，后面也没太多时间能投入到这里面，做个简单完结，标记了没有完成的地方有标记，后续有需要再补。

写这篇主要的一个目是：在接触到营销领域的时候，没有去了解这个领域，只顾着看技术，在做的时候只按照产品需求做，
没太考虑到扩展性，这样不但没做好产品，也没有什么积累，算是以后工作的一个警戒吧。


# 引用
- [我如何做运营活动](https://juejin.im/post/5b76e604e51d4538c2108657)


