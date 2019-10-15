package com.administrator.yaya.fragment;


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
import com.administrator.yaya.utils.AppConstants;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.SetIndicator;

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
    @BindView(R.id.toolbar3)
    Toolbar mToolbar3;
    @BindView(R.id.orderform_tab)
    TabLayout mOrderformTab;
    @BindView(R.id.orderform_vp)
    ViewPager vp;
//    FrameLayout mOrderformFl;
    Unbinder unbinder;
    private FragmentManager manager;
    private SellFragment sellFragment;
    private FinishFragment finishFragment;
    private CancelFragment cancelFragment;
    private ArrayList<Fragment> fragments;

    public OrderFormkFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_formk, container, false);
        unbinder = ButterKnife.bind(this, view);
        manager = getFragmentManager();
        initView();
        intiListener();
        return view;
    }
    private void initView() {
        fragments = new ArrayList<>();
        sellFragment = new SellFragment();
        finishFragment = new FinishFragment();
        cancelFragment = new CancelFragment();
        fragments.add(sellFragment);
        fragments.add(finishFragment);
        fragments.add(cancelFragment);

//        mOrderformTab.post(new Runnable() {
//            @Override
//            public void run() {
//                SetIndicator.setIndicator(mOrderformTab,5,5);
//            }
//        });

        mOrderformTab.addTab(mOrderformTab.newTab().setText("售卖中"));
        mOrderformTab.addTab(mOrderformTab.newTab().setText("已完成"));
        mOrderformTab.addTab(mOrderformTab.newTab().setText("已取消"));

    }
    private void intiListener() {
        mOrderformTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case AppConstants.TYPE_HOMEPAGER:
//                        FragmentUtils.addFragment(manager,sellFragment.getClass(),R.id.orderform_fl,null);
                        vp.setCurrentItem(AppConstants.TYPE_HOMEPAGER);
                        break;
                        case AppConstants.TYPE_INVENTORY:
//                        FragmentUtils.addFragment(manager,finishFragment.getClass(),R.id.orderform_fl,null);
                            vp.setCurrentItem(AppConstants.TYPE_INVENTORY);
                        break;
                        case AppConstants.TYPE_ORDERFORM:
//                        FragmentUtils.addFragment(manager,cancelFragment.getClass(),R.id.orderform_fl,null);
                            vp.setCurrentItem(AppConstants.TYPE_ORDERFORM);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mOrderformTab));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
