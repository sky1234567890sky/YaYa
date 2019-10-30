package com.administrator.yaya.fragment;

import android.content.Intent;
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
import com.administrator.yaya.bean.homepage.TextHomePageData;
import com.administrator.yaya.model.LoginModel;
import com.bumptech.glide.Glide;

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

//    @BindView(R.id.marqueeView)
//    MarqueeView mMarqueeView;
//
//    @BindView(R.id.marquee)
//    SimpleMarqueeView mMarquee;
    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, 1);
    }

    @Override
    protected void initView(View inflate) {
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.c_ffffff));

    }

    @Override
    protected void initListener() {
        super.initListener();

//        final ArrayList<String> list =new  ArrayList<String>();
//        list.add("今日头条:喜讯，今日日本自愿归属中国版图");
//        list.add("头条：美国自愿捐献国库还给中国抵债");
//        list.add("中东局势好转，将会是新的战争爆发。");
////根据公告字符串列表启动轮播
//        mMarqueeView.startWithList(list);
////设置点击事件
//        mMarqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, TextView textView) {
//                ToastUtil.showShort("你点击了"+list.get(position));
//            }
//        });
//        //获取SimpleMF 跑马灯工厂  
//        SimpleMF<String> marqueeFactory = new SimpleMF<>(getActivity());
//        //MarqueeView设置工厂   
//        mMarquee.setMarqueeFactory(marqueeFactory);
//        if (null != marqueeFactory && null != mMarquee) {
//            // 设置 跑马text数据
//            marqueeFactory.setData(list);
//            //开启跑马灯  
//            mMarquee.startFlipping();
//        }
//        mMarquee.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClickListener(View mView, Object mData, int mPosition) {
//                ToastUtil.showShort("你点了第"+mPosition+"个文字");
//        }
//    });

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
                if (data.getCode() == 0 && data != null && data.getData() != null) {
                    TextHomePageData.DataBean.UserInfoBean userInfo = data.getData().getUserInfo();
                    Glide.with(getActivity()).load(userInfo.getUserHeadImg()).placeholder(R.mipmap.icon).into(mHeadlerIv);
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