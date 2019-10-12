package com.administrator.yaya.model;

import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.ICommonModel;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.NetManager;
import com.administrator.yaya.bean.LoginInfo;
import com.administrator.yaya.bean.VerifyCodeInfo;

public class LoginModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager manager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.GET_SMS_MJG:
                String phoneNum = (String) t[0];
                manager.method(manager.getNetService("http://47.93.217.58/api/").getSMS(phoneNum),view,whichApi);
                break;
            case ApiConfig.GET_SMS://模拟验证码
                long mills = System.currentTimeMillis();
                String s = String.valueOf(mills);
                s = s.substring(s.length()-5,s.length()-1);
                VerifyCodeInfo info = new VerifyCodeInfo();
                info.success = true;
                info.verify_token = s;
                try {
                    Thread.sleep(500l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.onResponse(whichApi,info);
                break;

            case ApiConfig.LOGIN_ACC:
                String path = (String) t[0];
                LoginInfo loginInfo = new LoginInfo(path, System.currentTimeMillis() + "", "登录成功","renxiaolong");
                try {
                    Thread.sleep(500l);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                view.onResponse(whichApi,loginInfo);
                break;


        }
    }
}