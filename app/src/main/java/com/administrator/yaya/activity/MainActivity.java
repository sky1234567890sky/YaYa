package com.administrator.yaya.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.ConfirmYingyeActivity;
import com.administrator.yaya.activity.my.SettingActivity;
import com.administrator.yaya.activity.my.SystemMessagesActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.homepage.TestDianjiYingye;
import com.administrator.yaya.bean.homepage.TestHomePageData;
import com.administrator.yaya.bean.homepage.TestStopYingYe;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.bean.invite.TestInventory;
import com.administrator.yaya.bean.invite.TestUserCount;
import com.administrator.yaya.bean.my.TestUserNowMsg;
import com.administrator.yaya.fragment.HomePageFragment;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.fragment.MyFragment;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<LoginModel> implements ICommonView {
    @BindView(R.id.home_fragment)
    FrameLayout mFl;
    @BindView(R.id.homepage)
    RadioButton mHomepage;
    @BindView(R.id.inventory_btn)
    RadioButton mInventoryBtn;
    @BindView(R.id.dobusiness_btn)
    RadioButton mDobusinessBtn;
    @BindView(R.id.orderform_btn)
    RadioButton mOrderformBtn;
    @BindView(R.id.mine_btn)
    RadioButton mMineBtn;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.dobusiness_iv)//营业
            ImageView mDobusinessIv;
    @BindView(R.id.close_business_iv)//歇业
            ImageView close_business_iv;
    @BindView(R.id.hongdian)
    TextView mHongdian;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private HomePageFragment homePageFragment;
    private InventoryFragment inventoryFragment;
    private OrderFormkFragment orderFormkFragment;
    private MyFragment myFragment;
    private long exittime;
    private PopupWindow popupWindow;
    private String position = "0";
    private String userId;
    private int num = 2;
    private TestAccountPaid testObligation;
    private Button button5;
    private int data;
    private String token;
    private int userSalesCount;
    private String isYingye;
    private Toast toast;
    private String isYingYe;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mHomepage.setChecked(true);
        titles = new ArrayList<>();
        titles.add(R.string.homepage);
        titles.add(R.string.inventory);
        titles.add(R.string.orderform);
        titles.add(R.string.my);
        //初始化页面管理类
        manager = getSupportFragmentManager();
        initFragment();
        addHomeFragment();
        //覆盖在RadioGroup之上LinearLayout的第五个占位子布局

        MonitorNetWorkChange();
        //判断歇业还是营业
//        1.开始营业（歇业）   2.正在营业（营业中）
        isYingye = SharedPrefrenceUtils.getString(this, NormalConfig.isYingYe);

        //如果为1  歇业
        if (isYingye.equals("2")) {
            //营业
            mDobusinessIv.setVisibility(View.VISIBLE);
            close_business_iv.setVisibility(View.GONE);
        }else {
            mDobusinessIv.setVisibility(View.GONE);
            close_business_iv.setVisibility(View.VISIBLE);
        }
    }

    private void addHomeFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.home_fragment, fragments.get(0));
        transaction.commit();
        //Activity跳转到Fragment ，"affirm","2"
        int affirm = getIntent().getIntExtra("affirm", 0);
        if (affirm == 2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_fragment, inventoryFragment)
                    .addToBackStack(null)
                    .commit();
            mInventoryBtn.setChecked(true);
        }
        int upaway = getIntent().getIntExtra("upaway", 0);
        if (upaway == 3) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_fragment, orderFormkFragment)
                    .addToBackStack(null)
                    .commit();
            mOrderformBtn.setChecked(true);
        }

        int orderform = getIntent().getIntExtra("orderform", 0);
        if (orderform == 4) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_fragment, orderFormkFragment)
                    .addToBackStack(null)
                    .commit();
            mOrderformBtn.setChecked(true);
        }

        int home = getIntent().getIntExtra("confirmyingye", 0);
        if (home == 10) {
            //让营业
//            close_business_iv.setVisibility(View.GONE);
//            mDobusinessIv.setVisibility(View.VISIBLE);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_fragment, inventoryFragment)
                    .addToBackStack(null)
                    .commit();
            mInventoryBtn.setChecked(true);
        }
