package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.BuyNowActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TestHomePageData;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.OnClick;
public class HomePageFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.title_tb)
    TextView titleTb;
    @BindView(R.id.headler_iv)
    ImageView mHeadlerIv;
    @BindView(R.id.home_gamemoney_name)
    TextView homeGamemoneyName;
    @BindView(R.id.home_gamemoney_price)
    TextView homeGamemoneyPrice;
    @BindView(R.id.home_buy_now_btn_tv)
    TextView homeBuyNowBtnTv;
    @BindView(R.id.homepage_use)
    TextView tvUse;
    @BindView(R.id.homepage_sheng)
    TextView tvSheng;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_wechat_use)
    TextView tvWechatUse;
    @BindView(R.id.tv_wechat_sheng)
    TextView tvWechatSheng;
    @BindView(R.id.tv_wechat_day)
    TextView tvWechatDay;
    private TestHomePageData.DataBean databean;
    private TestHomePageData.DataBean.UserInfoBean userInfo;
    private String userId;

    @Override
    protected void initData() {
        super.initData();
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId));
    }
    @Override
    protected void initListener() {
        super.initListener();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                TestHomePageData data = (TestHomePageData) t[0];
                if (data.getCode() == 0) {
                        databean = data.getData();
                        userInfo = databean.getUserInfo();
                        Log.i("tag", "首頁==》: " + data.toString());
//                    commodity:  货物信息
                        TestHomePageData.DataBean.CommodityBean commodity = databean.getCommodity();
//                    comName 货物名称
                        String comName = commodity.getComName();
                        homeGamemoneyName.setText(comName);
//                    comImg 商品图片
                        String comImg = commodity.getComImg();
                        Glide.with(getContext()).load(comImg).placeholder(R.mipmap.icon).into(mHeadlerIv);
//                    comPrice 商品价格
                        double comPrice1 = commodity.getComPrice();
                        homeGamemoneyPrice.setText("进货价￥：" + comPrice1);
//                    zfbEd 支付宝已使用额度
                        tvUse.setText(userInfo.getZfbEd() + "");//支付宝已使用额度
//                    wxEd 微信已使用额度
                        tvWechatUse.setText(userInfo.getWxEd() + "");//微信已使用额度
                        String tvday = tvDay.getText().toString();
                        tvSheng.setText((Integer.parseInt(tvday) - userInfo.getZfbEd()) + "");//支付宝剩余额度
//                    userEarningsToday 今日收益
                        String tvwechatday = tvWechatDay.getText().toString();
                        tvWechatSheng.setText((Integer.parseInt(tvwechatday) - userInfo.getWxEd()) + "");//微信剩余额度
//                    userInfo: 用户基本信息
//                    userName 用户姓名
//                    userNickName 昵称
//                    userEarningsTotal 总收益
                }
                break;
        }
    }

    @OnClick({R.id.home_buy_now_btn_tv})
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
    }
}