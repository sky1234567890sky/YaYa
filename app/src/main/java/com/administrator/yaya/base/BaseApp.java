package com.administrator.yaya.base;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.local_utils.DeviceUuidFactory;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.androidnetworking.AndroidNetworking;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.LinkedList;
import java.util.UUID;

public class BaseApp extends Application {
    private LinkedList<Activity> mList = new LinkedList<Activity>();
    public static BaseApp mBaseApp;
    public String mToken = "";
    public UUID mUuid;
    public boolean mPlayInWifi;
    public boolean mImIsLogin = false;

    public static String AppId="4c60d31758736f2ad0f78641bc9c22a4";

    public static String APP_SERECET="";

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
        //两种方式注册
        initWechat();
        mUuid = DeviceUuidFactory.getInstance(getApplication()).getDeviceUuid();
        MultiDex.install(this);

        //
        AndroidNetworking.initialize(this);

    }
    private void initWechat() {
        //TODO:你的appId
        // 三个参数分别是上下文、应用的appId、是否检查签名（默认为false）
//        IWXAPI mWxApi = WXAPIFactory.createWXAPI(this,AppId, true);
//// 注册
//        mWxApi.registerApp(AppId);
    }
    public static Context getApplication(){
        return mBaseApp.getApplicationContext();
    }
    public static BaseApp getInstance() {
        return mBaseApp;
    }
//    用户点击后直接退出程序并返回桌面。
    // 添加Activity到列表中维持
    public void addActivity(Activity activity) {
        mList.add(activity);
    }
    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}