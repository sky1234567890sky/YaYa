package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.ObligationAdapter;
import com.administrator.yaya.activity.orderform.CancelFragment;
import com.administrator.yaya.activity.orderform.FinishFragment;
import com.administrator.yaya.activity.orderform.SellFragment;
import com.administrator.yaya.adapter.home.OrderFormAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseFragment;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 订单
 */
public class OrderFormkFragment extends BaseFragment {

    @BindView(R.id.orderform_inventory_money)
    TextView mInventoryMoney;
    @BindView(R.id.orderform_stab)
    SlidingTabLayout tabLayout;
    @BindView(R.id.orderform_vp)
    ViewPager vp;

    private FragmentManager manager;
    private SellFragment sellFragment;
    private FinishFragment finishFragment;
    private CancelFragment cancelFragment;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private FragmentTransaction transaction;
    public OrderFormkFragment() {
    }
    @Override
    protected void initData() {
        super.initData();
        transaction = getFragmentManager().beginTransaction();
    }
//    //接收订阅的事件
//    @SuppressLint("SetTextI18n")
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMsgEvent(String amount) {
//        if (mInventoryMoney != null) {
//            if (amount != null) {
//                mInventoryMoney.setText("今日所收游戏币：" + amount);
//            } else {
//                mInventoryMoney.setText("今日所收游戏币：0");
//            }
//        }
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        //注册
//        EventBus.getDefault().register(this);
//    }
//    @Override
//    public void onStop() {
//        super.onStop();
//        //取消注册
//        EventBus.getDefault().unregister(this);
//    }

    @Override
    protected void initListener() {
        super.initListener();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_formk;
    }
    @Override
    protected void initView(View view) {
        super.initView(view);

        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        sellFragment = new SellFragment();
        finishFragment = new FinishFragment();
        cancelFragment = new CancelFragment();
        fragments.add(sellFragment);
        fragments.add(finishFragment);
        fragments.add(cancelFragment);
        titles.add("售卖中");
        titles.add("已完成");
        titles.add("已取消");
//        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
//        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
//        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
//        tabLayout.getTabAt(0).select();
//        initTab();
//        Bundle bundle = new Bundle();
//        bundle.putInt("selly",1);
//        sellFragment.setArguments(bundle);/
//        Bundle bundle1 = new Bundle();
//        bundle1.putInt("finish",2);
//        finishFragment.setArguments(bundle1);
//        Bundle bundle2 = new Bundle();
//        bundle2.putInt("cancel",3);
//        cancelFragment.setArguments(bundle2);
        OrderFormAdapter orderFormAdapter = new OrderFormAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(orderFormAdapter);
        tabLayout.setViewPager(vp);
//        tabLayout.setDistributeEvenly(true);
        vp.setCurrentItem(0);
//        if (tabLayout.getTabCount()>1)tabLayout.setCurrentTab(0);
        orderFormAdapter.notifyDataSetChanged();

    }
//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        if (hidden==false) {
//            Log.i("tag", "onHiddenChanged: ========>");
//            getFragmentManager().beginTransaction().replace(R.id.orderform_vp, sellFragment).commit();
//        }
//    }

    private void initTab() {
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0:
//                        getFragmentManager().beginTransaction().replace(R.id.orderform_vp, sellFragment).commit();
//                        break;
//                    case 1:
//                        getFragmentManager().beginTransaction().replace(R.id.orderform_vp, finishFragment).commit();
//                        break;
//                    case 2:
//                        getFragmentManager().beginTransaction().replace(R.id.orderform_vp, cancelFragment).commit();
//                        break;
//                }
//            }

//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });

    }
    private OrderFormsetOnclikListener orderFormsetOnclikListener;
    public interface OrderFormsetOnclikListener {
        void setonclik(String mInventoryMoney);
    }
    public void OrderFormsetOnclikListener(OrderFormsetOnclikListener orderFormsetOnclikListener) {
        this.orderFormsetOnclikListener = orderFormsetOnclikListener;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity() != null && !hidden) {
            initData();
        }
    }
}