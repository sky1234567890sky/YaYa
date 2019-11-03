package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TestBuyCom;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.makeramen.roundedimageview.RoundedImageView;

import org.raphets.roundimageview.RoundImageView;

import butterknife.BindView;
import butterknife.OnClick;
/***
 * 立即购买
 * sky
 */
public class BuyNowActivity extends BaseMvpActivity<LoginModel> implements ICommonView, View.OnClickListener {

    @BindView(R.id.now_buy_iv)
    ImageView nowBuyIv;

    @BindView(R.id.buy_comName)
    TextView mComName;
    @BindView(R.id.buy_comPrice)
    TextView mComPrice;

    @BindView(R.id.now_bu_gamemoney_iv)
    RoundedImageView nowBuGamemoneyIv;

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
    @BindView(R.id.pay_money2)
    TextView payMoney2;

    @BindView(R.id.pay_way)
    TextView payWay;

    @BindView(R.id.nowbuy_commit_btn)
    TextView nowbuyCommitBtn;

    @BindView(R.id.bank_name)
    EditText bankName;

    private int comPurchaseNumMax;
    private int comPurchaseNumMin;
    private int comPrice;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();

        mPresenter.getData(ApiConfig.TEXT_BUY_COM);
    }

    @Override
    public void onError(int whichApi, Throwable e) {
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_BUY_COM:

                TestBuyCom  testBuyCom= (TestBuyCom) t[0];

            if (testBuyCom.getCode()==0 && testBuyCom.getData()!=null){

                String comImg = testBuyCom.getData().getComImg();

                Glide.with(this).load(comImg).apply(new RequestOptions().centerCrop()).into(nowBuGamemoneyIv);

                String comName = testBuyCom.getData().getComName();//货物名称

                mComName.setText(comName);
                //货物单价
                comPrice = testBuyCom.getData().getComPrice();

                mComPrice.setText("游戏币单价:￥"+ comPrice);

                int comInventory = testBuyCom.getData().getComInventory();//库存数量

                buyGamemoneyRemainingQuantity.setText("剩余数量:￥"+comInventory);
                //最大购买量
                comPurchaseNumMax = testBuyCom.getData().getComPurchaseNumMax();

                //最小购买量
                comPurchaseNumMin = testBuyCom.getData().getComPurchaseNumMin();

                buyMinGamemoneyRemainingQuantity.setText("最小购买数量："+comPurchaseNumMin);

                buyMaxGamemoneyRemainingQuantity.setText("最大购买数量："+comPurchaseNumMax);

            }else{
                ToastUtil.showShort(testBuyCom.getMsg());
            }
                break;
        }
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
                String s1 = String.valueOf(s);
                if (s1.isEmpty()){
                    payMoney2.setText("0");
                    return;
                }

                char c = s1.charAt(0);
                Log.i("Taaaa", c + "");
                int i = Integer.parseInt(String.valueOf(s));

                if (s.length() <= 0 || s.equals("")) {
                    payMoney2.setText("0");
                    return;
                }else{
                    payMoney2.setText(i * 123 + "");
                }
                int comPurchaseNumMax =10000;
                if (comPurchaseNumMax>i){
                    buyGamemoneyRemainingQuantity.setText(comPurchaseNumMax-i+"");
//                    if (comPurchaseNumMax-i<0){
//                        buyGamemoneyRemainingQuantity.setText("0");
//                    }
                }else{
                    ToastUtil.showLong("已超过最大购买数");
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
                String s = buyGamemoneyNumber.getText().toString();//货物数量
                String paymoey = payMoney2.getText().toString().trim();//付款金额
                if (!s.isEmpty()) {
                    int i = Integer.parseInt(s);
                    if (comPurchaseNumMin <= i && i <= comPurchaseNumMax) {
                        //付款人姓名上传对照
                        String name = bankName.getText().toString().trim();
                        if (!name.isEmpty()) {
                            Intent intent = new Intent(BuyNowActivity.this, AffirmMessageActivity.class);
                            intent.putExtra("bankName",name);
                            intent.putExtra("commodityAmount",s);
                            intent.putExtra("commodityPrice",paymoey);
                            startActivity(intent);
                        }
                    }else {
                        ToastUtil.showShort("请输入规定数量游戏币数量");
                    }
                }else {
                    ToastUtil.showShort("请输入购买数量");
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
                finish();
                break;
        }
    }
}