package com.administrator.yaya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.INetService;
import com.administrator.yaya.base.NetConfig;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AppValidationMgr;
import com.administrator.yaya.utils.ToastUtil;

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

    @BindView(R.id.login_headler_iv)
    ImageView loginHeadlerIv;
    @BindView(R.id.login_name_et)
    EditText mName;
    @BindView(R.id.et_login_password)
    EditText mPsw;
    @BindView(R.id.login_btn)
    Button login_btn;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;
    @BindView(R.id.tv_forgetPassword)
    TextView tvForgetPassword;
    private String name;
    private String pwd;

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
        ToastUtil.showShort(e.getMessage());
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_LOGIN:
                TestLogin info= (TestLogin) t[0];
                    ToastUtil.showShort(info.getMsg());
                    ToastUtil.showShort("回来数据了... ");
                    if (info.getCode()==0) startActivity(new Intent(this,MainActivity.class));

                break;
        }
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
    @OnClick({ R.id.login_headler_iv, R.id.login_btn, R.id.tv_registered, R.id.tv_forgetPassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_headler_iv:

            case R.id.login_btn:
                //解析数据
                name = mName.getText().toString();
                pwd = mPsw.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                    String regex = "[A-Za-z0-9]{4,12}";
                    if (AppValidationMgr.isPhone(name)&& pwd.matches(regex)){
                        mPresenter.getData(ApiConfig.TEXT_LOGIN, name, pwd);
                        ToastUtil.showShort("在请求数据...");
                    } else ToastUtil.showShort("请输入正确的手机号");
                }
                else ToastUtil.showShort("请输入账号或密码");

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