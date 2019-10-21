package com.administrator.yaya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.BuyNowActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomePageFragment extends Fragment {

    @BindView(R.id.title_tb)
    TextView titleTb;
    @BindView(R.id.iv)
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
    Unbinder unbinder;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initListener();
        return view;
    }

    private void initListener() {

    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
}
