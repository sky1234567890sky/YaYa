package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
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
import com.administrator.yaya.activity.my.RankingListActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.activity.my.SystemMessagesActivity;
import com.administrator.yaya.activity.my.XinyufenRacordActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TestHomePageData;
import com.administrator.yaya.bean.my.TestUpdateUserNew;
import com.administrator.yaya.bean.my.TestUserNowMsg;
import com.administrator.yaya.custom.CircularProgressView;
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

    @BindView(R.id.get_gamemoney_tv)//今日收益
            TextView getGamemoneyTv;
    @BindView(R.id.all_gamemoney_tv)//本月累计收益
            TextView allGamemoneyTv;

    @BindView(R.id.my_paiming)//第几名
            TextView my_paiming;


    @BindView(R.id.system_msg_iv)//信息
            ImageView systemMsgIv;
    @BindView(R.id.setting_iv)//设置
            ImageView settingIv;
    @BindView(R.id.iv)//头像
            ImageView iv;
    @BindView(R.id.my_right_dengji_iv)//等级标识(勋章)
            ImageView my_right_dengji_iv;

    @BindView(R.id.my_chakan_jilu_btn)//查看记录
            ImageView my_chakan_jilu_btn;
    @BindView(R.id.my_name_tv)//名字
            TextView myNameTv;
    @BindView(R.id.my_progress_xinyufen)//进度条
            CircularProgressView mProgress;
    @BindView(R.id.my_xinyufen_chegnji_tv)//0  进度值
            TextView my_xinyufen_chegnji_tv;

    @BindView(R.id.my_xinyufen_chegnji1_tv)//评价
            TextView my_xinyufen_chegnji1_tv;

    @BindView(R.id.my_daishou_ci_tv)//累计诚信代售xx次
            TextView my_daishou_ci_tv;

    @BindView(R.id.my_name_state_tv)//账号是否正常状态提示
            TextView myNameStateTv;
    @BindView(R.id.tv_use)//支付宝  额度
            TextView tvUse;

    @BindView(R.id.my_tv_day)//wechat  限度
            TextView wechatEdu;

    //    @BindView(R.id.tv_wechat_shoukua)
//    TextView tvWechatUse;
//    @BindView(R.id.tv_wechat_sheng)
//    TextView tvWechatSheng;
//    @BindView(R.id.my_tv_wechat_day)
//    TextView tvWechatDay;
    @BindView(R.id.my_hongdian)
    TextView mMy_hongdian;
    @BindView(R.id.my_ll)
    RelativeLayout myLl;

    @BindView(R.id.my_right_ll)
    LinearLayout myRightLl;
    private TestHomePageData.DataBean.UserInfoBean userInfo;
    private TestHomePageData.DataBean databean;
    private String userId;
    private String token;
    private OrderFormkFragment parentFragment1;

    public MyFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
    }

    @Override
    protected void initData() {
//        String urlPath = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW);
//        if (urlPath!=null){
//            Glide.with(getContext()).load(urlPath).apply(new RequestOptions().circleCrop()).placeholder(R.mipmap.icon).into(iv);
//        }
//        getPermission();//权限
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);

        token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);

        //我的页面数据
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId), token);

        //消息未读
        mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);

        //读取消息
        mPresenter.getData(ApiConfig.TEST_UPDATE_USERNEW, Integer.parseInt(userId), token);
    }

    @OnClick({R.id.system_msg_iv, R.id.setting_iv, R.id.my_ll, R.id.my_right_ll, R.id.my_left_ll, R.id.my_chakan_jilu_btn, R.id.my_card3})
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
//            //测试信誉积分页面
//            case R.id.my_rl:
////                startActivity(new Intent(getActivity(),XinyufenRacordActivity.class));
//                startActivity(new Intent(getActivity(), RankingListActivity.class));
//                break;

            //查看记录
            case R.id.my_chakan_jilu_btn:
                Intent intent1 = new Intent(getActivity(), XinyufenRacordActivity.class);
                startActivity(intent1);
                break;
            //显示排名
            case R.id.my_card3:
                Intent intent2 = new Intent(getActivity(), RankingListActivity.class);
                startActivity(intent2);
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
        ToastUtil.showLong(R.string.error + "");
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
                    if (userEarningsToday != null) {
                        getGamemoneyTv.setText(userEarningsToday);
                    }

                    //保存图片 跟 昵称
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW, userHeadImg);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_NICK, userName);
                    myNameTv.setText(userName);//用户名称
                    tvUse.setText(userInfo.getZfbEd() + "");//支付宝已使用额度
                    wechatEdu.setText(userInfo.getWxEd() + "");//微信已使用额度

                    String alipay_residue = tvUse.getText().toString().trim();//获取支付宝额度
//                    int alipayInt = Integer.parseInt(alipay_residue);
//                    String wechat_residue = tvWechatSheng.getText().toString().trim();//获取微信额度
//                    int wechatInt = Integer.parseInt(alipay_residue);

                    //剩余额度
//                    if (alipayInt >= userInfo.getZfbEd())
//                        tvSheng.setText((alipayInt - userInfo.getZfbEd()) + "");
//                    else ToastUtil.showShort("已达到每日限度");

//                    if (wechatInt >= userInfo.getWxEd())
//                        tvWechatSheng.setText((wechatInt - userInfo.getWxEd()) + "");
//                    else ToastUtil.showShort("已达到每日限度");

                    RequestOptions requestOptions = new RequestOptions().centerCrop();
                    Glide.with(getContext()).load(userHeadImg).apply(requestOptions).placeholder(R.mipmap.icon).into(iv);

//                    myNameTv.setText();

                    //等级勋章
                    int userLevel = userInfo.getUserLevel();
                    String userLevelName = userInfo.getUserLevelName();
                    int[] iv = {R.mipmap.icon_huangjin, R.mipmap.icon_bojin, R.mipmap.icon_zuanshi, R.mipmap.icon_wangzhe, R.mipmap.icon_xingyao};
                    if (userLevel == 1) {
                        Glide.with(getActivity()).load(iv[0]).placeholder(R.mipmap.icon).into(my_right_dengji_iv);
                    } else if (userLevel == 2) {
                        Glide.with(getActivity()).load(iv[1]).placeholder(R.mipmap.icon).into(my_right_dengji_iv);
                    } else if (userLevel == 3) {
                        Glide.with(getActivity()).load(iv[2]).placeholder(R.mipmap.icon).into(my_right_dengji_iv);
                    } else if (userLevel == 4) {
                        Glide.with(getActivity()).load(iv[3]).placeholder(R.mipmap.icon).into(my_right_dengji_iv);
                    } else if (userLevel == 5) {
                        Glide.with(getActivity()).load(iv[4]).placeholder(R.mipmap.icon).into(my_right_dengji_iv);
                    }
                    //                    1.开始营业（歇业）   2.正在营业（营业中）
                    int doBusineseStatus = userInfo.getDoBusineseStatus();
                    Log.i("tag", "我的页面是否营业歇业: " + doBusineseStatus);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.yingye_status, String.valueOf(doBusineseStatus));
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
                } else if (testUpdateUserNew.getCode() == 0) {
                    //已读取  隐藏
//                    ToastUtil.showLong(testUpdateUserNew.getMsg());
//                    mMy_hongdian.setVisibility(View.GONE);
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
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity() != null && !hidden) {
            Log.i("tag", "我的页面:onHiddenChanged ");
            initData();
        }
    }
}