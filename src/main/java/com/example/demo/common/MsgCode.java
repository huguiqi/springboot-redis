package com.example.demo.common;

/**
 * Created by sam on 2018/5/9.
 */
public enum MsgCode {
    SUCCESSFUL(100, "请求成功"),
    SYSTEM_ERROR(500, "系统繁忙，请稍后再试"),
    SYSTEM_ERROR_RECOMMENT_FAIL(501, "网络不好？请稍后再试"),
    USER_NOT_EXIST(401, "用户不存在"),
    LEVEL_NOT_SUPPORT(402, "铂涛客户端暂不支持公司卡/商务卡/合作卡预订，请登录官网预订"),
    LOGIN_REQURIED(403, "请先登录"),
    TREASURE_NOT_UNCLAIMED(404, "您没有可领取的法宝！"),
    TOKEN_IS_ERROR(405, "用户验证失败"),
    TOKEN_IS_VIRTUAL_ERROR(4055, "请关联手机"),//虚拟帐号，不能调用会员权益相关接口
    MOBILE_NOT_CERTIFY(406, "您的手机号码未通过验证！"),
    LOGIN_FAILED(407, "帐号或密码不正确"),
    UNSUPPORT_MEMBERTYPE(408, "不支持的用户类型"),
    VERIFICATIONCODE_ERROR(409, "请输入正确的验证码"),
    LOGIN_PASSWORD_WEAK(410, "密码不能小于6位且不能为纯数字"),
    LOGIN_FAILED_PASSWORD_ERROR_TOO_MANY(411, "对不起，密码错误次数过多，您的帐号将被冻结5分钟"),
    GIFT_77_VALID_ERROR(412, "已经领取过77礼包，无法领取77法宝！"),
    GIFT_77_ADD_ERROR(413, "添加77法宝出错！"),
    GIFT_77_CANNOT_ADD_ERROR(413, "不能添加77法宝！"),
    LOGIN_FAILED_SAME_DEVICEID_LOGIN_MORE(415, "请不要在一天之内登录多个帐户"),
    RESET_PWD_ERROR_MORE(416, "对不起，重置密码错误次数过多,请半小时后重试"),
    MSG_VERIFICATIONCODE_ERROR(417, "请输入正确的验证码"),
    GIFT_IU_ADD_ERROR(418, "添加IU酒店法宝出错！"),
    GIFT_IU_CANNOT_ADD_ERROR(419, "不能添加IU酒店法宝！"),
    SEND_VERIFICATION_CODE_ERROR_TOO_MANY(420, "对不起，短信动态密码登录功能在10分钟内只能使用5次！"),
    GIFT_128_CANNOT_ADD_ERROR(421, "不能添加128法宝！"),
    GIFT_128_ADD_ERROR(422, "添加128法宝出错！"),
    VERIFICATIONCODE_EMPTY_ERROR(423, "验证码获取失败，请重试！"),
    GIFT_168_ADD_ERROR(424, "添加168法宝出错！"),
    SMS_VERIFICATIONCODE_ERROR_TOO_MANY(425, "对不起，验证码错误次数过多，您的帐号或手机将被冻结5分钟，请稍后"),
    ROOMSTATUS_ERROR(426, "查询房态失败"),
    LOGIN_TOO_MANY(427, "请不要频繁登录"),
    COMMENT_TOO_MANY(428, "请勿重复评论"),
    LOGIN_TOO_MANY_ERROR(429, "操作错误频繁，请使用手机验证码方式进行登陆"),
    LOGIN_BEYOND_LIMIT(430,"账号密码输错过多，请使用验证码校验登录"),
    BAD_REQUEST(300, "请求参数有误"),
    UNSUPPORT_ACTIVITY(302, "抱歉，当前市场活动不存在或者已下线"),
    BAD_EXCHANGE_CODE(303, "券码不正确"),
    NO_MESSAGE(304, "找不到对应消息"),
    CAN_NOT_COMMENT(305, "该订单不可点评"),

    USE_COUPON_FAILED(601, "使用优惠券失败"),
    BAD_ORDER_ID(602, "无法找到该订单"),
    CANCEL_ORDER(603, "取消订单确认"),
    CANCEL_ORDER_FAIL(604, "取消订单失败"),
    ORDER_FULL_CODE(605, "您有3张未预付费的订单，请先预付费才可以继续下单"),
    ADD_BOOKING_FAIL(606, "提交订单失败"),
    NO_USEABLE_TREASURE(607, "抱歉，在当前分店您不可使用该法宝"),
    NO_SUCH_ORDER(608, "无效的订单号"),
    POINT_NOT_ENOUGH(609, "积分不足！"),
    ADD_BOOKING_CONFIRM(610, "订单已生成，请稍后查看下单结果"),
    ORDER_CAN_NOT_CANCEL(611, "该订单不能删除"),
    ORDER_INVALID(612, "该订单不存在"),
    ORDER_ID_INVALID(613, "请正确填写您本人的身份信息，如有疑问请联系客服处理。"),
    GRTSNFAIL(614, "获取交易码失败，请稍后再试"),
    NOCOUPON(615, "该优惠券不可用，请确认"),
    CANNOTUSEASSET(616, "你的资产信息暂不能使用，请咨询客服"),

