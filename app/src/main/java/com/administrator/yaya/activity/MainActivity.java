package com.administrator.yaya.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseActivity;
import com.administrator.yaya.bean.login_register_bean.TestLogin;
import com.administrator.yaya.fragment.HomePageFragment;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.fragment.MyFragment;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.ToastUtil;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    //    @BindView(R.id.title_tb)
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
    private TestLogin loginData;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        super.initView();

//        mToolbar.setTitle("");
//        mTitle.setText(R.string.homepage);
//        setSupportActionBar(mToolbar);//支持Toolbar
        mHomepage.setChecked(true);

        titles = new ArrayList<Integer>();
        titles.add(R.string.homepage);
        titles.add(R.string.inventory);
        titles.add(R.string.orderform);
        titles.add(R.string.my);
        //初始化页面管理类
        manager = getSupportFragmentManager();
        initFragment();
        addHomeFragment();
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
//        loginData = (TestLogin) getIntent().getSerializableExtra("login");
//        if (loginData != null){
//            bundle = new Bundle();
//        bundle.putSerializable("homepage", loginData);
//        homePageFragment.setArguments(bundle);
//    }
    }
    @Override
    protected void initListener() {
        super.initListener();
    }

    @OnClick({R.id.homepage, R.id.inventory_btn, R.id.dobusiness_btn, R.id.orderform_btn, R.id.mine_btn, R.id.dobusiness_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homepage://首页
                mHomepage.setChecked(true);
//                switchFragment(AppConstants.TYPE_HOMEPAGER);
                FragmentUtils.addFragment(manager, homePageFragment.getClass(), R.id.home_fragment,bundle);
                break;
            case R.id.inventory_btn://库存
//                mToolbar.setVisibility(View.GONE);
//                switchFragment(AppConstants.TYPE_INVENTORY);
                FragmentUtils.addFragment(manager, inventoryFragment.getClass(), R.id.home_fragment, bundle);
                break;
            case R.id.dobusiness_iv:
//            case R.id.dobusiness_btn:
                popupSelector();//营业
                break;
            case R.id.orderform_btn://订单
//                switchFragment(AppConstants.TYPE_ORDERFORM);
                FragmentUtils.addFragment(manager, orderFormkFragment.getClass(), R.id.home_fragment, bundle);
                break;
            case R.id.mine_btn://我的
//                switchFragment(AppConstants.TYPE_MY);
                FragmentUtils.addFragment(manager, myFragment.getClass(), R.id.home_fragment, bundle);
                break;
        }
    }

    private int mLastType = 0;

    private void switchFragment(int type) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(type);
        //显示
        if (!fragment.isAdded()) {
            transaction.add(R.id.home_fragment, fragment);
        }
        //隐藏
        Fragment lastFragment = fragments.get(mLastType);
        transaction.hide(lastFragment).show(fragment).commit();
        //记录当前选中位置
        mLastType = type;
        //设置标题
//        mTitle.setText(titles.get(type));
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
        return super.onKeyDown(keyCode, event);
    }

    private void popupSelector() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_yingye, null);
        //显示营业游戏币数量
        ImageView cancel_iv = inflate.findViewById(R.id.cancel_pop_close_iv);
        TextView mPopupTvNumber = inflate.findViewById(R.id.popup_tv_number);//上架数量
        TextView mPopupTvCancel = inflate.findViewById(R.id.popup_tv_cancel);
        TextView mPopupTvOk = inflate.findViewById(R.id.popup_tv_ok);

        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate, Gravity.CENTER , 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.7f;
        this.getWindow().setAttributes(lp);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = MainActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                MainActivity.this.getWindow().setAttributes(lp);
            }
        });
//        mCancelPopCloseIv.setOnClickListener(this);
//        mPopupTvCancel.setOnClickListener(this);
//        mPopupTvOk.setOnClickListener(this);

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
//                直接上架
//                Intent intent = new Intent(this, MainActivity.this);
//                intent.putExtra("affirm", 2);
//                startActivity(intent);
//                intentintentIntent intentIntentintent = new Intent(MainActivity.this, MainActivity.class);
//                intent.putExtra("orderform", 3);
//                startActivity(intent);
                mOrderformBtn.setChecked(true);
                FragmentUtils.addFragment(manager, orderFormkFragment.getClass(), R.id.home_fragment, bundle);

                popupWindow.dismiss();
            }
        });
    }
}