package com.administrator.yaya.base;

public class CommonPresenter extends BasePresenter implements ICommonPresenter,ICommonView{

    @Override
    public void getData(int whichApi, Object[] t) {
        getModel().getData(this,whichApi,t);
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        if (getView()!=null)getView().onError(whichApi,e);
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        if (getModel()!=null)getView().onResponse(whichApi,t);
    }
}
