package com.administrator.yaya.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.InventoryAdapter;
import com.administrator.yaya.adapter.home.OrderFormAdapter;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.model.LoginModel;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 库存
 */
public class InventoryFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.inventory_money)
    TextView inventoryMoney;
    @BindView(R.id.inventory_tab_layout)
    SlidingTabLayout mTab;
    Unbinder unbinder;
    @BindView(R.id.inventory_vp)
    ViewPager vp;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initlistener();
        return view;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    private void initView() {
        /**
         * tablayout切换时有显示隐藏效果，在一个界面上
         *
         */
//        inventory_tab.addTab(inventory_tab.newTab().setText("待付款"));
//        inventory_tab.addTab(inventory_tab.newTab().setText("已收款"));

        titles = new ArrayList<>();
        titles.add("待付款");
        titles.add("已付款");

        fragments = new ArrayList<>();
        InventoryAdapter adapter = new InventoryAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        mTab.setViewPager(vp);
        vp.setCurrentItem(0);
        if (mTab.getTabCount() > 1) mTab.setCurrentTab(1);
        adapter.notifyDataSetChanged();
    }

    private void initlistener() {
//        inventory_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0://代付款
//                        inventoryPayMoney.setVisibility(View.VISIBLE);
//                        inventoryBuyTime.setVisibility(View.VISIBLE);
//                        inventoryCancelBtn.setVisibility(View.VISIBLE);
//                        inventoryPayMoney.setVisibility(View.VISIBLE);
//
//                        inventoryUpBtn.setVisibility(View.GONE);
//                        inventoryPayMoney2.setVisibility(View.GONE);
//                        break;
//                    case 1://已付款
//                        inventoryPayMoney.setVisibility(View.GONE);
//                        inventoryBuyTime.setVisibility(View.GONE);
//                        inventoryCancelBtn.setVisibility(View.GONE);
//                        inventoryPayMoney.setVisibility(View.GONE);
//                        inventoryUpBtn.setVisibility(View.VISIBLE);
//                        inventoryPayMoney2.setVisibility(View.VISIBLE);
//                        break;
//                }
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected LoginModel getModel() {
        return null;
    }

    @Override
    protected CommonPresenter getPresenter() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
