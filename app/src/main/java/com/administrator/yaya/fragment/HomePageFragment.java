package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.MainActivity;
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
import com.squareup.haha.perflib.Main;

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
//    @BindView(R.id.homepage_use)
//    TextView tvUse;
//    @BindView(R.id.homepage_sheng)
//    TextView tvSheng;
//    @BindView(R.id.tv_day)
//    TextView tvDay;
//
//    @BindView(R.id.tv_wechat_use)
//    TextView tvWechatUse;
//    @BindView(R.id.tv_wechat_sheng)
//    TextView tvWechatSheng;
//    @BindView(R.id.tv_wechat_day)
//    TextView tvWechatDay;

    private String userId;
    private String token;
    private ImageView img;
    private ImageView img_ying;
    private String isYingYe;

    @SuppressLint("WrongViewCast")
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);

//        if (getActivity() != null) {
//            img = getActivity().findViewById(R.id.close_business_iv);//歇业
//            //营业
//            img_ying = getActivity().findViewById(R.id.dobusiness_iv);
//        }

        isYingYe = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.isYingYe);


    }
    @Override
    protected void initData() {
        super.initData();
//        showLoadingDialog();
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);

//        Log.i("tag", "首页: "+userId+"<||>"+token);
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId), token);

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
//        hideLoadingDialog();
        switch (whichApi) {
            case ApiConfig.TEXT_HOMEPAGE_DATA:

                TestHomePageData data = (TestHomePageData) t[0];
                if (data.getMsg().equals(SignOut)) {
                    Toast.makeText(getActivity(), R.string.username_login_hint + "", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(getActivity(), LoginActivity.class);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");
                    startActivity(login);
                    getActivity().finish();
                } else if (data.getCode() == 0 && data.getData() != null) {
                    TestHomePageData.DataBean databean = data.getData();
                    TestHomePageData.DataBean.UserInfoBean userInfo = databean.getUserInfo();
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
                    homeGamemoneyPrice.setText("进货价:￥" + comPrice1);

//                    1.开始营业（歇业）   2.正在营业（营业中）
                    int doBusineseStatus = userInfo.getDoBusineseStatus();

                    Log.i("tag", "HomePager是否营业: " + doBusineseStatus);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.isYingYe, String.valueOf(doBusineseStatus));


//                    if (doBusineseStatus==1){//歇业
//                        homeBuyNowBtnTv.setBackground(getResources().getDrawable(R.drawable.confirm_bg_shape));
//                        homeBuyNowBtnTv.setTextColor(getResources().getColor(R.color.c_ccc));
//                        homeBuyNowBtnTv.setEnabled(Boolean.FALSE);//不启用按钮
//                    }else {
//                        homeBuyNowBtnTv.setBackground(getResources().getDrawable(R.drawable.ripple_btn));
//                        homeBuyNowBtnTv.setTextColor(getResources().getColor(R.color.c_ffffff));
//                        homeBuyNowBtnTv.setEnabled(Boolean.TRUE);//启用按钮
//                    }
//                    zfbEd 支付宝已使用额度
//                        tvUse.setText(userInfo.getZfbEd() + "");//支付宝已使用额度
////                    wxEd 微信已使用额度
//                        tvWechatUse.setText(userInfo.getWxEd() + "");//微信已使用额度
//                        String tvday = tvDay.getText().toString();
//                        tvSheng.setText((Integer.parseInt(tvday) - userInfo.getZfbEd()) + "");//支付宝剩余额度
////                    userEarningsToday 今日收益
//                        String tvwechatday = tvWechatDay.getText().toString();
//                        tvWechatSheng.setText((Integer.parseInt(tvwechatday) - userInfo.getWxEd()) + "");//微信剩余额度
//                    userInfo: 用户基本信息
//                    userName 用户姓名
//                    userNickName 昵称
//                    userEarningsTotal 总收益


//                    userCredit  信誉额度
//                    userAllOrderCount 用户诚信代售次数
                    int userCredit = userInfo.getUserCredit();
//                    int userAllOrderCount = userInfo.getUserAllOrderCount();
                    int userAllOrderCount = databean.getUserAllOrderCount();

                }else{
                    ToastUtil.showLong(data.getMsg());
                }
                break;
        }
    }

    @OnClick({R.id.home_buy_now_btn_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_buy_now_btn_tv:
                //歇业
                if (isYingYe.equals("2")){
                    Intent intent = new Intent(getActivity(), BuyNowActivity.class);
                    startActivity(intent);

                }else{
                    ToastUtil.showLong("请停止营业后再购买商品！");

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
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong( getResources().getString(R.string.error));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity() != null && !hidden) {
//            Log.i("tag", "刷新数据2: ");
            initData();
        }
    }
}