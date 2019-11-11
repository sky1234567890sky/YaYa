package com.administrator.yaya.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.UpdataPasswordActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.design.SmsVerifyView;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AppValidationMgr;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.google.gson.Gson;
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
    TextView login_btn;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;
    @BindView(R.id.tv_forgetPassword)
    TextView tvForgetPassword;
    private String name;
    private String pwd;
    private SharedPreferences sprfMain;
    private SharedPreferences.Editor editorMain;

    ///从进入登录界面的地方onCreate()方法判断id 跟 token是否为空

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void initExit() {
        //从修改密码页面回来时传的值
//        String phone = getIntent().getStringExtra("phone");
//        if (phone!=null) {
//            //清除UserId
//            mName.setText(phone);
////            SharedPreferences sp = getSharedPreferences("loginUser", Context.MODE_PRIVATE);
////            Editor editor = sp.edit(); editor.clear(); editor.commit();
//        }

//          在加载布局文件前判断是否登陆过
        String userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        if (userId.isEmpty() || userId == null || userId.equals("")) {
            return;
        } else {
//            sprfMain=PreferenceManager.getDefaultSharedPreferences(this);
//            editorMain= sprfMain.edit();
            //.getBoolean("main",false)；当找不到"main"所对应的键值是默认返回false
//            if (sprfMain.getBoolean(NormalConfig.ISFIRST, false)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        }
    }
    @Override
    protected int getLayoutId() {
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //进入页面先判断用户是否已经登录
//        int userId =  mApplication.userid;
//        String s = String.valueOf(userId);

//        MonitorNetWorkChange();

//        SharedPreferences login = getSharedPreferences(NormalConfig.ISFIRST, MODE_PRIVATE);
//        boolean issave = login.getBoolean(NormalConfig.ISFIRSTRUN, false);//
//        String username = login.getString(NormalConfig.USER_NAME, null);
//        String password = login.getString(NormalConfig.PASS_WORD, null);
////        记住密码
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
                int code = info.getCode();
                TestLogin.DataBean data = info.getData();
                if (code == 0) {
//                    Gson gson = new Gson();
//                    TestLogin testLogin = gson.fromJson(msg, TestLogin.class);

//                    int userId = info.getData().getUserId();
                    int userId = data.getUserInfo().getUserId();
                    mApplication.userid = userId;
                    ToastUtil.showShort(info.getMsg());
                    //登录成功保存头像 手机号 密码
                    SharedPrefrenceUtils.saveString(LoginActivity.this, NormalConfig.USER_NAME, name);
                    SharedPrefrenceUtils.saveString(LoginActivity.this, NormalConfig.PASS_WORD, pwd);
                    //保存id
                    SharedPrefrenceUtils.saveString(LoginActivity.this, NormalConfig.USER_ID, String.valueOf(userId));

                    Intent intent = new Intent(this, MainActivity.class);
//                    editorMain.putBoolean(NormalConfig.ISFIRST, true);//成功的记录第一次登录
//                    editorMain.commit();//记录
                    startActivity(intent);
                    finish();
                } else {
                    ToastUtil.showShort(info.getMsg());
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
//                editorMain.putBoolean(NormalConfig.ISFIRST,true);
//                editorMain.commit();
//                startActivity(intent);
//                LoginActivity.this.finish();
                //解析數據
                login();
                break;
            case R.id.tv_registered://回传值
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent1, 99);
                break;
            case R.id.tv_forgetPassword://忘记密码
                startActivity(new Intent(this, UpdataPasswordActivity.class));
                break;
        }
    }

    private void login() {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            String regex = "[A-Za-z0-9]{4,12}";
            if (AppValidationMgr.isPhone(name) && pwd.matches(regex)) {
                mPresenter.getData(ApiConfig.TEXT_LOGIN, name, pwd);
//                okLogin();
            } else ToastUtil.showShort("请输入正确的手机号");
        } else ToastUtil.showShort("请输入账号或密码");
    }

    private void okLogin() {
//        Intent intent = new Intent(this, MainActivity.class);
//                editorMain.putBoolean(NormalConfig.ISFIRST,true);
//                editorMain.commit();
//                startActivity(intent);
//                LoginActivity.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 100) {//注册
            //回传的手机号密码
            String name = data.getStringExtra(NormalConfig.USER_NAME);
            String psw = data.getStringExtra(NormalConfig.PASS_WORD);
//            ToastUtil.showShort(name+"\n"+psw);
            mName.setText(name);
            mPsw.setText(psw);
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