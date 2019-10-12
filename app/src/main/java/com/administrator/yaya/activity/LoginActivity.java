package com.administrator.yaya.activity;

import android.view.View;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.model.LoginModel;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.model.TResult;

import razerdp.design.SlideFromBottomPopup;

public class LoginActivity extends BaseMvpActivity<LoginModel> implements TakePhoto.TakeResultListener,SmsVerifyView.SmsVerifyCallback,SlideFromBottomPopup.BottomPopClick {

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @Override
    public void smsCodeSend() {

    }

    @Override
    public void countryCodeOpen() {

    }

    @Override
    public void takeSuccess(TResult result) {

    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }

    @Override
    public void clickTop() {

    }

    @Override
    public void clickCenter() {

    }

    @Override
    public void clickBottom() {

    }
}
