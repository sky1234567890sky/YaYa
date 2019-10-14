package com.administrator.yaya.base;

import android.app.Application;
import android.content.Context;

import com.administrator.yaya.local_utils.DeviceUuidFactory;

import java.util.UUID;

public class BaseApp extends Application {

    public static BaseApp mBaseApp;
    public String mToken = "";
    public UUID mUuid;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
        mUuid = DeviceUuidFactory.getInstance(getApplication()).getDeviceUuid();
    }

    public static Context getApplication(){
        return mBaseApp.getApplicationContext();
    }
    public static BaseApp getInstance() {
        return mBaseApp;
    }
}
