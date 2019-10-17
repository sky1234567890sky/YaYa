package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 修改密码
 */
public class UpdataPasswordActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_password);
        ButterKnife.bind(this);


    }
    @OnClick({R.id.update_back_iv, R.id.update_btv_getverificationCode, R.id.update_ok_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update_back_iv:
                finish();
                break;
            case R.id.update_btv_getverificationCode:
                break;
            case R.id.update_ok_btn:
                break;
        }
    }
}
