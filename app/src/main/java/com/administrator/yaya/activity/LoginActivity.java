package com.administrator.yaya.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
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
import com.squareup.haha.perflib.Main;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.model.TResult;

import java.util.prefs.Preferences;

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
    TextView login_btn;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;
    @BindView(R.id.tv_forgetPassword)
    TextView tvForgetPassword;
    private String name;
    private String pwd;
    private String spPsw;
    private SharedPreferences sprfMain;
    private SharedPreferences.Editor editorMain;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void initExit() {
        //在加载布局文件前判断是否登陆过
        sprfMain = PreferenceManager.getDefaultSharedPreferences(this);
        editorMain = sprfMain.edit();
        //.getBoolean("main",false)；当找不到"main"所对应的键值是默认返回false
        if(sprfMain.getBoolean(NormalConfig.ISFIRST,false)){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
    @Override
    protected void initView() {

//        SharedPreferences login = getSharedPreferences(NormalConfig.ISFIRST, MODE_PRIVATE);
//        boolean issave = login.getBoolean(NormalConfig.ISFIRSTRUN, false);
//
//        String username = login.getString(NormalConfig.USER_NAME, null);
//        String password = login.getString(NormalConfig.PASS_WORD, null);
//        //记住密码
//        if (username.isEmpty() && password.isEmpty()) {
//            return;
//        } else {
//            if (issave == true) {
//                mName.setText(username);
//                mPsw.setText(password);
//                initData();// 网络请求
//            } else {
//                return;
//            }
//        }
    }
    @SuppressLint("ApplySharedPref")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_LOGIN:
                TestLogin info = (TestLogin) t[0];

                ToastUtil.showShort(info.getMsg());

                if (info.getCode() == 0) {
                    //登录成功保存头像 手机号 密码
                    SharedPrefrenceUtils.saveString(LoginActivity.this, NormalConfig.USER_NAME, name);
                    SharedPrefrenceUtils.saveString(LoginActivity.this, NormalConfig.PASS_WORD, pwd);

                    Intent intent = new Intent(this, MainActivity.class);
                    editorMain.putBoolean(NormalConfig.ISFIRST,true);
                    editorMain.commit();
                    startActivity(intent);
                    LoginActivity.this.finish();
                }
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        String name = mName.getText().toString().trim();
        String psw = mPsw.getText().toString().trim();


    }
    @OnClick({R.id.login_btn, R.id.tv_registered, R.id.tv_forgetPassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                name = mName.getText().toString();
                pwd = mPsw.getText().toString();
//                Intent intent = new Intent(this, MainActivity.class);
//                startActivity(intent);
//                finish();
                //解析數據
                login();
                break;
            case R.id.tv_registered:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent1,99);
                break;
            case R.id.tv_forgetPassword:
                startActivity(new Intent(this, RetrievePasswordActivity.class));
                break;
        }
    }
    private void login() {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            String regex = "[A-Za-z0-9]{4,12}";
            if (AppValidationMgr.isPhone(name) && pwd.matches(regex)) {
                mPresenter.getData(ApiConfig.TEXT_LOGIN, name, pwd);
            } else ToastUtil.showShort("请输入正确的手机号");
        } else ToastUtil.showShort("请输入账号或密码");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99 && resultCode==100){
            //回传的手机号密码
            String name = data.getStringExtra(NormalConfig.USER_NAME);
            String psw = data.getStringExtra(NormalConfig.PASS_WORD);
//            ToastUtil.showShort(name+"\n"+psw);
        }
    }


    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
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

    @Override
    public void smsCodeSend() {
    }

    @Override
    public void countryCodeOpen() {

    }


}