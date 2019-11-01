package com.administrator.yaya.base;

/**
 * 参数区分
 */
public class ApiConfig {
    public static final int GET_SMS = 1;
    public static final int GET_SMS_MJG = 2;
    public static final int LOGIN_ACC = 3;

    public static final int TEXT_LOGIN=4;
    public static final int TEXT_REGISTER = 5;
    public static final int TEXT_InviteCode = 6;
    public static final int TEXT_INVITECODE = 7;


    public static final int TEXT_HOMEPAGE_DATA = 8;//首页 我的
    public static final int TEXT_BUY_COM = 9;//立即购买
    public static final int TEXT_ORDER_STOCK = 10;//提交订单
    public static final int TEXT_AllORDER_STOCK = 11;//查看进货状态 所有进货订单
    public static final int TEXT_GATHERING = 12;//付款信息 已付款
    public static final int TEXT_GATHERING2 = 13;//待付款
    public static final int TEXT_PAYINFO_TO_AFFIRMINFO = 14;//从付款信息跳到确认信息
    public static final int TEST_CANCEL_ORDER_STOCK = 15;//取消进货订单

    public static final int TEST_NOTIFICATION_INFO = 16;//通知消息


    public static final int TEST_MY_INVITE = 17;//我的邀请
    public static final int TEST_SMALLBOOK = 18;//我的小账本
    public static final int TEST_ALIPAY_RECEIVER_CODE = 19;//支付宝二维码
    public static final int TEST_WECHAT_RECEIVER_CODE = 20;//微信二维码
}