//        int invite = getIntent().getIntExtra("tijaio", 0);
//        if (invite == 6) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.home_fragment, inventoryFragment)
//                    .addToBackStack(null)
//                    .commit();
//            mInventoryBtn.setChecked(true);
//        }
    }

    private void initFragment() {
        homePageFragment = new HomePageFragment();
        inventoryFragment = new InventoryFragment();
        orderFormkFragment = new OrderFormkFragment();
        myFragment = new MyFragment();
        fragments = new ArrayList<Fragment>();
        fragments.add(homePageFragment);
        fragments.add(inventoryFragment);
        fragments.add(orderFormkFragment);
        fragments.add(myFragment);
    }

    @Override
    protected void initData() {
        super.initData();
        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);

        isYingYe = SharedPrefrenceUtils.getString(this, NormalConfig.isYingYe);
        //消息
//        mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);
//        mMineBtn
        //获取是否营业的状态
        mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId), token);
    }
    @Override
    protected void initListener() {
        super.initListener();
        //开始营业
        mDobusinessIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mPresenter.getData(ApiConfig.TEST_INVENTORY,Integer.parseInt(userId),mApplication.mToken);
//                ToastUtil.showLong("点击");
                //判断   库存列表数据
//                mPresenter.getData(ApiConfig.TEST_INVENTORY, Integer.parseInt(userId), token);//库存是否有数据
//                //库存总数
//                mPresenter.getData(ApiConfig.TEST_USER_COUNT,Integer.parseInt(userId));
                //开始营业
//                Log.i("tag", "img:开始营业 ");

                    tanChuang();

            }
        });

        //歇业
        close_business_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPop();
                //停止营业
