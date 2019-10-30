package com.administrator.yaya.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.my.MyIncomeActivity;
import com.administrator.yaya.activity.my.MyInviteActivity;
import com.administrator.yaya.activity.my.PersonalDatActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.activity.my.SystemMessagesActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TextHomePageData;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.ChangTvSizeUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.glideutils.GlideEngine;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.get_gamemoney_tv)
    TextView getGamemoneyTv;
    @BindView(R.id.all_gamemoney_tv)
    TextView allGamemoneyTv;
    @BindView(R.id.inventory_money)
    TextView inventoryMoney;

    @BindView(R.id.system_msg_iv)
    ImageView systemMsgIv;
    @BindView(R.id.setting_iv)
    ImageView settingIv;
    @BindView(R.id.iv)
    ImageView iv;

    @BindView(R.id.my_name_tv)
    TextView myNameTv;
    @BindView(R.id.my_name_state_tv)
    TextView myNameStateTv;
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
    @BindView(R.id.my_ll)
    RelativeLayout myLl;
    @BindView(R.id.wire)
    View wire;
    @BindView(R.id.my_right_ll)
    LinearLayout myRightLl;
    private TextHomePageData.DataBean.UserInfoBean userInfo;
    private TextHomePageData.DataBean databean;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.c_ffffff));
//        if (databean.getUserEarningsToday()!=null) {SpannableString spannableString = ChangTvSizeUtils.changTVsize((Integer.parseInt( databean.getUserEarningsToday()) + Integer.parseInt("0.00"))+"");
//        getGamemoneyTv.setText(spannableString);}
//        SpannableString getInventory2 = ChangTvSizeUtils.changTVsize((userInfo.getUserEarningsTotal()+Integer.parseInt("0.00"))+"");
//        if (getInventory2!=null)allGamemoneyTv.setText(getInventory2);
    }

    @Override
    protected void initData() {
        getPermission();//权限
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA,1);
    }

    @OnClick({R.id.system_msg_iv, R.id.setting_iv, R.id.my_ll,R.id.my_right_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.system_msg_iv://系統消息
                Intent intent = new Intent(getActivity(), SystemMessagesActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_iv:
                Intent sa = new Intent(getActivity(), SettingActivity.class);
                startActivity(sa);
                break;
            case R.id.my_ll:
                Intent pd = new Intent(getActivity(), PersonalDatActivity.class);
                pd.putExtra("NickName",userInfo.getUserNickName());
                startActivity(pd);
                break;
                case R.id.my_right_ll:
                Intent myincome = new Intent(getActivity(), MyIncomeActivity.class);
                startActivity(myincome);
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

    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                TextHomePageData data = (TextHomePageData) t[0];
                databean = data.getData();
                userInfo = databean.getUserInfo();
                if (data.getCode() == 0 && userInfo != null && databean !=null) {
                    String userHeadImg = userInfo.getUserHeadImg();

                    //保存图片 跟 昵称  没网也能显示
                    SharedPrefrenceUtils.saveString(getActivity(),NormalConfig.HEADLER_IMAGEVIEW,userHeadImg);
                    SharedPrefrenceUtils.saveString(getActivity(),NormalConfig.USER_NICK,userInfo.getUserNickName());

                    String head_portrait = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW);

//                    GlideEngine.loadImage(iv,"http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg");
//
                    RequestOptions requestOptions = new RequestOptions().centerCrop();

                    Glide.with(getContext()).load(userHeadImg).apply(requestOptions).placeholder(R.mipmap.icon).into(iv);

//                  福利  "http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg"
                    myNameTv.setText(userInfo.getUserName());
                    getGamemoneyTv.setText(databean.getUserEarningsToday()+"");//今日收益
                    allGamemoneyTv.setText(userInfo.getUserEarningsTotal()+"");//累计收益

                    tvUse.setText(userInfo.getZfbEd()+"");//支付宝已使用额度
                    tvWechatUse.setText(userInfo.getWxEd()+"");//微信已使用额度
                }

                break;
        }
    }
}
