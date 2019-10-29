package com.administrator.yaya.fragment;
import android.app.Activity;
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
import com.administrator.yaya.base.BaseMvpActivity;
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
 * A simple {@link Fragment} subclass.
 */
public class OrderFormkFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

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
    public void onResponse(int whichApi, Object[] t) {

    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_formk;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.blue));
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
        if (tabLayout.getTabCount()>1)tabLayout.setCurrentTab(0);
        orderFormAdapter.notifyDataSetChanged();
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


}
