package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.inventory.adapter.InventoryAdapter;
import com.administrator.yaya.activity.inventory.fragment.AccountPaidFragment;
import com.administrator.yaya.activity.inventory.fragment.ObligationFragment;
import com.administrator.yaya.base.ApiConfig;
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
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 库存
 */
public class InventoryFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.inventory_allgamemoneys)
    TextView inventoryMoney;

    @BindView(R.id.inventory_stab_layou)
    SlidingTabLayout mTab;
//    @BindView(R.id.inventory_stab_layou)
//    TabLayout mTab;
    @BindView(R.id.inventory_vp)
    ViewPager vp;

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private AccountPaidFragment accountPaidFragment;
    private ObligationFragment obligationFragment;
    private int mAmount;
    private int mAccountAmount;
    private int num = 1;

    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){

        }
    }

    @Override
    protected void initData() {
        super.initData();

        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId != null) mPresenter.getData(ApiConfig.TEXT_GATHERING, Integer.parseInt(userId), num);//已付款
    }
    @Override
    protected void initView(View inflate) {
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.blue));
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
//        mTab.setupWithViewPager(vp);
//        adapter.notifyDataSetChanged();
        mTab.setViewPager(vp);
        vp.setCurrentItem(0);
//        if (mTab.getTabCount() > 1) mTab.setCurrentTab(0);
        adapter.notifyDataSetChanged();
    }
    //接收订阅的事件
    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMsgEvent1(int amount){
    }

    @Override
    public void onStart() {
        super.onStart();
        //注册
        EventBus.getDefault().register(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        //取消注册
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void initListener() {
        super.initListener();
        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTabSelect(int position) {
                switch (position) {
                    case 0:
//                        accountPaidFragment.setAccountpaidOnclikListener(new AccountPaidFragment.AccountpaidOnclikListener() {
//                            @Override
//                            public void setonclik(String amount) {
//                                inventoryMoney.setText("游戏币库存合计：");
//                            }
//                        });
//                        ToastUtil.showShort(mAmount+"");
//                        inventoryMoney.setText("游戏币库存合计："+mAmount);
                        break;
                    case 1:
//                        ToastUtil.showShort(mAccountAmount+"");
//                        inventoryMoney.setText("游戏币库存合计："+mAccountAmount);
                        break;
                }
            }
            @Override
            public void onTabReselect(int position) {

            }
        });

    }
    //    }
//    private void initlistener() {
//        inventory_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0://代付款
//                        inventoryPayMoney.setVisibility(View.VISIBLE);
//                        inventoryBuyTime.setVisibility(View.VISIBLE);
//                        inventoryCancelBtn.setVisibility(View.VISIBLE);
//                        inventoryPayMoney.setVisibility(View.VISIBLE);
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


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_inventory;
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
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_GATHERING:
                TestObligation testObligation = (TestObligation) t[0];
                if (testObligation.getCode() == 0 && testObligation.getData() != null) {
                    String amount = testObligation.getData().getAmount();
                    inventoryMoney.setText("游戏币库存合计："+amount);
                }
                break;
                }
    }
}
