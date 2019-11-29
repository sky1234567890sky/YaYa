package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestGetEtVerificationCode;
import com.administrator.yaya.bean.orderform.TestUpdatePwd;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.AppValidationMgr;
import com.administrator.yaya.utils.CountDownTimerUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改密码
 */
public class UpdataPasswordActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.update_back_iv)
    ImageView forgetBackIv;
    @BindView(R.id.update_et_code)//手机号
            EditText updateEtCode;
    @BindView(R.id.update_et_verificationCode)//验证码   666666
            EditText forgetEtVerificationCode;
    @BindView(R.id.update_btv_getverificationCode)
    TextView updateBtvGetverificationCode;
    @BindView(R.id.update_password_et)//密码  1234
            EditText updatePasswordEt;

    @BindView(R.id.update_ok_btn)
    Button updateOkBtn;
    private CountDownTimerUtils mDownTimerUtils;
    private String userId;
    private String token;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_updata_password;
    }

    @Override
    protected void initView() {
        //倒计时工具类
        mDownTimerUtils = new CountDownTimerUtils(updateBtvGetverificationCode, 60000, 1000);
    }

    @OnClick({R.id.update_back_iv, R.id.update_btv_getverificationCode, R.id.update_ok_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update_back_iv:
                UpdataPasswordActivity.this.finish();
                break;
            case R.id.update_btv_getverificationCode:
                String phone = updateEtCode.getText().toString().trim();
                if (!phone.isEmpty()) {
                    mDownTimerUtils.start();
                    mPresenter.getData(ApiConfig.TEST_VERIFICATIONCODE, phone);//验证码
                } else {
                    ToastUtil.showShort("请输入手机号");
                }
                break;
            case R.id.update_ok_btn:
                String phoneCode = updateEtCode.getText().toString().trim();
                String verificationCode = forgetEtVerificationCode.getText().toString().trim();
                String psw = updatePasswordEt.getText().toString().trim();

                if (TextUtils.isEmpty(phoneCode)) {
                    ToastUtil.showLong("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(verificationCode)) {
                    ToastUtil.showLong("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(psw)) {
                    ToastUtil.showLong("请输入密码");
                    return;
                }
                //6-16位数字字母混合,不能全为数字,不能全为字母,首位不能为数字
//              ^(?![0-9])(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,12}$

                String regex = "[A-Za-z0-9]{4,12}";
                if (!AppValidationMgr.isPhone(phoneCode)) {
                    ToastUtil.showShort("请输入正确的手机号或密码");
                    return;
                }
                if (!psw.matches(regex)) {
                    ToastUtil.showShort("请输入正确的密码格式");
                    return;
                }else{
                    userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
                    token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
                    mPresenter.getData(ApiConfig.TEST_UPDATEPASSWORD, phoneCode, verificationCode, psw,Integer.parseInt(userId), token);
                }
                break;
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
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //修改密码
            case ApiConfig.TEST_UPDATEPASSWORD://修改密碼
                TestUpdatePwd testUpdatePwd = (TestUpdatePwd) t[0];

                if (testUpdatePwd.getMsg().equals(mApplication.SignOut)) {
                    Intent intent = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(intent);

                    finish();
                }
                if (testUpdatePwd.getCode() == 0 && !testUpdatePwd.getMsg().equals(mApplication.SignOut)) {
                    String phone = updateEtCode.getText().toString();
                    String pas = updatePasswordEt.getText().toString();
                    ToastUtil.showShort("修改成功");
                    Intent intent = new Intent(UpdataPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            //获取验证码
            case ApiConfig.TEST_VERIFICATIONCODE:
                TestGetEtVerificationCode testGetEtVerificationCode = (TestGetEtVerificationCode) t[0];
                if (testGetEtVerificationCode.getCode() == 0 && testGetEtVerificationCode.getMsg() != null) {
//                    String verificationCode = testGetEtVerificationCode.getMsg();//验证码
//                    forgetEtVerificationCode.setText(verificationCode);//自动粘贴
                    ToastUtil.showShort(testGetEtVerificationCode.getMsg());
                } else {

                }
                break;
        }
    }
}
