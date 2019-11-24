package com.administrator.yaya.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.DaiQueRenFragment;
import com.administrator.yaya.activity.orderform.WeiShouHuoFragment;
import com.administrator.yaya.activity.orderform.FinishFragment;
import com.administrator.yaya.activity.orderform.AllFragment;
import com.administrator.yaya.adapter.home.OrderFormAdapter;
import com.administrator.yaya.base.BaseFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
/**
 * A simple {@link Fragment} subclass.
 * 订单
 */
public class OrderFormkFragment extends BaseFragment {
    @BindView(R.id.orderform_inventory_money)
    TextView mInventoryMoney;
    @BindView(R.id.orderform_tab)
    SlidingTabLayout tabLayout;
    @BindView(R.id.orderform_vp)
    ViewPager vp;
    private FragmentManager manager;
    private AllFragment sellFragment;
    private FinishFragment finishFragment;
    private WeiShouHuoFragment cancelFragment;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private FragmentTransaction transaction;
    private DaiQueRenFragment daiQueRenFragment;

    public OrderFormkFragment() {

    }
    @Override
    protected void initData() {
        super.initData();
        transaction = getFragmentManager().beginTransaction();
    }

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

        sellFragment = new AllFragment();
        finishFragment = new FinishFragment();
        cancelFragment = new WeiShouHuoFragment();
        daiQueRenFragment = new DaiQueRenFragment();
        fragments.add(sellFragment);
        fragments.add(daiQueRenFragment);
        fragments.add(cancelFragment);
        fragments.add(finishFragment);

        titles.add("全部");
        titles.add("待确认");
        titles.add("未收货");
        titles.add("已完成");
        OrderFormAdapter orderFormAdapter = new OrderFormAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(orderFormAdapter);
        tabLayout.setViewPager(vp);
//        tabLayout.setDistributeEvenly(true);
        vp.setCurrentItem(0);
//        if (tabLayout.getTabCount()>1)tabLayout.setCurrentTab(0);
        orderFormAdapter.notifyDataSetChanged();
    }
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