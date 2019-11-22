package com.administrator.yaya.model;

import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.ICommonModel;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.base.NetManager;
import com.administrator.yaya.bean.LoginInfo;
import com.administrator.yaya.bean.VerifyCodeInfo;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class LoginModel implements ICommonModel {

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.TEXT_LOGIN:
                //    userPhone
//    userPwd
//    手机型号  appModel
//    设备号   appDeviceNumber
//    Android Mac地址 appMac
                String userPhone = (String) t[0];
                String userPwd = (String) t[1];
                String appModel = (String) t[2];
                String appDeviceNumber = (String) t[3];
                String appMac = (String) t[4];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestLogin(userPhone, userPwd, appModel, appDeviceNumber, appMac), view, whichApi);
                break;

            case ApiConfig.TEXT_REGISTER://注册

                String s1 = (String) t[0];
                String s2 = (String) t[1];
                String s3 = (String) t[2];
                String s4 = (String) t[3];
                String token = (String) t[4];

                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestRegister(s1, s2, s3, s4, token), view, whichApi);
                break;

            case ApiConfig.TEXT_INVITECODE://手机验证码获取
                String phoneCode = (String) t[0];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestInviteCode(phoneCode), view, whichApi);

                break;

            //首页-我的
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                String token1 = (String) t[1];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestHomePageData((int) t[0], token1), view, whichApi);
                break;

            //立即购买
            case ApiConfig.TEXT_BUY_COM:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestBuyCom((int) t[0],(String) t[1]), view, whichApi);
                break;

            //提交订单
            case ApiConfig.TEXT_ORDER_STOCK:
                int i = (int) t[0];
                String i2 = (String) t[1];
                String i3 = (String) t[2];
                String i4 = (String) t[3];
                String i5 = (String) t[4];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestOrderStock(i, i2, i3, i4,i5), view, whichApi);
                break;
            //查看进货状态 所有进货订单  getTextAllOrderStock
//            case ApiConfig.TEXT_AllORDER_STOCK:
//                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
//                        .getTestAllOrderStock((int) t[0],(int) t[1]),view, whichApi);
//                break;
            //付款信息 2已付款  1待付款
            case ApiConfig.TEXT_GATHERING://待付款
                int a = (int) t[0];
                int b = (int) t[1];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestObateligation(a, b), view, whichApi);
                break;
            case ApiConfig.TEXT_GATHERING2://已付款
                int i1 = (int) t[0];
                int t2 = (int) t[1];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestAccountPaid(i1, t2), view, whichApi);
                break;
            case ApiConfig.TEXT_PAYINFO_TO_AFFIRMINFO://付款信息
                String s = (String) t[0];
                String toke = (String) t[1];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestPayToAffimInfo(s,toke), view, whichApi);
                break;
            //取消订单
            case ApiConfig.TEST_CANCEL_ORDER_STOCK://取消售卖订单
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestCancelOrderStock((int) t[0]), view, whichApi);
                break;
            //通知消息
            case ApiConfig.TEST_NOTIFICATION_INFO:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestNotificationInfo((int) t[0], (String) t[1]), view, whichApi);
                break;
            //我的邀请
            case ApiConfig.TEST_MY_INVITE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestMyInvite((int) t[0],(String)t[1]), view, whichApi);
                break;

            //我的小账本
            case ApiConfig.TEST_SMALLBOOK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestSmallBook((int) t[0],(String)t[1]), view, whichApi);
                break;

            //支付宝二维码
            case ApiConfig.TEST_ALIPAY_RECEIVER_CODE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getAlipayReceiverCode((int) t[0], (int) t[1], (String) t[2]), view, whichApi);
                break;

            //上传收款码（列表接口）

            case ApiConfig.TEST_WECHAT_RECEIVER_CODE:
                int userId = (int) t[0];
                int type = (int) t[1];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getWechatReceiverCode(userId, type, (String) t[2]), view, whichApi);
                break;

            //微信二维码图片上传
            case ApiConfig.TEST_UPLOAD_IMAGEVIE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getUploadIv((MultipartBody.Part) t[0]), view, whichApi);
                break;
//            参数:
//            imgId   添加时可无
//            userId 用户id
//            imgType 1、微信 2、支付宝
//            imgUrl 图片路径
//            imgMoney  码金额

            case ApiConfig.TEST_UPLOAD_GET_QR://上传收款码
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUpLoadGetQr((int) t[0], (int) t[1], (String) t[2], (double) t[3]), view, whichApi);
                break;
/**
 *第二次上传二维码
 */case ApiConfig.TEST_UPLOAD_GET_QR_NO2://上传收款码
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUpLoadGetQrNo2((int) t[0], (int) t[0], (int) t[1], (String) t[2], (double) t[3]), view, whichApi);
                break;

            case ApiConfig.TEST_UPAWAY_SINGLE_GOODS://上架单个货物
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUpawaySingleGoods((String) t[0],(String) t[1]), view, whichApi);
                break;

            //所有售卖订单
