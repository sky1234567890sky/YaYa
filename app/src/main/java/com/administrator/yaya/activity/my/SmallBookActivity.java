package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_small_book;
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
