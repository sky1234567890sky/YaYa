package com.administrator.yaya.activity.home;

import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认信息
 */
public class AffirmMessageActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

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
    @BindView(R.id.remark_tv)
    TextView remarkTv;
    @BindView(R.id.remark_btn_copy)
    TextView remarkBtnCopy;
    @BindView(R.id.affirm_msg_look_btn)
    Button affirmMsgLookBtn;
    @BindView(R.id.bank_money)
    TextView bankMoney;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_message;
    }

    @Override
    protected void initView() {


    }

    @OnClick({R.id.affirm_msg_back_iv, R.id.receiver_copy, R.id.bank_code_number_copy, R.id.bank_copy, R.id.bank_money, R.id.remark_btn_copy, R.id.affirm_msg_look_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.affirm_msg_back_iv:
                finish();
                break;
            case R.id.receiver_copy:
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
// 将文本内容放到系统剪贴板里。
                cm.setText(receiverCopy.getText());
                ToastUtil.showShort("已复制");
                break;
            case R.id.bank_code_number_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.bank_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.bank_money:
                ToastUtil.showShort("已复制");
                break;
            case R.id.remark_btn_copy:
                ToastUtil.showShort("已复制");
                break;
            case R.id.affirm_msg_look_btn:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("affirm", 2);
                startActivity(intent);
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
