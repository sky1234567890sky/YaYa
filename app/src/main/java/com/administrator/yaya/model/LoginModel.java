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
                        .getTestRegister((String) t[0], (String) t[0], (String) t[0],(String) t[0]), view, whichApi);
                break;

            case ApiConfig.TEXT_INVITECODE://验证码
//                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
//                        .getTestInviteCode((String) t[0],(String) t[0],(String) t[0]),view,whichApi,1);
                break;
                //首页-我的
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestHomePageData((int) t[0]),view, whichApi);
                break;

                //立即购买
            case ApiConfig.TEXT_BUY_COM:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestBuyCom(),view, whichApi);
                break;

                //提交订单
            case ApiConfig.TEXT_ORDER_STOCK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestOrderStock((int) t[0], (String) t[1], (String) t[2],(String) t[3]),view, whichApi);
                break;

            //查看进货状态 所有进货订单  getTextAllOrderStock
            case ApiConfig.TEXT_AllORDER_STOCK:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestAllOrderStock((int) t[0],(int) t[1]),view, whichApi);
                break;

            //付款信息
            case ApiConfig.TEXT_GATHERING:
                netManager.method(netManager.getNetService(NetConfig.BaseUrl)
                        .getTestGathering((String)t[0]),view, whichApi);
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
