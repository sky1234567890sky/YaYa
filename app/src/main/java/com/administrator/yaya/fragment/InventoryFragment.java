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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.administrator.yaya.bean.invite.TestInvitory2;
import com.administrator.yaya.bean.invite.TestUserCount;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    ArrayList<TestInvitory2> list = new ArrayList<>();
    @BindView(R.id.inventory_number)
    TextView mKeYong;
    @BindView(R.id.inventory_sell_number)
    TextView mSell;

    @BindView(R.id.inventory_yisell_number)
    TextView mYiSell;

    @BindView(R.id.invite_no_datas)
    LinearLayout invite_no_datas;

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
    private String userId;
    private String token;
//    public static final String FORM_INVENTORY = "FORM_INVENTORY";//区分待付款
//    public static final String FORM_INVENTORY2 = "FORM_INVENTORY2";//区分已付款
//    private List<TestInventory.DataBean.OrderStockListBean> orderStockList;
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
//        showLoadingDialog();
        userId = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);

        mPresenter.getData(ApiConfig.TEST_INVENTORY, Integer.parseInt(userId), token);

        //库存总数
        mPresenter.getData(ApiConfig.TEST_USER_COUNT,Integer.parseInt(userId));

        if (list.isEmpty()) {
            mRefreshLayout.setVisibility(View.GONE);
            invite_no_datas.setVisibility(View.VISIBLE);//无数据占位图片显示
        } else {
            mRefreshLayout.setVisibility(View.VISIBLE);
            invite_no_datas.setVisibility(View.GONE);//无数据占位图片隐藏
        }

    }
    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(R.string.error+"");
    }

    @Override
    public void refresh() {
        super.refresh();
        //自动回弹
        mRefreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.finishRefresh();
                initData();
            }
        }, 200l);
        mList.scrollToPosition(0);
        //下拉刷新，添加你刷新后的逻辑
        //加载完成时，隐藏控件下拉刷新的状态
//        mRefreshLayout.autoRefresh();
        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();


        mRefreshLayout.finishLoadMoreWithNoMoreData();

        mRefreshLayout.setNoMoreData(true);
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
        mList.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
//        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRefreshLayout.setEnableLoadMore(false);
        initRecycleView(mList, mRefreshLayout);
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


    //    库存列表
