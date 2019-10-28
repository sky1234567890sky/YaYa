package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/***
 * 立即购买
 * sky
 */
public class BuyNowActivity extends BaseMvpActivity<LoginModel> implements ICommonView, View.OnClickListener {

    @BindView(R.id.now_buy_iv)
    ImageView nowBuyIv;

    @BindView(R.id.now_bu_gamemoney_iv)
    ImageView nowBuGamemoneyIv;

    @BindView(R.id.buy_gamemoney_number)
    EditText buyGamemoneyNumber;

    @BindView(R.id.buy_gamemoney_remaining_quantity)
    TextView buyGamemoneyRemainingQuantity;

    @BindView(R.id.buy_min_gamemoney_remaining_quantity)
    TextView buyMinGamemoneyRemainingQuantity;

    @BindView(R.id.pay_money)
    TextView payMoney;
    @BindView(R.id.pay_money2)
    TextView payMoney2;

    @BindView(R.id.pay_way)
    TextView payWay;

    @BindView(R.id.nowbuy_commit_btn)
    TextView nowbuyCommitBtn;

    @BindView(R.id.bank_name)
    EditText bankName;

    @BindView(R.id.buy_max_gamemoney_remaining_quantity)
    TextView buyMaxGamemoneyRemainingQuantity;
    private int i ;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_now;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initListener() {
        nowBuyIv.setOnClickListener(this);
        buyGamemoneyNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 0 || s.equals("")) {
                    payMoney2.setText("0");
                    return;
                } else {
                    int i = Integer.parseInt(String.valueOf(s));
                    payMoney2.setText(10*i+"");
                }
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @OnClick({R.id.now_buy_iv, R.id.nowbuy_commit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.now_buy_iv:
                finish();
                break;
            case R.id.nowbuy_commit_btn:
                String maxNumber = buyMaxGamemoneyRemainingQuantity.getText().toString();
                String minNumber = buyMinGamemoneyRemainingQuantity.getText().toString();
                String s = buyGamemoneyNumber.getText().toString();

                int i = Integer.parseInt(s);
                if (3000<=i || i<=10000){
                    //付款人姓名上传对照
                    String name = bankName.getText().toString();

                    Intent intent = new Intent(BuyNowActivity.this, AffirmMessageActivity.class);
                    startActivity(intent);
                } else {
                    ToastUtil.showShort("请输入规定数量游戏币");
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.now_buy_iv:
                BuyNowActivity.this.finish();
                break;

                case R.id.buy_gamemoney_number:

                break;
        }
    }
}