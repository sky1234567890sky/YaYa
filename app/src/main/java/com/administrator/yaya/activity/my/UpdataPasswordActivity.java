package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.CountDownTimerUtils;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 修改密码
 */
public class UpdataPasswordActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.update_back_iv)
    ImageView forgetBackIv;
    @BindView(R.id.update_et_code)
    EditText updateEtCode;
    @BindView(R.id.update_et_verificationCode)
    EditText forgetEtVerificationCode;
    @BindView(R.id.update_btv_getverificationCode)
    TextView updateBtvGetverificationCode;
    @BindView(R.id.update_password_et)
    EditText updatePasswordEt;
    @BindView(R.id.update_ok_btn)
    Button updateOkBtn;
    private CountDownTimerUtils mDownTimerUtils;


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
                mDownTimerUtils.start();
                ToastUtil.showShort("验证码已发送请注意验收");
                break;
            case R.id.update_ok_btn:

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

    }
}
