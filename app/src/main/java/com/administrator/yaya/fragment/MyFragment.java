package com.administrator.yaya.fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.administrator.yaya.R;
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
    @BindView(R.id.my_ll)
    RelativeLayout myLl;
    @BindView(R.id.wire)
    View wire;

    @BindView(R.id.my_right_ll)
    LinearLayout myRightLl;
    private TestHomePageData.DataBean.UserInfoBean userInfo;
    private TestHomePageData.DataBean databean;
    private String userId;

    public MyFragment() {
        // Required empty public constructor
    }
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_my;
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser==true && iv!=null){
//            initData();
//        }
//    }

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
//        String urlPath = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW);
//        if (urlPath!=null){
//            Glide.with(getContext()).load(urlPath).apply(new RequestOptions().circleCrop()).placeholder(R.mipmap.icon).into(iv);
//        }
//        getPermission();//权限
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId));
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
//                pd.putExtra("headlerIv",userInfo.getUserName());
                startActivityForResult(pd,11);
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
        if (requestCode == 11 && resultCode ==12 ){//结果码
            String nickName = data.getStringExtra("sky");
            if (nickName!=null){
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
        switch (whichApi) {
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                TestHomePageData data = (TestHomePageData) t[0];
                if (data.getCode() == 0 && data.getData()!=null && data.getData().getUserInfo() != null) {
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
                    String userNickName = userInfo.getUserNickName();
//                    userEarningsTotal 总收益

                    allGamemoneyTv.setText(userInfo.getUserEarningsTotal()+ "");//總收益
//                    zfbEd 支付宝已使用额度
//                    wxEd 微信已使用额度
//                    userEarningsToday 今日收益
                    String userEarningsToday = databean.getUserEarningsToday();
                    if (userEarningsToday==null)

                    getGamemoneyTv.setText("0");//今日收益
//                    userEarningsToday
                    else getGamemoneyTv.setText(userEarningsToday);
                    //保存图片 跟 昵称
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.HEADLER_IMAGEVIEW,userHeadImg);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_NICK,userName);
                    myNameTv.setText(userName);//用户名称

                    tvUse.setText(userInfo.getZfbEd() + "");//支付宝已使用额度
                    tvWechatUse.setText(userInfo.getWxEd() + "");//微信已使用额度

                    String alipay_residue = tvDay.getText().toString().trim();//获取支付宝额度
                    int alipayInt = Integer.parseInt(alipay_residue);
                    String wechat_residue = tvWechatSheng.getText().toString().trim();//获取微信额度
                    int wechatInt = Integer.parseInt(alipay_residue);

                    //剩余额度
                    if (alipayInt>=userInfo.getZfbEd())tvSheng.setText((alipayInt-userInfo.getZfbEd())+"");
                    else ToastUtil.showShort("已达到每日限度");
                    if (wechatInt>=userInfo.getWxEd())tvWechatSheng.setText((wechatInt-userInfo.getWxEd())+"");
                    else ToastUtil.showShort("已达到每日限度");
                    RequestOptions requestOptions = new RequestOptions().centerCrop();
                    Glide.with(getContext()).load(userHeadImg).apply(requestOptions).placeholder(R.mipmap.icon).into(iv);
//                    myNameTv.setText();
                } else {
                    ToastUtil.showShort(data.getMsg());
                }
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
//        Log.i("tag", "刷新数据1:"+"" );
        initData();
    }
    @Override
    public void onPause() {
        super.onPause();
//        Log.i("tag", "刷新数据12:"+"" );
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity() != null && !hidden) {
//            Log.i("tag", "刷新数据2: ");
        }
    }
}