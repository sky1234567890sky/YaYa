package com.administrator.yaya.base;

import android.util.Log;

import razerdp.util.log.PopupLogUtil;

public class CommonPresenter extends BasePresenter implements ICommonPresenter,ICommonView{

    @Override
    public void getData(int whichApi, Object... t) {
        if (getModel()!=null)
        getModel().getData(this,whichApi,t);
        else Log.e("----------", "请求数据时未找到绑定的model------------------");
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.e("---网络请求发生错误：",whichApi+":"+e != null ? PopupLogUtil.getCrashInfo(e) : "net error————————————");
        if (getView()!=null)getView().onError(whichApi,e);
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        if (getModel()!=null)getView().onResponse(whichApi,t);
        else Log.e("----------", "回传数据时未查询到绑定视图------------------");
    }
}
