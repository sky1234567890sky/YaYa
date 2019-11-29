package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.activity.my.MyIncomeActivity;
import com.administrator.yaya.activity.my.PersonalDatActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.activity.my.SystemMessagesActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.convert.BaseLazyLoadFragment;
import com.administrator.yaya.bean.homepage.TestHomePageData;
import com.administrator.yaya.bean.my.TestUpdateUserNew;
import com.administrator.yaya.bean.my.TestUserNowMsg;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * 我的界面
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
    @BindView(R.id.my_tv_day)//支付宝  每日限度
            TextView tvDay;
    @BindView(R.id.tv_wechat_use)
    TextView tvWechatUse;
    @BindView(R.id.tv_wechat_sheng)
    TextView tvWechatSheng;
    @BindView(R.id.my_tv_wechat_day)
    TextView tvWechatDay;
    @BindView(R.id.my_hongdian)
    TextView mMy_hongdian;
    @BindView(R.id.my_ll)
    RelativeLayout myLl;
    @BindView(R.id.wire)
    View wire;

    @BindView(R.id.my_right_ll)
    LinearLayout myRightLl;
    private TestHomePageData.DataBean.UserInfoBean userInfo;
    private TestHomePageData.DataBean databean;
    private String userId;
    private String token;
    private OrderFormkFragment parentFragment1;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser == true) {
            initData();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.c_ffffff));
//        if (databean.getUserEarningsToday()!=null) {SpannableString spannableString = ChangTvSizeUtils.changTVsize((Integer.parseInt( databean.getUserEarningsToday()) + Integer.parseInt("0.00"))+"");
//        getGamemoneyTv.setText(spannableString);}
//        SpannableString getInventory2 = ChangTvSizeUtils.changTVsize((userInfo.getUserEarningsTotal()+Integer.parseInt("0.00"))+"");
//        if (getInventory2!=null)allGamemoneyTv.setText(getInventory2);
//        getFragment();
    }

    private void getFragment() {
        //获取
        MainActivity activity = (MainActivity) getActivity();
        TextView hongdian = activity.findViewById(R.id.hongdian);
        if (hongdian != null) {
            if (hongdian.getVisibility() == View.VISIBLE) {
                mMy_hongdian.setVisibility(View.VISIBLE);
            } else {
                mMy_hongdian.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void initData() {
//        showLoadingDialog();
//        String urlPath = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW);
//        if (urlPath!=null){
//            Glide.with(getContext()).load(urlPath).apply(new RequestOptions().circleCrop()).placeholder(R.mipmap.icon).into(iv);
//        }
//        getPermission();//权限

        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);

        token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);
        //消息列表数据
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId), token);

        //消息未读
        mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);

        //读取消息
    }
    @OnClick({R.id.system_msg_iv, R.id.setting_iv, R.id.my_ll, R.id.my_right_ll, R.id.my_left_ll})
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
                startActivityForResult(pd, 11);
                break;
            case R.id.my_right_ll:
                Intent myincome = new Intent(getActivity(), MyIncomeActivity.class);
                startActivity(myincome);
                break;
            case R.id.my_left_ll:
                Intent myincome1 = new Intent(getActivity(), MyIncomeActivity.class);
                startActivity(myincome1);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == 12) {//结果码

            String nickName = data.getStringExtra("sky");
            if (nickName != null) {
                myNameTv.setText(nickName);
            }
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
//        hideLoadingDialog();
        switch (whichApi) {
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                TestHomePageData data = (TestHomePageData) t[0];
                //1
                if (data.getMsg().equals(SignOut)) {

                    Toast.makeText(getActivity(), "您的当前账户已在其他设备登陆，为安全起见，请及时修改密码或重新登陆！", Toast.LENGTH_SHORT).show();

                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();

                } else if (data.getCode() == 0 && data.getData() != null && data.getData().getUserInfo() != null && !data.getMsg().equals(SignOut)) {
                    databean = data.getData();
                    userInfo = databean.getUserInfo();
//                    tvDay.setText(""+);//每日限額
//                    tvWechatDay.setText(""+);
//                    commodity:  货物信息
                    TestHomePageData.DataBean.CommodityBean commodity = databean.getCommodity();
//                    comName 货物名称
                    String comName = commodity.getComName();
//                    comPrice 商品价格
                    double comPrice = commodity.getComPrice();
//                    comImg 商品图片
                    String comImg = commodity.getComImg();
//                    userInfo: 用户基本信息
//                    userName 用户姓名
                    String userName = userInfo.getUserName();
                    String userHeadImg = userInfo.getUserHeadImg();
//                    userNickName 昵称
//                    String userNickName = userInfo.getUserNickName();
//                    userEarningsTotal 总收益
                    allGamemoneyTv.setText(userInfo.getUserEarningsTotal() + "");//總收益
//                    zfbEd 支付宝已使用额度
//                    wxEd 微信已使用额度
//                    userEarningsToday 今日收益
                    String userEarningsToday = databean.getUserEarningsToday();
                    if (userEarningsToday == null) getGamemoneyTv.setText("0");//今日收益
//                    userEarningsToday
                    else getGamemoneyTv.setText(userEarningsToday);
                    //保存图片 跟 昵称
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW, userHeadImg);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_NICK, userName);
                    myNameTv.setText(userName);//用户名称

                    tvUse.setText(userInfo.getZfbEd() + "");//支付宝已使用额度
                    tvWechatUse.setText(userInfo.getWxEd() + "");//微信已使用额度

                    String alipay_residue = tvDay.getText().toString().trim();//获取支付宝额度
                    int alipayInt = Integer.parseInt(alipay_residue);
                    String wechat_residue = tvWechatSheng.getText().toString().trim();//获取微信额度
                    int wechatInt = Integer.parseInt(alipay_residue);

                    //剩余额度
                    if (alipayInt >= userInfo.getZfbEd())
                        tvSheng.setText((alipayInt - userInfo.getZfbEd()) + "");
                    else ToastUtil.showShort("已达到每日限度");

                    if (wechatInt >= userInfo.getWxEd())
                        tvWechatSheng.setText((wechatInt - userInfo.getWxEd()) + "");
                    else ToastUtil.showShort("已达到每日限度");

                    RequestOptions requestOptions = new RequestOptions().centerCrop();

                    Glide.with(getContext()).load(userHeadImg).apply(requestOptions).placeholder(R.mipmap.icon).into(iv);

//                    myNameTv.setText();

                }
                break;

            case ApiConfig.TEST_GET_USERNOW_MSG:
                TestUserNowMsg testUserNowMsg = (TestUserNowMsg) t[0];
