package com.administrator.yaya.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.utils.RoundImageCircleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 立即购买
 * sky
 */
public class BuyNowActivity extends AppCompatActivity {

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
    @BindView(R.id.buy_max_gamemoney_remaining_quantity)
    TextView buyMaxGamemoneyRemainingQuantity;
    @BindView(R.id.pay_money)
    TextView payMoney;
    @BindView(R.id.pay_way)
    TextView payWay;
    @BindView(R.id.nowbuy_commit_btn)
    Button nowbuyCommitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        overridePendingTransition(R.anim.from_right, R.anim.no_slide);//划入

        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {


    }
    private void initListener() {


    }


    @OnClick({R.id.now_buy_iv, R.id.nowbuy_commit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.now_buy_iv://
                finish();
                break;
            case R.id.nowbuy_commit_btn:
                Intent intent = new Intent(this, AffirmMessageActivity.class);
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
