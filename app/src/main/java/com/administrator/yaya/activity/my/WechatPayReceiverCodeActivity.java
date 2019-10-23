package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 微信收款码
 */
public class WechatPayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.wechatpay_receive_back_iv)
    ImageView wechatpayReceiveBackIv;
    @BindView(R.id.wechatpay_two_switch)
    Switch wechatpayTwoSwitch;
    @BindView(R.id.pay_add1_iv)
    ImageView payAdd1Iv;
    @BindView(R.id.pay_add2_iv)
    ImageView payAdd2Iv;
    @BindView(R.id.two_ll)
    LinearLayout twoLl;
    @BindView(R.id.get_menry)
    TextView getMenry;
    @BindView(R.id.pay_add3_iv)
    ImageView payAdd3Iv;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.pay_add4_iv)
    ImageView payAdd4Iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wechat_pay_receiver_code;
    }

    @Override
    protected void initListener() {

        wechatpayTwoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SPUtils.getInstance().put(Constants.AUTO_PALY_IN_WIFI, isChecked);
                if (isChecked) {
                    ToastUtil.showShort("onCheckedChanged: 开启" + isChecked);
                } else {
                    ToastUtil.showShort( "onCheckedChanged: 关闭" + isChecked);
                }
            }
        });
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {


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

    @OnClick({R.id.wechatpay_receive_back_iv, R.id.wechatpay_two_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wechatpay_receive_back_iv:
                WechatPayReceiverCodeActivity.this.finish();
                break;
            case R.id.wechatpay_two_switch:
                break;
        }
    }
}
