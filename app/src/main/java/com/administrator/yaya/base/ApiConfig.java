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
    public static final int TEXT_GATHERING2 = 12;//付款信息 已付款
    public static final int TEXT_GATHERING = 13;//待付款
    public static final int TEXT_PAYINFO_TO_AFFIRMINFO = 14;//从付款信息跳到确认信息
    public static final int TEST_CANCEL_ORDER_STOCK = 15;//取消进货订单

    public static final int TEST_NOTIFICATION_INFO = 16;//通知消息


    public static final int TEST_MY_INVITE = 17;//我的邀请
    public static final int TEST_SMALLBOOK = 18;//我的小账本
    public static final int TEST_ALIPAY_RECEIVER_CODE = 19;//支付宝二维码
    public static final int TEST_WECHAT_RECEIVER_CODE = 20;//微信二维码

    public static final int TEST_UPAWAY_SINGLE_GOODS = 21; //上架单个货物

    //所有售卖订单
    public static final int TEST_ALL_ORDERSTOCK = 22;
    public static final int TEST_FINISH = 30;//已完成
    public static final int TEST_CANCEL = 31;//已取消
    public static final int TEST_CONFIRM_RECEIPT = 28;//确认收货
    public static final int TEST_CANCEL_ORDER_SALES = 29;//取消售卖订单

    public static final int TEST_MY_EARNINGS = 23;//我的收益

    public static final int TEST_PUTAWAY_ALL_ORDERSTOCK = 24;//上架全部货物

    //我的收益
    public static final int TEST_REBATE = 25;//返利
    public static final int TEST_EXPEND = 26;//支出
    public static final int TEST_INCOME = 27;//收入


    public static final int TEST_UPDATEPASSWORD = 32;//修改密码
    public static final int TEST_CHANGE_HEADLER = 33;//更换头像
    //修改密码
    public static final int TEST_VERIFICATIONCODE = 34;//获取验证码
}