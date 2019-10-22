package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.base.BaseApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.my_invientory_rl)
    RelativeLayout myInvientoryRl;
    @BindView(R.id.my_small_rl)
    RelativeLayout mySmallRl;
    @BindView(R.id.my_pay_code_rl)
    RelativeLayout myPayCodeRl;
    @BindView(R.id.my_update_password_rl)
    RelativeLayout myUpdatePasswordRl;
    @BindView(R.id.my_relation_service_rl)
    RelativeLayout myRelationServiceRl;
    @BindView(R.id.my_wechat_code_rl)
    RelativeLayout myWechatCodeRl;

    @OnClick({R.id.my_wechat_code_rl,R.id.setting_back_iv,R.id.my_invientory_rl, R.id.my_small_rl, R.id.my_pay_code_rl, R.id.my_update_password_rl, R.id.my_relation_service_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_invientory_rl://我的邀請
            Intent intent = new Intent(this, MyInviteActivity.class);
            startActivity(intent);
            break;
            case R.id.my_small_rl://小賬本
            Intent sba = new Intent(this, SmallBookActivity.class);
            startActivity(sba);
            break;
            case R.id.setting_back_iv:
            SettingActivity.this.finish();
            break;
            case R.id.my_pay_code_rl://支付寶收款碼
            Intent pra = new Intent(this, AlipayReceiverCodeActivity.class);
            startActivity(pra);
            break;
            case R.id.my_wechat_code_rl://微信收款码
                Intent wra = new Intent(this, WechatPayReceiverCodeActivity.class);
                startActivity(wra);
                break;
            case R.id.my_update_password_rl://修改密码
                Intent upa = new Intent(this, UpdataPasswordActivity.class);
                startActivity(upa);
                break;
            case R.id.my_relation_service_rl://联系客服
                Intent csa = new Intent(this, CustomerServiceActivity.class);
                startActivity(csa);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }
}
