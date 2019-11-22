package com.administrator.yaya.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
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

import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.ConfirmYingyeActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.bean.my.TestUserNowMsg;
import com.administrator.yaya.fragment.HomePageFragment;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.fragment.MyFragment;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.BadgeView;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.ycbjie.ycstatusbarlib.bar.YCAppBar;

public class MainActivity extends BaseMvpActivity<LoginModel> implements  ICommonView {
    //@BindView(R.id.title_tb)
//    TextView mTitle;
//    @BindView(R.id.toolbar)
//    Toolbar mToolbar;
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
    @BindView(R.id.dobusiness_iv)
    ImageView mDobusinessIv;

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

        button5 = (Button) findViewById(R.id.btn_my);
        remind(button5);
    }
    @SuppressLint("SetTextI18n")
    private void remind(View view) {

// 创建一个BadgeView对象，view为你需要显示提醒的控件
        BadgeView badge1 = new BadgeView(this, view);
        // 需要显示的提醒类容
//        badge1.setText("12");
// 显示的位置.右上角,BadgeView.POSITION_BOTTOM_LEFT,下左，还有其他几个属性
        badge1.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        // 文本颜色
        badge1.setTextColor(Color.WHITE);
// 提醒信息的背景颜色，自己设置
        badge1.setBadgeBackgroundColor(Color.RED);
//还可以设置背景图片
//        badge1.setBackgroundResource(R.drawable.boder_ext);
// 文本大小
//        badge1.setTextSize(12);
// 水平和竖直方向的间距
//        badge1.setBadgeMargin(3, 3);
//各边间隔
        badge1.setBadgeMargin(5);
//显示效果，如果已经显示，则隐藏，如果隐藏，则显示
//         badge1.toggle();
// 显示
//        badge1.show();
//隐藏
         badge1.hide();

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

        mPresenter.getData(ApiConfig.TEST_GET_USERNOW_MSG,Integer.parseInt(userId),mApplication.mToken);

//        mMineBtn
    }

    @Override
    protected void initListener() {
        super.initListener();


        mDobusinessIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mPresenter.getData(ApiConfig.TEST_INVENTORY,Integer.parseInt(userId),mApplication.mToken);
//                ToastUtil.showLong("点击");
                Intent intent = new Intent(MainActivity.this, ConfirmYingyeActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onError(int whichApi, Throwable e) {

    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        //已付款
        switch (whichApi) {

            case ApiConfig.TEXT_GATHERING2:
                testObligation = (TestAccountPaid) t[0];

                if (testObligation.getCode()==0 && !TextUtils.isEmpty(testObligation.getData().getAmount())){
//                    Log.i("tag", "============: "+testObligation.getData().getAmount());

                    popupSelector(testObligation.getData().getAmount());//营业

//                    mDobusinessIv.setOnClickListener(null);
                }else {
                    if (TextUtils.isEmpty(testObligation.getData().getAmount())){
                        ToastUtil.showLong("当前没有库存，不能营业哦！");
                    }
                }
                break;

                //消息未读
            case ApiConfig.TEST_GET_USERNOW_MSG:
                TestUserNowMsg testUserNowMsg = (TestUserNowMsg) t[0];
//                结果：1有	2无
                if (testUserNowMsg.getMsg()==mApplication.SignOut){
                    ToastUtil.showLong(R.string.username_login_hint+"");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    return;
                }
                if (testUserNowMsg.getCode()==0){
                    String msg = testUserNowMsg.getMsg();
                    data = testUserNowMsg.getData();
                }
                break;
        }
    }

    @OnClick({R.id.homepage, R.id.inventory_btn, R.id.dobusiness_btn, R.id.orderform_btn, R.id.mine_btn, R.id.dobusiness_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homepage://首页
                mHomepage.setChecked(true);
                FragmentUtils.addFragment(manager, homePageFragment.getClass(), R.id.home_fragment, null);
                break;
            case R.id.inventory_btn://库存
                FragmentUtils.addFragment(manager, inventoryFragment.getClass(), R.id.home_fragment, null);
                break;
            case R.id.dobusiness_iv:
                    //请求数据
//                    mPresenter.getData(ApiConfig.TEXT_GATHERING2, Integer.parseInt(userId), num);

                break;
            case R.id.orderform_btn://订单
                FragmentUtils.addFragment(manager, orderFormkFragment.getClass(), R.id.home_fragment, null);
                break;
            case R.id.mine_btn://我的
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
            }else{
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
                        if (Integer.parseInt(amount)>i){

                        }else{
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
                if (Integer.parseInt(amount)>Integer.parseInt(gamemoneyNumber)){
                    //                直接营业
                    mOrderformBtn.setChecked(true);

                    FragmentUtils.addFragment(manager, orderFormkFragment.getClass(), R.id.home_fragment, null);

//                startActivity(new Intent(MainActivity.this,UpGameMoneyActivity.class));
                    popupWindow.dismiss();
                }else{
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

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        initData();
//
//    }
}