    MEMBERRISK_VERIFICATION(650, "会员风控需验证"),

    PAY_FAIL_CODE(700, "支付失败"),
    PAY_AMOUNT_INVALID(701, "所有金额必须大于等于0"),
    PAY_MORE_THAN_ONE(702, "只能选择一种支付方式"),
    PAY_GIFT_MARKET_ID_INVALID(703, "支付的法宝的配额的id有误"),
    PAY_CANNOT_USE_CASHCOUPON_WITH_MARKET(704, "使用积分或法宝订房时不可使用返现券"),
    PAY_ORDER_TOTAL_AMOUNT(705, "订单总价不匹配"),
    PAY_ORDER_STATUS_NO_BOOKING(706, "订单状态不是预定状态"),
    PAY_ORDER_PAYMENT_STATUS(707, "订单已经支付或者已经退款"),
    PAY_ORDER_REV_TIME_INVALID(708, "已超过订单保留时效"),
    PAY_CASH_COUPON_USED_AT_BOOKING(709, "已经使用过返现券，不能使用抵用券"),
    PAY_CASH_COUPON_MORE_THAN_ONE_ROOM(710, "预订多间房不可使用返现券"),
    PAY_CASH_COUPON_COUNT_GT_ROOMDAYS(711, "每房晚最多使用1张"),
    PAY_CASH_COUPON_DUPLICATE(712, "复制添加返现券出现错误"),
    PAY_CASH_COUPON_UNUSABLE(713, "返现券无法使用"),
    PAY_CASH_COUPON_NOT_EXIST_OR_UNUSABLE(714, "返现券不存在或者因为某些原因无法使用"),
    PAY_CASH_COUPON_AMOUNT(715, "返现券金额不正确"),
    PAY_CASH_COUPON_SIZE(716, "返现券数量异常"),
    PAY_VOUCHER_COUNT_GT_ROOMDAYS(717, "抵用券使用数量异常"),
    PAY_VOUCHER_DUPLICATE(718, "复制添加抵用券出现错误"),
    PAY_VOUCHER_UNUSABLE(719, "抵用券无法使用"),
    PAY_VOUCHER_AMOUNTE(720, "抵用券金额不正确"),
    PAY_VOUCHER_NOT_EXIST_OR_UNUSABLE(721, "抵用券不存在或者因为某些原因无法使用"),
    PAY_VOUCHER_SIZE(722, "抵用券数量异常"),
    PAY_VOUCHER_SELF(730, "本人入住时才可使用抵用券"),
    PAY_DEPOSIT_CASH_AMOUNT_INSUFFICIENT(723, "储值现金不够"),
    PAY_DIRECTPAY_ERROR(724, "直通车信用卡错误"),
    PAY_DIRECTPAY_CLOSE_ERROR(725, "直通车关闭错误"),
    PAY_DIRECTPAY_OPEN_ERROR(726, "直通车开通错误"),
    PAY_PAY_AMOUNT_ERROR(727, "支付时金额总价不匹配"),
    PAY_WEBSERVICE_ERROR(728, "支付失败"),
    PAY_SENDCARDMESSAGE_ERROR(729, "信息提交失败，请核对后重新提交！"),
    PAY_CASH_COUPON_CONVERSION_FAILURE(730, "通过兑换码获取抵用券失败"),
    PAY_ADDCREDITCARDINFO_FAILURE(731, "开通信用住保存信用卡信息失败"),
    PAY_USETRUSTCHECKIN_FAILURE(732, "使用信用住支付订单失败"),
    PAY_PRECHECK_FAILURE(733, "资格验证失败"),
    PAY_PRECHECK_DEPOSIT_FAILURE(734, "不能使用储值"),
    PAY_PLATENOPAY_ERROR(735, "收银台支付异常"),

    BOOKING_PARAM_IS_NULL(801, "预定单数为空"),
    CHAINID_IS_NOT_VALID(802, "酒店ID未通过验证"),
    CHECKIN_DATE_IS_NOT_VALID(803, "入住日期未通过验证"),
    CHECKOUT_DATE_IS_NOT_VALID(804, "离店日期未通过验证"),
    CONTACTNAME_IS_NOT_VALID(805, "联系人未通过验证"),
    CONTACTTEL_IS_NOT_VALID(806, "联系电话填写错误"),
    ROOM_AMOUT_IS_NOT_VALID(807, "房间数量未通过验证"),
    ROOM_TYPE_IS_NOT_VALID(808, "房间类型未通过验证"),
    GUEST_LIST_IS_NOT_VALID(809, "入住人列表未通过验证"),
    GUEST_IS_NOT_VALID(810, "入住人信息未通过验证"),
    GOODS_IS_NOT_VALID(811, "商品信息未通过验证"),
    CASH_COUPON_IS_NOT_VALID(812, "优惠券信息未通过验证"),
    COOPERATION_HOTEL_NEED_ADVANCE_BOOK(813, "该酒店需提前两天预订,如需帮助请致电铂涛会"),
    NOT_ENOUTH_QUOTA(814, "没有足够房间可供预订"),
    QUERY_HOTEL_TOO_MANY(815, "服务器繁忙，请稍后重试"),
    USECASH_IS_NOT_VALID(816, "储值为负数，请联系客服"),