//            getTestAllOrderStock
            //售卖中
            case ApiConfig.TEST_ALL_ORDERSTOCK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestAllOrderStock((int) t[0], (int) t[1],(String)t[2]), view, whichApi);
                break;

            //已完成
            case ApiConfig.TEST_FINISH:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestFinish((int) t[0],(String)t[1], (int) t[2]), view, whichApi);
                break;
            //已取消
            case ApiConfig.TEST_CANCEL:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestCancel((int) t[0], (String)t[1],(int) t[2]), view, whichApi);
                break;

//            确认收货
//            http://192.168.0.198:8080/yayaApp/comSell/confirmReceipt
//            参数:
//            订单id		salesId
            case ApiConfig.TEST_CONFIRM_RECEIPT:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestConfirmReceipt((int) t[0], (int) t[1], (String) t[2]), view, whichApi);//salesId
                break;

//                    取消售卖订单
//            http://192.168.0.198:8080/yayaApp/comSell/cancelOrderSales
//            参数:
//            订单编号	saleId
            case ApiConfig.TEST_CANCEL_ORDER_SALES:
                int t1 = (int) t[0];
                String t22 = (String) t[0];

                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestCancelOrderSales(t1,t22), view, whichApi);//salesId
                break;

            //我的收益
            case ApiConfig.TEST_MY_EARNINGS:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestMyEarnings((int) t[0], (String)t[1],(int) t[2]), view, whichApi);
                break;

            //TestPutawayAllOrderStock上架全部货物
            case ApiConfig.TEST_PUTAWAY_ALL_ORDERSTOCK:
                String to = (String) t[1];
                int ii = (int) t[2];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getPutawayAllOrderStock((int) t[0], to,ii), view, whichApi);
                break;

            //我的收益
            //返利
            case ApiConfig.TEST_REBATE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestRebate((int) t[0], (String) t[1],(int) t[2]), view, whichApi);
                break;

            //支出
            case ApiConfig.TEST_EXPEND:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestExpend((int) t[0], (String) t[1], (int) t[2]), view, whichApi);
                break;

            //收入
            case ApiConfig.TEST_INCOME:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestIncome((int) t[0],  (String) t[1],(int) t[2]), view, whichApi);
                break;

            //修改密码
            case ApiConfig.TEST_UPDATEPASSWORD:

                String phone = (String) t[0];
                String versication = (String) t[1];
                String pwd = (String) t[2];
                int userid = (int) t[3];
                String token2 = (String) t[4];

                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUpdatePwd(phone, versication, pwd, userid, token2), view, whichApi);

                break;

            //更换头像
//            case ApiConfig.TEST_CHANGE_HEADLER:
//                String  header= (String) t[0];
//                File file = new File(header);
//                RequestBody body = new MultipartBody.Builder()
//                        .setType(MultipartBody.FORM)
//                        .addFormDataPart("key", "")
//                        .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/png"), file ))
//                        .build();
//                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
//                .getTestUpdateHeadImg(body,(int) t[0]), view, whichApi);
//                break;
            //验证码  666666
            //上传头像

            case ApiConfig.TEST_CHANGE_HEADLER:
                String img = (String) t[1];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getLoadHeadlerIv((int) t[0], img), view, whichApi);
                break;

            case ApiConfig.TEST_VERIFICATIONCODE:
                String s5 = (String) t[0];
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestVerficationCode(s5), view, whichApi);
                break;

            //开关收款码
            case ApiConfig.TEST_SWITCH_RECEIVEING_QRCODE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestSwitchReceiveingQrCode((int) t[0], (int) t[1], (int) t[2], (String) t[3]), view, whichApi);
                break;

            //上传昵称   接口得调
            case ApiConfig.TEST_UPLOAD_NAME:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUploadHeadler((int) t[0], (String) t[1], (String) t[2]), view, whichApi);
                break;


            //手否有未读消息
            case ApiConfig.TEST_GET_USERNOW_MSG:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestUserNowMsg((int) t[0], (String) t[1]), view, whichApi);
                break;
            //库存
            case ApiConfig.TEST_INVENTORY:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestInventory((int) t[0], (String) t[1]), view, whichApi);
                break;

                //确认营业
            case ApiConfig.TEST_DIANJIYINGYE:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestDianjiYingye((int) t[0], (String) t[1],(String) t[2]), view, whichApi);
                break;


//==================================================>
            case ApiConfig.GET_SMS_MJG:
//                String phoneNum = (String) t[0];
//                manager.method(manager.getNetService("http://47.93.217.58/api/").getSMS(phoneNum),view,whichApi);
                break;
            case ApiConfig.GET_SMS://模拟验证码
//                long mills = System.currentTimeMillis();
//                String s = String.valueOf(mills);
//                s = s.substring(s.length() - 5, s.length() - 1);
//                VerifyCodeInfo info = new VerifyCodeInfo();
//                info.success = true;
//                info.verify_token = s;
//                try {
//                    Thread.sleep(500l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                view.onResponse(whichApi, info);
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
