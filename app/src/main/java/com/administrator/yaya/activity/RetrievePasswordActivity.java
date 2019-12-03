package com.administrator.yaya.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonModel;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.CountDownTimerUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class RetrievePasswordActivity extends BaseMvpActivity<LoginModel> implements ICommonModel,ICommonView {
    @BindView(R.id.forget_back_iv)
    ImageView forgetBackIv;
    @BindView(R.id.register_headler_iv)
    RoundedImageView registerHeadlerIv;
    @BindView(R.id.forget_et_phone)
    EditText forgetEtPhone;
    @BindView(R.id.forget_et_verificationCode)
    EditText getcode;
    @BindView(R.id.forget_getcode_btn)
    TextView forgetGetcodeBtn;
    @BindView(R.id.forget_et_login_password)
    EditText forgetEtLoginPassword;
    @BindView(R.id.forget_ok_btn)
    Button forgetOkBtn;
    private CountDownTimerUtils downTimerUtils;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_retrieve_password;
    }
    @Override
    protected void initView() {
        //倒计时工具类
        downTimerUtils = new CountDownTimerUtils(forgetGetcodeBtn, 60000, 1000);
    }
    @OnClick({R.id.forget_back_iv, R.id.register_headler_iv, R.id.forget_getcode_btn, R.id.forget_ok_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_back_iv:
                finish();
                break;
            case R.id.register_headler_iv:
                break;
            case R.id.forget_getcode_btn://获取验证码
                downTimerUtils.start();
                ToastUtil.showLong("验证码已发送请注意验收");
                break;
            case R.id.forget_ok_btn:
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
    public void getData(ICommonView view, int whichApi, Object[] t) {

    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong("服务器错误！");
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
