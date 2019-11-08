package com.administrator.yaya.base;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.local_utils.DeviceUuidFactory;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.LinkedList;
import java.util.UUID;

public class BaseApp extends Application {
    private LinkedList<Activity> mList = new LinkedList<Activity>();
    public static BaseApp mBaseApp;
    public String mToken = "";
    public int userid;
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
//        AndroidNetworking.initialize(this);
    }

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
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