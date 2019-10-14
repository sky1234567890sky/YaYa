package com.administrator.yaya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.model.LoginModel;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.model.TResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.design.SlideFromBottomPopup;

/**
 * 登录界面
 * sky
 */
public class LoginActivity extends BaseMvpActivity<LoginModel> implements TakePhoto.TakeResultListener, SmsVerifyView.SmsVerifyCallback, SlideFromBottomPopup.BottomPopClick {

    @BindView(R.id.login_back_iv)
    ImageView loginBackIv;
    @BindView(R.id.login_headler_iv)
    ImageView loginHeadlerIv;
    @BindView(R.id.et_uname)
    EditText etUname;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.login_btn)
    Button login_btn;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;
    @BindView(R.id.tv_forgetPassword)
    TextView tvForgetPassword;

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


    @OnClick({R.id.login_back_iv, R.id.login_headler_iv, R.id.login_btn, R.id.tv_registered, R.id.tv_forgetPassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back_iv:
                finish();
                break;
            case R.id.login_headler_iv:
                break;
            case R.id.login_btn:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.tv_registered:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.tv_forgetPassword:
                startActivity(new Intent(this,RetrievePasswordActivity.class));
                break;
        }
    }
}