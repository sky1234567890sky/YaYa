package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.InventoryAdapter;
import com.administrator.yaya.activity.inventory.fragment.AccountPaidFragment;
import com.administrator.yaya.activity.inventory.fragment.ObligationFragment;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseFragment;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 库存
 */
public class InventoryFragment extends BaseFragment {

    @BindView(R.id.inventory_allgamemoneys)
    TextView inventoryMoney;
    @BindView(R.id.inventory_stab)
    SlidingTabLayout mTab;
    @BindView(R.id.inventory_vp)
    ViewPager vp;

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private AccountPaidFragment accountPaidFragment;
    private ObligationFragment obligationFragment;
    @Override
    public void initData() {
        super.initData();
    }

    @Override
    protected void initView(View inflate) {
        titles = new ArrayList<>();
        titles.add("待付款");
        titles.add("已付款");
        fragments = new ArrayList<>();
        accountPaidFragment = new AccountPaidFragment();
        obligationFragment = new ObligationFragment();

        fragments.add(obligationFragment);
        fragments.add(accountPaidFragment);

        InventoryAdapter adapter = new InventoryAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        mTab.setViewPager(vp);
        vp.setCurrentItem(0);

//        if (mTab.getTabCount() > 1) mTab.setCurrentTab(0);//大于一是因为多个fragment
//        if (mTab.getTabCount() > 1) mTab.setCurrentTab(0);
        adapter.notifyDataSetChanged();
    }
//    //接收订阅的事件
//    @SuppressLint("SetTextI18n")
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMsgEvent1(String amount) {
//            if(amount!=null) {
//                EventBus.getDefault().postSticky(amount);
//                if(inventoryMoney!=null){
//                inventoryMoney.setText("游戏币库存合计：" + amount);
//                Log.i("tag", "待付款游戏币库存合计amount:"+amount);
//            }else {
//                inventoryMoney.setText("游戏币库存合计：0");
//            }
//        }
//    }
    @Override
    protected void initListener() {
        super.initListener();

//        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0:
//                        getFragmentManager().beginTransaction().replace(R.id.inventory_fragment,obligationFragment).commit();
//                        break;
//                    case 1:
//                        getFragmentManager().beginTransaction().replace(R.id.inventory_fragment,accountPaidFragment).commit();
//                        break;
//                }
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });

//        mTab.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                switch (position) {
//                    case 0:
//                        new ObligationFragment().setInventorysetOnclikListener(new ObligationFragment.InventorysetOnclikListener() {
//                            @SuppressLint("SetTextI18n")
//                            @Override
//                            public void setonclik(String amount) {
//                                if (amount == null) {
////                                    Log.i("====", "setonclik: ===");
//                                    inventoryMoney.setText("游戏币库存合计：0");
//                                } else {
////                                    Log.i("====", "setonclik: ----");
//                                    inventoryMoney.setText("游戏币库存合计：" + amount);
//                                }
//                            }
//                        });
//                        break;
//                    case 1:
//                        new AccountPaidFragment().setAccountPaidsetOnclikListener(new AccountPaidFragment.AccountPaidsetOnclikListener() {
//                            @SuppressLint("SetTextI18n")
//                            @Override
//                            public void setonclik(String amount) {
//                                if (amount == null) {
//                                    inventoryMoney.setText("游戏币库存合计：0");
//                                } else {
//                                    inventoryMoney.setText("游戏币库存合计：" + amount);
//                                }
//                            }
//                        });
//                        break;
//                }
//            }
//            @Override
//            public void onTabReselect(int position) {
//
//            }

//        });
    }
        @Override
        protected int getLayoutId () {
            return R.layout.fragment_inventory;
        }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (getActivity() != null && !hidden) {
//            Log.i("tag", "刷新数据2: ");
            initData();
        }
    }
}