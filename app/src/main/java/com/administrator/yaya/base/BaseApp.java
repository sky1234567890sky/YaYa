package com.administrator.yaya.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.administrator.yaya.local_utils.DeviceUuidFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BaseApp extends Application {
    private LinkedList<Activity> mList = new LinkedList<Activity>();
    public static BaseApp mBaseApp;
    public String mToken = "";
    public UUID mUuid;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
        mUuid = DeviceUuidFactory.getInstance(getApplication()).getDeviceUuid();
        MultiDex.install(this);
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