//                结果：1有	2无
                if (testUserNowMsg.getMsg().equals(SignOut)) {

                    ToastUtil.showLong(R.string.username_login_hint + "");

                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();

                } else if (testUserNowMsg.getCode() == 0) {

                    String msg = testUserNowMsg.getMsg();

                    int data1 = testUserNowMsg.getData();

                    Log.i("tag", "消息读了吗=====> " + data1);

                    if (data1 == 2) {//默认不显示
                        mMy_hongdian.setVisibility(View.GONE);
                    } else if (data1 == 1) {//有
                        //显示
                        mMy_hongdian.setVisibility(View.VISIBLE);
                        //通知有新消息
                    }
                }
                break;


            case ApiConfig.TEST_UPDATE_USERNEW:

                TestUpdateUserNew testUpdateUserNew = (TestUpdateUserNew) t[0];
                if (testUpdateUserNew.getMsg().equals(SignOut)) {

                    ToastUtil.showLong(R.string.username_login_hint + "");

                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();

                }else if (testUpdateUserNew.getCode()==0){
                    //已读取  隐藏
                    ToastUtil.showLong(testUpdateUserNew.getMsg());

                    mMy_hongdian.setVisibility(View.GONE);

                }
                break;
        }
    }

    @Override
    public void onResume() {//返回时走
        super.onResume();
//        getFragment();
        Log.i("tag", "onResume刷新数据1:" + "");
        initData();
    }

    @Override
    public void onPause() {//点击执行 先走
        super.onPause();
//        Log.i("tag", "onPause刷新数据12:" + "");
//        if (mMy_hongdian!=null){
//            mMy_hongdian.setVisibility(View.GONE);
//        }
//        getFragment();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity() != null && !hidden) {
//            Log.i("tag", "刷新数据2: ");
//            getFragment();
            initData();
        }
    }
}