package com.administrator.yaya.model;

import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.ICommonModel;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.INetService;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.base.NetManager;
import com.administrator.yaya.bean.LoginInfo;
import com.administrator.yaya.bean.VerifyCodeInfo;

public class LoginModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.TEXT_LOGIN:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestLogin((String) t[0], (String) t[1]), view, whichApi);
                break;

            case ApiConfig.TEXT_REGISTER://注册
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestRegister((String) t[0], (String) t[0], (String) t[0], (String) t[0]), view, whichApi);
                break;

            case ApiConfig.TEXT_INVITECODE://验证码
//                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
//                        .getTestInviteCode((String) t[0],(String) t[0],(String) t[0]),view,whichApi,1);
                break;
            //首页-我的
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestHomePageData((int) t[0]), view, whichApi);
                break;

            //立即购买
            case ApiConfig.TEXT_BUY_COM:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestBuyCom(), view, whichApi);
                break;

            //提交订单
            case ApiConfig.TEXT_ORDER_STOCK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestOrderStock((int) t[0], (String) t[1], (String) t[2], (String) t[3]), view, whichApi);
                break;
            //查看进货状态 所有进货订单  getTextAllOrderStock
//            case ApiConfig.TEXT_AllORDER_STOCK:
//                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
//                        .getTestAllOrderStock((int) t[0],(int) t[1]),view, whichApi);
//                break;

            //付款信息 2已付款  1待付款
            case ApiConfig.TEXT_GATHERING://待付款
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestOrderStock((int) t[0], (int) t[1]), view, whichApi);
                break;
            case ApiConfig.TEXT_GATHERING2://已付款
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestAccountPaid((int) t[0], (int) t[1]), view, whichApi);
                break;
            case ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestPayToAffimInfo((String) t[0]), view, whichApi);
                break;

            case ApiConfig.TEST_CANCEL_ORDER_STOCK://取消订单
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestCancelOrderStock((int) t[0]), view, whichApi);
                break;


            //通知消息
            case ApiConfig.TEST_NOTIFICATION_INFO:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestNotificationInfo((int) t[0]), view, whichApi);
                break;
            //我的邀请
            case ApiConfig.TEST_MY_INVITE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestMyInvite((int) t[0]), view, whichApi);
                break;
            //我的小账本
            case ApiConfig.TEST_SMALLBOOK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestSmallBook((int) t[0]), view, whichApi);
                break;
            //支付宝二维码
            case ApiConfig.TEST_ALIPAY_RECEIVER_CODE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getAlipayReceiverCode((int) t[0], (int) t[1]), view, whichApi);
                break;
            //微信二维码
            case ApiConfig.TEST_WECHAT_RECEIVER_CODE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getWechatReceiverCode((int) t[0], (int) t[1]), view, whichApi);
                break;
            case ApiConfig.TEST_UPAWAY_SINGLE_GOODS://上架单个货物
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUpawaySingleGoods((String) t[0]), view, whichApi);
                break;


                //所有售卖订单
//            getTestAllOrderStock
            //售卖中
            case ApiConfig.TEST_ALL_ORDERSTOCK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestAllOrderStock((int) t[0],(int) t[0]), view, whichApi);
                break;
            //已完成
            case ApiConfig.TEST_FINISH:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestFinish((int) t[0],(int) t[0]), view, whichApi);
                break;
            //已取消
            case ApiConfig.TEST_CANCEL:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestCancel((int) t[0],(int) t[0]), view, whichApi);
                break;

//            确认收货
//            http://192.168.0.198:8080/yayaApp/comSell/confirmReceipt
//            参数:
//            订单id		salesId
            case ApiConfig.TEST_CONFIRM_RECEIPT:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestConfirmReceipt((int) t[0]), view, whichApi);//salesId
                break;
//                    取消售卖订单
//            http://192.168.0.198:8080/yayaApp/comSell/cancelOrderSales
//            参数:
//            订单编号	saleId
            case ApiConfig.TEST_CANCEL_ORDER_SALES:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestCancelOrderSales((int) t[0]), view, whichApi);//salesId
                break;






                //我的收益
            case ApiConfig.TEST_MY_EARNINGS:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestMyEarnings((int) t[0],(int) t[0]), view, whichApi);
                break;

                //TestPutawayAllOrderStock上架全部货物
            case ApiConfig.TEST_PUTAWAY_ALL_ORDERSTOCK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getPutawayAllOrderStock((int) t[0]), view, whichApi);
                break;

                //返利
            case ApiConfig.TEST_REBATE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestRebate((int) t[0],(int) t[0]), view, whichApi);
                break;
                //支出
            case ApiConfig.TEST_EXPEND:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestExpend((int) t[0],(int) t[0]), view, whichApi);
                break;
                //收入
            case ApiConfig.TEST_INCOME:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestIncome((int) t[0],(int) t[0]), view, whichApi);
                break;



//==================================================>

            case ApiConfig.GET_SMS_MJG:
//                String phoneNum = (String) t[0];
//                manager.method(manager.getNetService("http://47.93.217.58/api/").getSMS(phoneNum),view,whichApi);
                break;
            case ApiConfig.GET_SMS://模拟验证码
                long mills = System.currentTimeMillis();
                String s = String.valueOf(mills);
                s = s.substring(s.length() - 5, s.length() - 1);
                VerifyCodeInfo info = new VerifyCodeInfo();
                info.success = true;
                info.verify_token = s;
                try {
                    Thread.sleep(500l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.onResponse(whichApi, info);
                break;
            case ApiConfig.LOGIN_ACC:
                String path = (String) t[0];
                LoginInfo loginInfo = new LoginInfo(path, System.currentTimeMillis() + "", "登录成功", "renxiaolong");
                try {
                    Thread.sleep(500l);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                view.onResponse(whichApi, loginInfo);
                break;


        }
    }
}
