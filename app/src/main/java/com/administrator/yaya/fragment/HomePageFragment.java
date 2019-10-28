package com.administrator.yaya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.activity.home.BuyNowActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonModel;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TextHomePageData;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jaeger.library.StatusBarUtil;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class HomePageFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.title_tb)
    TextView titleTb;
    @BindView(R.id.headler_iv)
    ImageView iv;

    @BindView(R.id.home_gamemoney_name)
    TextView homeGamemoneyName;

    @BindView(R.id.home_gamemoney_price)
    TextView homeGamemoneyPrice;
    @BindView(R.id.home_buy_now_btn_tv)
    TextView homeBuyNowBtnTv;

    @BindView(R.id.tv_use)
    TextView tvUse;
    @BindView(R.id.tv_sheng)
    TextView tvSheng;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_wechat_use)
    TextView tvWechatUse;
    @BindView(R.id.tv_wechat_sheng)
    TextView tvWechatSheng;
    @BindView(R.id.tv_wechat_day)
    TextView tvWechatDay;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA,1);
    }
    @Override
    protected void initView(View inflate) {
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.c_ffffff));

    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                TextHomePageData data = (TextHomePageData) t[0];
                if (data.getCode()==0 || data!=null || data.getData()!=null) {
                    TextHomePageData.DataBean.UserInfoBean userInfo = data.getData().getUserInfo();
                    Glide.with(this).load(userInfo.getUserHeadImg()).placeholder(R.mipmap.icon).into(iv);

                }

                break;
        }
    }
    @OnClick({ R.id.home_buy_now_btn_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_buy_now_btn_tv:
                Intent intent = new Intent(getActivity(), BuyNowActivity.class);
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
//        ToastUtil.showShort(e.getMessage());
    }

    @Override
    public void onResume() {
        super.onResume();
        registerNetWorkStatus();
    }

    private void registerNetWorkStatus() {

    }
}
