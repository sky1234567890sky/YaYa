package com.administrator.yaya.activity.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TestBuyCom;
import com.administrator.yaya.bean.orderform.TestToOrderStock;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;

/***
 * 立即购买
 * sky
 */
public class BuyNowActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
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

    @BindView(R.id.buy_gamemoney_shengyu)
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

    @BindView(R.id.now_buy_yongjin_tv)//使用佣金
            TextView mShiyongYongjinTv;
    @BindView(R.id.buy_now_switch)//开关
            Switch mSwitch;
    @BindView(R.id.yiyong_yongyin_tv)//-使用佣金
            TextView mShiyongYongjin;

    private int comPurchaseNumMax;
    private int comPurchaseNumMin;
    private int comInventory;
    private double comPrice;
    private String bankName1;
    private String payeeName;
    private String bankCard;
    private String remark;
    private String comMoney;
    private String userId;
    private TestBuyCom.DataBean data;
    private double index;
    private int flagType = 1;
    private double yongjin = 0;
    private double commodityPriceDeduction;
    private String token;

    @Override
    protected void initView() {
        super.initView();
        boolean aBoolean = SharedPrefrenceUtils.getBoolean(BuyNowActivity.this, NormalConfig.isChecket);
//        mSwitch.setChecked(aBoolean);

    }

    @Override
    protected void initData() {
        super.initData();

        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
        int anInt = Integer.parseInt(userId);
        mPresenter.getData(ApiConfig.TEXT_BUY_COM, anInt, token);
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_BUY_COM:
                TestBuyCom testBuyCom = (TestBuyCom) t[0];

                data = testBuyCom.getData();

                if (testBuyCom.getMsg().equals(mApplication.SignOut)) {



                    Toast.makeText(this, "您的账号正在其他设备登录!请重新登陆！", Toast.LENGTH_SHORT).show();

                    Intent login = new Intent(this, LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getApplicationContext(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getApplicationContext(), NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(login);

                    BuyNowActivity.this.finish();
                }

                if (testBuyCom.getCode() == 0 && !testBuyCom.getMsg().equals(mApplication.SignOut)) {

                    Log.i("tag", "立即購買====》: " + testBuyCom.toString());
                    commodityPriceDeduction = data.getCommodityPriceDeduction();

                    String comImg = testBuyCom.getData().getComImg();

                    Glide.with(this).load(comImg).apply(new RequestOptions().centerCrop()).into(nowBuGamemoneyIv);

                    String comName = testBuyCom.getData().getComName();//货物名称

                    mComName.setText(comName);
                    //货物单价
                    comPrice = testBuyCom.getData().getComPrice();
                    mComPrice.setText("游戏币单价:￥" + comPrice);
                    //库存数量
                    comInventory = testBuyCom.getData().getComInventory();
                    buyGamemoneyRemainingQuantity.setText("剩余数量:￥" + comInventory);
                    //最大购买量
                    comPurchaseNumMax = testBuyCom.getData().getComPurchaseNumMax();
                    //最小购买量
                    comPurchaseNumMin = testBuyCom.getData().getComPurchaseNumMin();
                    buyMinGamemoneyRemainingQuantity.setText("最小购买数量：" + comPurchaseNumMin);
                    buyMaxGamemoneyRemainingQuantity.setText("最大购买数量：" + comPurchaseNumMax);
                    //传值
//                EventBus.getDefault().postSticky(comInventory);   //发送时间
                    mShiyongYongjinTv.setText("￥：" + data.getCommodityPriceDeduction());
                }

                break;
            //提交订单
            case ApiConfig.TEXT_ORDER_STOCK:

                TestToOrderStock testToOrderStock = (TestToOrderStock) t[0];
                //查看信息   非提交订单
                if (testToOrderStock.getMsg().equals(mApplication.SignOut)) {

                    ToastUtil.showLong("您的账号正在其他设备登录!请重新登陆！");

                    Intent login = new Intent(this, LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getApplicationContext(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getApplicationContext(), NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(login);

                    BuyNowActivity.this.finish();
                }
                if (testToOrderStock.getCode() == 0 && testToOrderStock.getData() != null && !testToOrderStock.getMsg().equals(mApplication.SignOut)) {

                    TestToOrderStock.DataBean data = testToOrderStock.getData();
                    //银行
                    bankName1 = data.getBankName();
                    //收款人姓名
                    payeeName = data.getPayeeName();
                    //货物数量
                    int gaId = data.getGaId();
                    //金额
                    comMoney = data.getComMoney();
                    //银行卡号
                    bankCard = data.getBankCard();
                    //备注信息
                    remark = data.getRemark();
//                    bankYinhang.setText(bankName + "");
//                    receiverName.setText(payeeName + "");
//                    bankCodeNumber.setText(bankCard + "");
//                    moneyTv.setText(data.getComMoney());
//                    mRemarkTv.setText(remark + "");

                    Intent intent = new Intent(BuyNowActivity.this, AffirmMessageActivity.class);
                    if (!TextUtils.isEmpty(payeeName) || !TextUtils.isEmpty(bankName1) || !TextUtils.isEmpty(comMoney)
                            || !TextUtils.isEmpty(bankCard) || !TextUtils.isEmpty(remark)) {
                        intent.putExtra("bankName", bankName1);//银行
                        intent.putExtra("payeeName", payeeName);//收款人姓名
                        intent.putExtra("comMoney", comMoney);//收款金额
                        intent.putExtra("bankCard", bankCard);//
                        intent.putExtra("remark", remark);//备注

                        intent.putExtra("name2",bankName.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                }
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_now;
    }
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initListener() {
        buyGamemoneyNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //打开
                if (mSwitch.isChecked() == true) {
                    mSwitch.setChecked(false);
                }

                String tv = String.valueOf(s);
                if (tv.isEmpty()) {
                    payMoney2.setText("0");
                    return;
                }
                char tv_money = tv.charAt(0);
                if (s.length() <= 0 || s.equals("")) {
                    payMoney2.setText("0");
                    return;
                } else {
                    int i = Integer.parseInt(String.valueOf(s));
                    index = (i * comPrice);//输入数量  *  单价
                    payMoney2.setText(i * comPrice + "");
                }
                int i = Integer.parseInt(String.valueOf(s));
                //最大数量
                if (comPurchaseNumMax >= i) {
                    buyGamemoneyRemainingQuantity.setText("剩余数量：" + (comInventory - i));
                } else {
                    ToastUtil.showLong("已超过最大购买数");
                    //禁止输入
                    buyGamemoneyNumber.setInputType(InputType.TYPE_NULL);//来禁止手机软键盘
                    buyGamemoneyNumber.setInputType(InputType.TYPE_CLASS_TEXT);//来开启软键盘
                }
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //监听是否为空
                if (TextUtils.isEmpty(buyGamemoneyNumber.getText().toString().trim())) {

                    ToastUtil.showLong("请输入购买游戏币数量");

                    mSwitch.setChecked(false);

                    mShiyongYongjin.setText("- " + 0);

                    payMoney2.setText("0");

                } else {
//                    mSwitch.setClickable(true);
                    if (isChecked == true) {
                        flagType = 2;
                        yongjin = commodityPriceDeduction;

                        if (commodityPriceDeduction > 0) {
                            mShiyongYongjin.setText("- " + commodityPriceDeduction);
                            //应付金额 - 佣金
                            payMoney2.setText("" + (index - commodityPriceDeduction));
                        }else{
                            ToastUtil.showLong("暂无佣金可使用");
                            mSwitch.setChecked(false);
                        }
                    } else {//未选中
                        yongjin = 0;
                        flagType = 1;
                        mShiyongYongjin.setText("- " + 0);
                        payMoney2.setText("" + index);
                    }
                    //佣金
                }
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
                userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
                String s = buyGamemoneyNumber.getText().toString().trim();//货物数量
                String paymoey = payMoney2.getText().toString().trim();//付款金额
                if (!s.isEmpty()) {
                    int i = Integer.parseInt(s);
                    if (comPurchaseNumMin <= i && i <= comPurchaseNumMax) {
                        //付款人姓名上传对照
                        String name = bankName.getText().toString().trim();
                        Double commodityPriceDeduction = data.getCommodityPriceDeduction();
                        if (!name.isEmpty()) {
                            //在此请求网络数据 传到  确认付款 页面(在此解析讲数据传值)（提交数据的  不是 查看详情的）
                            mPresenter.getData(ApiConfig.TEXT_ORDER_STOCK, Integer.parseInt(userId), token, paymoey, name, s, yongjin, flagType);
                            //==================================================》
                        } else {
                            ToastUtil.showShort("请输入付款人姓名");
                        }
                    } else {
                        ToastUtil.showShort("请输入规定数量游戏币数量");
                    }
                } else {
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
    protected void onPause() {
        super.onPause();
        initData();
    }
    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }
}