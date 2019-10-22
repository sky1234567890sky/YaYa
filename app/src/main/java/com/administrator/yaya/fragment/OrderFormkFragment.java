package com.administrator.yaya.fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.CancelFragment;
import com.administrator.yaya.activity.orderform.FinishFragment;
import com.administrator.yaya.activity.orderform.SellFragment;
import com.administrator.yaya.adapter.home.OrderFormAdapter;
import com.administrator.yaya.utils.AppConstants;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.SetIndicator;
import com.administrator.yaya.utils.SetIndicator2;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFormkFragment extends Fragment {
    @BindView(R.id.inventory_money)
    TextView mInventoryMoney;
    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.orderform_vp)
    ViewPager vp;
    Unbinder unbinder;
    private FragmentManager manager;
    private SellFragment sellFragment;
    private FinishFragment finishFragment;
    private CancelFragment cancelFragment;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    public OrderFormkFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_formk, container, false);
        unbinder = ButterKnife.bind(this, view);
        manager = getFragmentManager();
        initView();
        intiListener();
        return view;
    }

    private void initView() {
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

        OrderFormAdapter orderFormAdapter = new OrderFormAdapter(getChildFragmentManager(),fragments,titles);
        vp.setAdapter(orderFormAdapter);
        tabLayout.setViewPager(vp);
//        tabLayout.setDistributeEvenly(true);
        vp.setCurrentItem(0);
        if (tabLayout.getTabCount()>1)tabLayout.setCurrentTab(1);
        orderFormAdapter.notifyDataSetChanged();
    }

    private void intiListener() {

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