//                mPresenter.getData(ApiConfig.TEST_STOP_YINGYE, Integer.parseInt(userId), token);
//                Log.i("tag", "img:歇业 ");
            }
        });
    }

    private void stopPop() {

        new AlertDialog.Builder(this)
                .setTitle("是否停止营业？")
                .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @SuppressLint("ApplySharedPref")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mPresenter.getData(ApiConfig.TEST_STOP_YINGYE, Integer.parseInt(userId), token);

                    }
                }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }

    //确认营业
    private void tanChuang() {

        new AlertDialog.Builder(this)
                .setTitle("是否营业？")
                .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @SuppressLint("ApplySharedPref")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mPresenter.getData(ApiConfig.TEST_DIANJIYINGYE, Integer.parseInt(userId), token);

                    }
                }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(getResources().getString(R.string.error));
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
//        hideLoadingDialog();
        //已付款
        switch (whichApi) {
            //获取是否开始营业的状态
            case ApiConfig.TEXT_HOMEPAGE_DATA:
                TestHomePageData data = (TestHomePageData) t[0];
                if (data.getMsg().equals("1")) {
                    Toast.makeText(this, R.string.username_login_hint + "", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    startActivity(login);
                    finish();
                } else if (data.getCode() == 0 && data.getData() != null) {
                    TestHomePageData.DataBean.UserInfoBean userInfo = data.getData().getUserInfo();
//                    int userStatus = userInfo.getUserStatus();//账号  1.正常  2.禁用
                    int doBusineseStatus = userInfo.getDoBusineseStatus();
//                    1.开始营业（歇业）   2.正在营业（营业中）

                    if (doBusineseStatus==2){//营业
                        close_business_iv.setVisibility(View.GONE);
                        mDobusinessIv.setVisibility(View.VISIBLE);
                    }else{
                        close_business_iv.setVisibility(View.VISIBLE);
                        mDobusinessIv.setVisibility(View.GONE);
                    }
                }

                break;
            case ApiConfig.TEXT_GATHERING2:
                testObligation = (TestAccountPaid) t[0];
                if (testObligation.getCode() == 0 && !TextUtils.isEmpty(testObligation.getData().getAmount())) {
//                    Log.i("tag", "============: "+testObligation.getData().getAmount());
                    popupSelector(testObligation.getData().getAmount());//营业
//                    mDobusinessIv.setOnClickListener(null);
                } else {
                    if (TextUtils.isEmpty(testObligation.getData().getAmount())) {
                        ToastUtil.showLong("当前没有库存，不能营业哦！");
                    }
                }
                break;

            //消息未读
            case ApiConfig.TEST_GET_USERNOW_MSG:
                TestUserNowMsg testUserNowMsg = (TestUserNowMsg) t[0];
//                结果：1有	2无
                if (testUserNowMsg.getMsg().equals(mApplication.SignOut)) {
                    Toast.makeText(this, getResources().getString(R.string.username_login_hint), Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");

                    mApplication.userid = 0;

                    mApplication.mToken = "";

                    startActivity(login);

                    finish();
                }
                if (testUserNowMsg.getCode() == 0 && !testUserNowMsg.getMsg().equals(mApplication.SignOut)) {
                    String msg = testUserNowMsg.getMsg();
//                    data = testUserNowMsg.getData();
//
//                    Log.i("tag", "main1or2: " + data);
//
//                    if (data == 2) {//默认不显示
////                        mHongdian.setVisibility(View.GONE);
//
//                    } else if (data == 1) {//有
//                        //显示
//
////                        mHongdian.setVisibility(View.VISIBLE);
//                        //通知有新消息
//                    }
                }
                break;

            case ApiConfig.TEST_INVENTORY:
                TestInventory testInventory = (TestInventory) t[0];
                if (testInventory.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong(getResources().getString(R.string.username_login_hint));
                    Intent intent = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid = 0;
                    mApplication.mToken = "";
                    startActivity(intent);
                    finish();
                    //提示
                } else if (testInventory.getCode() == 0 && !testInventory.getMsg().equals(mApplication.SignOut)) {
//                    if (testInventory.getData() != null) {
//                        userSalesCount = testInventory.getData().getUserAllCount();
//                        if (userSalesCount > 0) {
//                            Intent intent = new Intent(MainActivity.this, ConfirmYingyeActivity.class);
//                            startActivity(intent);
//                        } else {
////                            ToastUtil.showLong("当前没有库存，不能营业哦！");
//                            new AlertDialog.Builder(this)
//                                    .setTitle("当前没有库存，不能营业哦！")
//                                    .setNegativeButton("确认", new DialogInterface.OnClickListener() {
//                                        @SuppressLint("ApplySharedPref")
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                        }
//                                    }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//
//                                }
//                            }).show();
//                        }
//                    }
                }
                break;
            //开始营业
            case ApiConfig.TEST_DIANJIYINGYE:
                TestDianjiYingye testDianjiYingye = (TestDianjiYingye) t[0];
                if (testDianjiYingye.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong(getResources().getString(R.string.username_login_hint));
                    Intent intent = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid = 0;
                    mApplication.mToken = "";
                    startActivity(intent);
                    finish();
                    //提示

                } else if (testDianjiYingye.getCode() == 0) {


                    toast = Toast.makeText(getApplicationContext(),
                            testDianjiYingye.getMsg() + "", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

//                    跳转开始营业
//                    Intent intent = new Intent(this, ConfirmYingyeActivity.class);
//                    startActivity(intent);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.isYingYe, testDianjiYingye.getData()+"");
                    isYingYe = testDianjiYingye.getData()+"";

                    close_business_iv.setVisibility(View.VISIBLE);
                    mDobusinessIv.setVisibility(View.GONE);
                    //首页 和 我的  获取是否营业的状态
//                    mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId), token);
                }
                break;
            //停止营业
            case ApiConfig.TEST_STOP_YINGYE:
                TestStopYingYe testStopYingYe = (TestStopYingYe) t[0];
                if (testStopYingYe.getMsg().equals(mApplication.SignOut)) {
                    ToastUtil.showLong(getResources().getString(R.string.username_login_hint));
                    Intent intent = new Intent(this, LoginActivity.class);
                    SharedPrefrenceUtils.saveString(this, NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, "");
                    mApplication.userid = 0;
                    mApplication.mToken = "";
                    startActivity(intent);
                    finish();
                    //提示
                } else if (testStopYingYe.getCode() == 0) {
                    //歇业
//                    close_business_iv.setVisibility(View.VISIBLE);
//                    mDobusinessIv.setVisibility(View.GONE);

                    SharedPrefrenceUtils.saveString(this, NormalConfig.isYingYe, testStopYingYe.getData()+"");
                    isYingYe = testStopYingYe.getData()+"";
                    toast = Toast.makeText(getApplicationContext(),
                            testStopYingYe.getMsg() + "", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    //保存
//                    SharedPrefrenceUtils.saveString(this,NormalConfig.isYingYe,"2");
//                    if (isYingye.equals(mApplication.SignOut)){//歇业
                    close_business_iv.setVisibility(View.GONE);
                    mDobusinessIv.setVisibility(View.VISIBLE);

                    //首页 和 我的  获取是否营业的状态
//                    mPresenter.getData(ApiConfig.TEXT_HOMEPAGE_DATA, Integer.parseInt(userId), token);
//                    }
                }
                break;
            //库存总数
            case ApiConfig.TEST_USER_COUNT:
                TestUserCount testUserCount = (TestUserCount) t[0];
                if (testUserCount.getCode() == 0) {
                    TestUserCount.DataBean data1 = testUserCount.getData();
                    TestUserCount.DataBean.CommodityBean commodity = data1.getCommodity();
//                    所有可用库存 userAllCount
//                    今日已售数量  amount
//                    库存数量 comInventory
                    int userAllCount = data1.getUserAllCount();
                    int amount = data1.getAmount();

                }
                break;
        }
    }

    @OnClick({R.id.homepage, R.id.inventory_btn, R.id.dobusiness_btn, R.id.orderform_btn, R.id.mine_btn, R.id.dobusiness_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homepage://首页
                //消息未读接口
//                mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);
                mHomepage.setChecked(true);
                FragmentUtils.addFragment(manager, homePageFragment.getClass(), R.id.home_fragment, null);
                break;
            case R.id.inventory_btn://库存
                //消息未读接口
//                mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);
                FragmentUtils.addFragment(manager, inventoryFragment.getClass(), R.id.home_fragment, null);
                break;
            case R.id.dobusiness_iv:
                //请求数据
//                mPresenter.getData(ApiConfig.TEXT_GATHERING2, Integer.parseInt(userId), num);
                break;

            case R.id.orderform_btn://订单
                //消息未读接口
//                mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);
                FragmentUtils.addFragment(manager, orderFormkFragment.getClass(), R.id.home_fragment, null);
                break;
            case R.id.mine_btn://我的
                //消息未读接口
//                mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG, Integer.parseInt(userId), token);
                FragmentUtils.addFragment(manager, myFragment.getClass(), R.id.home_fragment, null);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            //如果点击的是后退键  首先判断popupWindow是否能够后退   返回值是boolean类型的
            if (popupWindow != null) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            }
            if ((System.currentTimeMillis() - exittime) > 2000) {  //如果两次连续点击的时间>2s，就不执行操作
                ToastUtil.showShort("再按一次退出丫丫");
                exittime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return false;
    }

    private void popupSelector(final String amount) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_yingye, null);
        //显示营业游戏币数量
        ImageView cancel_iv = inflate.findViewById(R.id.cancel_pop_close_iv);
        //上架数量
        TextView upAwayNumber = inflate.findViewById(R.id.popup_tv_number);
        TextView mPopupTvCancel = inflate.findViewById(R.id.popup_tv_cancel);
        TextView mPopupTvOk = inflate.findViewById(R.id.popup_tv_ok);
        final EditText et_gamemoney_number = inflate.findViewById(R.id.et_gamemoney_number);

        //获取输入要营业的库存数量
        final String gamemoneyNumber = et_gamemoney_number.getText().toString().trim();

        upAwayNumber.setText(amount);

        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.5f;
        this.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = MainActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                MainActivity.this.getWindow().setAttributes(lp);
            }
        });
        cancel_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        mPopupTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        mPopupTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_gamemoney_number.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        int i = Integer.parseInt(String.valueOf(s));
                        if (Integer.parseInt(amount) > i) {

                        } else {
                            ToastUtil.showLong("已超过最大库存数量");
                            //禁止输入
                            et_gamemoney_number.setInputType(InputType.TYPE_NULL);//来禁止手机软键盘
                            et_gamemoney_number.setInputType(InputType.TYPE_CLASS_TEXT);//来开启软键盘
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                if (Integer.parseInt(amount) > Integer.parseInt(gamemoneyNumber)) {
                    //                直接营业
                    mOrderformBtn.setChecked(true);

                    FragmentUtils.addFragment(manager, orderFormkFragment.getClass(), R.id.home_fragment, null);

//                startActivity(new Intent(MainActivity.this,UpGameMoneyActivity.class));
                    popupWindow.dismiss();
                } else {

                    ToastUtil.showLong("请输入的数量超过库存数量!");

                }
            }
        });

        popupWindow.setOutsideTouchable(false);
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
    protected void onResume() {//退出页面时执行
        super.onResume();
//        mHongdian.setVisibility(View.GONE);//点击
        initData();
    }

    @Override
    protected void onRestart() {//进入时执行
        super.onRestart();
        initData();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (close_business_iv.getVisibility()==View.GONE){//歇业状态 ， 立即购买不能点击
//            TextView tvBtn = findViewById(R.id.home_buy_now_btn_tv);
//            tvBtn.setClickable(false);
//            ToastUtil.showLong("正在歇业中...");
//        }
//    }
}
//接口回调  隐藏  红点
//    @Override
//    public void changevalue() {
//        //如果显示
////        if(mHongdian.getVisibility()==View.VISIBLE){
//        Log.i("tag", "======》: " + mHongdian.getVisibility());
//        mHongdian.setVisibility(View.GONE);
////    }
//
//    }
//}