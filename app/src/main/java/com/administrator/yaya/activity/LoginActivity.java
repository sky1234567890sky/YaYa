package com.administrator.yaya.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.jiajun.EncryptionByMD5;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AppValidationMgr;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.model.TResult;

import butterknife.BindView;
import butterknife.OnClick;
import razerdp.design.SlideFromBottomPopup;

/**
 * 登录界面
 * sky
 */
public class LoginActivity extends BaseMvpActivity<LoginModel> implements TakePhoto.TakeResultListener, SmsVerifyView.SmsVerifyCallback, SlideFromBottomPopup.BottomPopClick {
    @BindView(R.id.login_headler_iv)
    RoundedImageView loginHeadlerIv;

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
    private String spPsw;
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
//        ToastUtil.showShort(e.getMessage());
    }
    @Override
    protected void initView() {
        super.initView();
        //没网也能登？
//        String PASSWORD = SharedPrefrenceUtils.getString(LoginActivity.this, NormalConfig.PASS_WORD);
//        String USERNAME = SharedPrefrenceUtils.getString(LoginActivity.this, NormalConfig.USER_NAME);
//        if (USERNAME.equals(name)  && PASSWORD.equals(pwd)){
//            //匹配成功登录跳转
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//        }else{
//            showMessage("error");
//            mPsw.setText("");
//        }
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_LOGIN:
                TestLogin info= (TestLogin) t[0];
                //
                if (info.getCode()==0) {
                    SharedPrefrenceUtils.saveString(LoginActivity.this,NormalConfig.USER_NAME,name);
                    SharedPrefrenceUtils.saveString(LoginActivity.this,NormalConfig.PASS_WORD,pwd);
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);

                }

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
    @OnClick({R.id.login_btn, R.id.tv_registered, R.id.tv_forgetPassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                //解析数据
                name = mName.getText().toString();
                pwd = mPsw.getText().toString();
                //对当前用户输入的密码进行MD5加密再进行比对判断, MD5Utils.md5( ); psw 进行加密判断是否一致
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
//                login();
                break;
            case R.id.tv_registered:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.tv_forgetPassword:
                startActivity(new Intent(this,RetrievePasswordActivity.class));
                break;
        }
    }
    private void login() {
//                startActivity(new Intent(this,MainActivity.class));
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            String regex = "[A-Za-z0-9]{4,12}";
            if (AppValidationMgr.isPhone(name)&& pwd.matches(regex)){
                mPresenter.getData(ApiConfig.TEXT_LOGIN, name, pwd);
            } else ToastUtil.showShort("请输入正确的手机号");
        }
        else ToastUtil.showShort("请输入账号或密码");
    }
}