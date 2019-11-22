package com.administrator.yaya.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.home.AffirmMessageActivity;
import com.administrator.yaya.activity.inventory.adapter.TestInventoryAdapter;
import com.administrator.yaya.activity.inventory.fragment.AccountPaidFragment;
import com.administrator.yaya.activity.inventory.fragment.ObligationFragment;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestInventory;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 库存
 */
public class InventoryFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.invite_lv)
    RecyclerView mList;
    @BindView(R.id.invite_refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    ArrayList<TestInventory.DataBean.OrderStockListBean> list = new ArrayList<>();
    @BindView(R.id.inventory_number)
    TextView mKeYong;
    @BindView(R.id.inventory_sell_number)
    TextView mSell;
    @BindView(R.id.inventory_yisell_number)
    TextView mYiSell;
//    @BindView(R.id.inventory_allgamemoneys)
//    TextView inventoryMoney;
//    @BindView(R.id.inventory_stab)
//    SlidingTabLayout mTab;
//    @BindView(R.id.inventory_vp)
//    ViewPager vp;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private AccountPaidFragment accountPaidFragment;
    private ObligationFragment obligationFragment;
    private TestInventoryAdapter adapter;
    private TestInventory.DataBean data;
    private String userId;
    private String token;
    public static  final  String FORM_INVENTORY="FORM_INVENTORY";//区分待付款
    public static final String  FORM_INVENTORY2="FORM_INVENTORY2";//区分已付款
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser == true) {
            if (mRefreshLayout != null) {
                refresh();
            }
        }
    }
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_inventory;
    }
    @Override
    public void initData() {
        super.initData();
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);
        mPresenter.getData(ApiConfig.TEST_INVENTORY, Integer.parseInt(userId),token);
    }

    @Override
    public void refresh() {
        super.refresh();
        //下拉刷新，添加你刷新后的逻辑
        //加载完成时，隐藏控件下拉刷新的状态

        mRefreshLayout.autoRefresh();

        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();
        //上拉加载更多，添加你加载数据的逻辑
        //加载完成时，隐藏控件上拉加载的状态
//        mRefreshLayout.computeScroll();
    }
    @Override
    protected void initView(View inflate) {
//        titles = new ArrayList<>();
//        titles.add("待付款");
//        titles.add("已付款");
//        fragments = new ArrayList<>();
//        accountPaidFragment = new AccountPaidFragment();
//        obligationFragment = new ObligationFragment();
//        fragments.add(obligationFragment);
//        fragments.add(accountPaidFragment);
//        InventoryAdapter adapter = new InventoryAdapter(getChildFragmentManager(), fragments, titles);
//        vp.setAdapter(adapter);
//        mTab.setViewPager(vp);
//        vp.setCurrentItem(0);
//        if (mTab.getTabCount() > 1) mTab.setCurrentTab(0);//大于一是因为多个fragment
//        if (mTab.getTabCount() > 1) mTab.setCurrentTab(0);
//        adapter.notifyDataSetChanged();

        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRefreshLayout.setEnableLoadMore(false);
        initRecycleView(mList, mRefreshLayout);
//        new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        adapter = new TestInventoryAdapter(list);
        mList.setAdapter(adapter);
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
    public void onError(int whichApi, Throwable e) {

    }

//    库存列表
///yayaApp/comBuy/allOrderStock
//    参数：
//    userId	用户id
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
//            http://192.168.0.198:8082/yayaApp/comBuy/allOrderStock
            case ApiConfig.TEST_INVENTORY:
                if (!list.isEmpty())list.clear();

                TestInventory testInventory = (TestInventory) t[0];


                if (testInventory.getCode() == 0) {

                    if (testInventory.getMsg()==SignOut){

                        ToastUtil.showLong(R.string.username_login_hint+"");

                        Intent intent = new Intent(getActivity(), LoginActivity.class);

                        startActivity(intent);

                    }else {
                        Log.i("tag", "库存数据: " + testInventory.toString());
                        data = testInventory.getData();
                        TestInventory.DataBean.CommodityBean commodity = data.getCommodity();
                        List<TestInventory.DataBean.OrderStockListBean> orderStockList = data.getOrderStockList();
                        mKeYong.setText(data.getUserAllCount() + "");//可用库存
                        mSell.setText(data.getUserSalesCount() + "");//售卖中
                        mYiSell.setText(data.getUserDoneCount() + "");//已售卖
                        adapter.setData(data.getCommodity());//货物信息对象	commodity

                        list.addAll(orderStockList);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
        mRefreshLayout.finishRefresh();
    }
    @Override
    protected void initListener() {
        super.initListener();
        //已付款
        adapter.setAccountpaidTosetOnclikListener(new TestInventoryAdapter.AccountpaidTosetOnclikListener() {
            @Override
            public void setonclik(int index) {
                Intent intent = new Intent(getActivity(), AffirmMessageActivity.class);
                String orderNumber = list.get(index).getOrderNumber();
//                Log.i("tag", "订单编号1: "+orderNumber);
//                intent.putExtra(FORM_INVENTORY2,FORM_INVENTORY2);
                intent.putExtra("accountPaid", orderNumber);
                startActivity(intent);
            }
        });

        //待付款
        adapter.setObligationTestOnclikListener(new TestInventoryAdapter.ObligationTestOnclikListener() {
            @Override
            public void setonclik(int index) {
                Intent intent = new Intent(getActivity(), AffirmMessageActivity.class);
                String orderNumber = list.get(index).getOrderNumber();
//                Log.i("tag", "订单编号1: "+orderNumber);
//                intent.putExtra(FORM_INVENTORY,FORM_INVENTORY);
                intent.putExtra("OrderNumber", orderNumber);
                startActivity(intent);
            }
        });

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
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity() != null && !hidden) {
//            Log.i("tag", "刷新数据2: ");
            initData();
            if (mRefreshLayout!=null){
                refresh();
            }
        }
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

}