///yayaApp/comBuy/allOrderStock
//    参数：
//    userId	用户id
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
//        hideLoadingDialog();

        switch (whichApi) {
//            http://192.168.0.198:8082/yayaApp/comBuy/allOrderStock

            //库存总数
            case ApiConfig.TEST_USER_COUNT:
                TestUserCount testUserCount = (TestUserCount) t[0];
                if (testUserCount.getCode()==0){
                    TestUserCount.DataBean data = testUserCount.getData();
                    TestUserCount.DataBean.CommodityBean commodity = data.getCommodity();
//                    所有可用库存 userAllCount
//                    今日已售数量  amount
//                    库存数量 comInventory
                    int userAllCount = data.getUserAllCount();
                    int amount = data.getAmount();
                    if (userAllCount>0){
                        mKeYong.setText(userAllCount + "");//可用库存
                    }

                    if (amount>0){
                        mYiSell.setText(amount+ "");//已售卖
                    }
//                    comInventory库存中数量
                    if (commodity.getComInventory()<0){
                        mSell.setText(commodity.getComInventory() + "");//售卖中
                    }
                    adapter.setData(testUserCount.getData().getCommodity());
                }
                break;
                //库存列表
            case ApiConfig.TEST_INVENTORY:
                if (!list.isEmpty()) list.clear();
                TestInventory testInventory = (TestInventory) t[0];
                if (testInventory.getMsg().equals(SignOut)) {
                    Toast.makeText(getActivity(), R.string.username_login_hint +"", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();

                }else if (testInventory.getCode() == 0 && !testInventory.getMsg().equals(SignOut)) {
                    Log.i("tag", "库存数据: " + testInventory.toString());
//                    货物名称	comName
//                    货物单价	comPrice
//                    货物图片	comImg
//                    data = testInventory.getData();
//                    orderStockList = data.getOrderStockList();
//                    adapter.setData(data.getCommodity());//货物信息对象	commodity
                    Gson gson = new Gson();
                    String testInvitory = gson.toJson(testInventory, TestInventory.class);
                    String testInventorys1 = testInvitory.replaceAll("\"\\[","[");
                    String testInventorys2 = testInventorys1.replaceAll("\\]\"","]");
                    String testInventorys3 = testInventorys2.replaceAll("\\\\","");
                    List<TestInvitory2> channelBeanList = new ArrayList<>();
                    try {
                        JSONObject object = new JSONObject(testInventorys3.toString());
                        JSONArray jsonArray = object.getJSONArray("msg");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            TestInvitory2 testInvitory2 = new TestInvitory2();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Integer stockId = jsonObject.optInt("stockId");
                            Integer orderStatus = jsonObject.optInt("orderStatus");
                            String orderNumber = jsonObject.optString("orderNumber");
                            String orderBuildTime = jsonObject.optString("orderBuildTime");
                            Integer commodityAmount = jsonObject.optInt("commodityAmount");
                            double commodityPrice = jsonObject.optDouble("commodityPrice");
                            testInvitory2.setStockId(stockId);
                            testInvitory2.setOrderStatus(orderStatus);
                            testInvitory2.setOrderNumber(orderNumber);
                            testInvitory2.setOrderBuildTime(orderBuildTime);
                            testInvitory2.setCommodityAmount(commodityAmount);
                            testInvitory2.setCommodityPrice(commodityPrice);
                            channelBeanList.add(testInvitory2);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }




                    list.addAll(channelBeanList);
                    adapter.notifyDataSetChanged();

                    if (list.isEmpty()){
                        mRefreshLayout.setVisibility(View.GONE);
                        invite_no_datas.setVisibility(View.VISIBLE);//无数据占位图片显示
                    } else {
                        mRefreshLayout.setVisibility(View.VISIBLE);
                        invite_no_datas.setVisibility(View.GONE);//无数据占位图片隐藏
                    }
                }

                break;
        }
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadMore();
    }

    public String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        return in;
    }

    @Override
    protected void initListener() {
        super.initListener();
        //已付款
        adapter.setAccountpaidTosetOnclikListener(new TestInventoryAdapter.AccountpaidTosetOnclikListener() {
            @Override
            public void setonclik(int index) {
                String orderNumber = list.get(index).getOrderNumber();
                if (!orderNumber.equals("") && !orderNumber.isEmpty()) {
                    Intent intent = new Intent(getActivity(), AffirmMessageActivity.class);
                    Log.i("tag", "订单编号1: " + orderNumber);
//                intent.putExtra(FORM_INVENTORY2,FORM_INVENTORY2);
                    intent.putExtra("accountPaid", orderNumber);

                    startActivity(intent);
                }
            }
        });
        //待付款
        adapter.setObligationTestOnclikListener(new TestInventoryAdapter.ObligationTestOnclikListener() {
            @Override
            public void setonclik(int index) {
                String orderNumber = list.get(index).getOrderNumber();
                if (!orderNumber.equals("") && !orderNumber.isEmpty()) {
                    Intent intent = new Intent(getActivity(), AffirmMessageActivity.class);
//                Log.i("tag", "订单编号1: "+orderNumber);
//                intent.putExtra(FORM_INVENTORY,FORM_INVENTORY);
                    intent.putExtra("OrderNumber", orderNumber);
                    startActivity(intent);
                }

            }
        });

        invite_no_datas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invite_no_datas.setVisibility(View.VISIBLE);
                mRefreshLayout.setVisibility(View.GONE);//无数据占位图片隐藏
//                }//

                refresh();

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
            if (mRefreshLayout != null) {
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