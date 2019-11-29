package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.home.AffirmMessageActivity;
import com.administrator.yaya.activity.home.ConfirmYingyeActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestSmallBook;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 小账本
 */
public class SmallBookActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.small_book_back_iv)
    ImageView smallBookBackIv;
    @BindView(R.id.small_book_pay_money_tv)
    TextView smallBookPayMoneyTv;
    @BindView(R.id.small_book_pay_money_iv)
    TextView smallBookPayMoneyIv;

    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.tv_wechat_use)
    TextView tvWechatUse;
    @BindView(R.id.tv_wechat_day)
    TextView tvWechatDay;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.small_book_tv_use_money)
    TextView smallBookTvUseMoney;
    @BindView(R.id.tv_day)
    TextView tvDay;
    private String userId;
    private String token;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_small_book;
    }

    @Override
    protected void initData() {
        super.initData();

        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);
        mPresenter.getData(ApiConfig.TEST_SMALLBOOK, Integer.parseInt(userId), token);
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_SMALLBOOK:
                TestSmallBook testSmallBook = (TestSmallBook) t[0];
                if (testSmallBook.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong("您的账号正在其他设备登录,请重新登陆！");
                    Intent intent = new Intent(this, LoginActivity.class);

                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(intent);

                    finish();
                }
                if (testSmallBook.getCode() == 0 && !testSmallBook.getMsg().equals(mApplication.SignOut)) {
                    TestSmallBook.DataBean data = testSmallBook.getData();

                    if (data==null){
                        return;
                    }else {
                        //                    moneyToday		今日付款
                        double moneyToday = data.getMoneyToday();
//                    moneyHistory	历史付款
                        double moneyHistory = data.getMoneyHistory();
                        if (moneyHistory < 0) {
                            smallBookPayMoneyIv.setText("0.0");
                        } else {
                            smallBookPayMoneyIv.setText(moneyHistory + "");
                        }
                        if (moneyToday < 0) {
                            smallBookPayMoneyTv.setText("0.0");
                        } else {
                            smallBookPayMoneyTv.setText(moneyToday + "");
                        }
                        int moneyZfbToday = data.getMoneyZfbToday();
                        tvWechatUse.setText(moneyZfbToday + "");
                        tvWechatDay.setText(""+data.getMoneyZfbHistory());
                        smallBookTvUseMoney.setText(data.getMoneyWxToday()+"");
                        tvDay.setText(data.getMoneyWxHistory() + "");
                    }
                }
                break;
        }
    }

    @OnClick({R.id.small_book_back_iv, R.id.small_book_pay_money_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.small_book_back_iv:
                SmallBookActivity.this.finish();
                break;
            case R.id.small_book_pay_money_tv:

                break;
        }
    }
}
