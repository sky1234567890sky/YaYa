package com.administrator.yaya.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 确认信息
 */
public class AffirmMessageActivity extends AppCompatActivity {

    @BindView(R.id.affirm_msg_back_iv)
    ImageView affirmMsgBackIv;
    @BindView(R.id.receiver_name)
    TextView receiverName;
    @BindView(R.id.receiver_copy)
    TextView receiverCopy;
    @BindView(R.id.bank_code_number)
    TextView bankCodeNumber;
    @BindView(R.id.bank_code_number_copy)
    TextView bankCodeNumberCopy;
    @BindView(R.id.bank_yinhang)
    TextView bankYinhang;
    @BindView(R.id.bank_copy)
    TextView bankCopy;
    @BindView(R.id.money_tv)
    TextView moneyTv;
    @BindView(R.id.monry_btn_copy)
    TextView monryBtnCopy;
    @BindView(R.id.remark_tv)
    TextView remarkTv;
    @BindView(R.id.remark_btn_copy)
    TextView remarkBtnCopy;
    @BindView(R.id.affirm_msg_look_btn)
    Button affirmMsgLookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affirm_message);
        overridePendingTransition(R.anim.from_right, R.anim.no_slide);//划入
        ButterKnife.bind(this);
    }

    @OnClick({R.id.affirm_msg_back_iv, R.id.receiver_copy, R.id.bank_code_number_copy, R.id.bank_copy, R.id.monry_btn_copy, R.id.remark_btn_copy, R.id.affirm_msg_look_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.affirm_msg_back_iv:
                finish();
                break;
            case R.id.receiver_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.bank_code_number_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.bank_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.monry_btn_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.remark_btn_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.affirm_msg_look_btn:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("affirm",2);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_slide, R.anim.out_right);//划出
    }
}