    MEMBER_POINT_NOT_ENOUGH(901, "您的积分不足，请重新选择积分抵现规则！"),
    XYQUOTA_NO_POINT(902, "没有足够的房间"),
    //社交 start
    DELETE_THE_TOPIC(903, "此话题已被删除"),
    DELETE_THE_REPLY(904, "此回复已被删除"),
    DELETE_THE_INTRODUCE(905, "社交介绍页"),
    DELETE_THE_REPLYCLOSE(906, "话题评论已关闭"),
    SOCIAL_THE_LOGIN(907, "登录后才可以操作哦~"),
    SOCIAL_THE_NOBOOKING(908, "无查看权限"),

    //		SOCIAL_THE_PARAMETER_ERROR(911, "参数错误"),
//		SOCIAL_THE_SELFREWARD(912, "不能对自己进行打赏"),
//		SOCIAL_THE_NOTOPIC(913, "话题不存在"),
//		SOCIAL_THE_NOREWARDTYPE(914, "该用户类型不能打赏"),
//		SOCIAL_THE_INTEGRAL_ERROR(915, "积分数额填写有误"),
//		SOCIAL_THE_INSUFFICIENT_POINTS(916, "积分余额不足"),
//		SOCIAL_THE_ONCE_TOOMUCH(917, "单次打赏积分过多"),
//		SOCIAL_THE_ONLY_ONCE(918, "每条话题只能打赏一次"),
//		SOCIAL_THE_ONEDAY_TOOMUCH(919, "单日打赏积分过多"),
//		SOCIAL_THE_REPEATREWARD(920, "对同一条话题不能重复打赏"),

    SOCIAL_THE_OPERATION_PERMISSION(920, "由于权限设置，您不可在该城市发布内容哦~"),
//        SOCIAL_THE_OPERATION_LOCATE(920, "预订酒店，或开启定位才可操作哦~"),
//        SOCIAL_THE_OPERATION_MEMBERTYPE(920, "预订酒店，或级别达到金卡及以上才可操作哦~"),

    SOCIAL_THE_PUBLISH(921, "预订酒店，或级别达到金卡及以上才可发布内容哦~"),
    SOCIAL_THE_LEAVE(922, "预订酒店，或级别达到金卡及以上才可留言哦~"),
    SOCIAL_THE_SHIELD(923, "预订酒店，或级别达到金卡及以上才可屏蔽话题哦~"),
    SOCIAL_THE_REPORT(924, "预订酒店，或级别达到金卡及以上才可举报话题哦~"),
    SOCIAL_THE_NOBOOKING_AND_NOPOSITION(925, "无位置信息"),
    SOCIAL_THE_FREQENTLY_REQUEST(926, "操作频繁"),
    SOCIAL_THE_PROCESS_ERROR(927, "处理出错"),
    SOCIAL_THE_DISABLED(928, "积分打赏功能正在完善中，已暂停打赏~"),
    SOCIAL_THE_ACTION_ERROR_FOLIOCARD(929, "查询用户房卡信息出错"),
    SOCIAL_THE_ACTION_ERROR_CITYNAME(930, "查询房卡城市信息出错"),
    SOCIAL_THE_ACTION_ERROR_MEMBER(931, "查询会员等级出错"),
    //社交 end
    GET_CITY_ERROR(1001, "获取城市列表失败"),
    GET_BRAND_ERROR(1002, "获取酒店品牌失败"),
    GET_DISTRICT_ERROR(1003, "获取区域失败"),
    GET_BIZ_ERROR(1004, "获取商圈失败"),
    PARSEL_CITYCODE_ERROR(1006, "城市CODE映射失败"),

    OAUTH_JSTOKEN_EXPIRED(1101, "Jstoken EXPIRED"),
    //图片验证码
    IMAGE_VERIFY_CODE(1201, "请输入验证码"),
    IMAGE_VERIFY_ERROR(1202, "验证码输入错误"),
    IMAGE_VERIFY_ERROR_MORE(1203, "错误次数太多了，请明天再试");


    private int msgCode;
    private String message;

    MsgCode(int msgCode, String message) {
        this.msgCode = msgCode;
        this.message = message;
    }

    public int getMsgCode() {
        return msgCode;
    }

    public String getMessage() {
        return message;
    }
}
