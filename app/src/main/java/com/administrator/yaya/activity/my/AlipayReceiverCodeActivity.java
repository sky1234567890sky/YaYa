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
 * 支付宝收款
 */
public class AlipayReceiverCodeActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.pay_receive_back_iv)
    ImageView payReceiveBackIv;
    @BindView(R.id.two_switch)
    Switch twoSwitch;
    @BindView(R.id.add1)
    ImageView add1;
    @BindView(R.id.add2)
    ImageView add2;
    @BindView(R.id.two_ll)
    LinearLayout twoLl;
    @BindView(R.id.get_menry)
    TextView getMenry;
    @BindView(R.id.add3)
    ImageView add3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.add4)
    ImageView add4;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payments_receive;
    }

    @Override
    protected void initListener() {

        twoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

    @OnClick({R.id.pay_receive_back_iv, R.id.two_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pay_receive_back_iv:
                AlipayReceiverCodeActivity.this.finish();
                break;
            case R.id.two_switch:
                break;
        }
    }
}
