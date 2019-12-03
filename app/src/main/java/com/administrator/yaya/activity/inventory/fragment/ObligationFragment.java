package com.administrator.yaya.activity.inventory.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.AffirmMessageActivity;
import com.administrator.yaya.activity.inventory.adapter.ObligationAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseApp;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.convert.BaseLazyLoadFragment;
import com.administrator.yaya.bean.TestCancelOrderStock;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 待付款
 */
public class ObligationFragment extends BaseLazyLoadFragment<LoginModel> implements ICommonView {

    @BindView(R.id.obligstion_list)
    RecyclerView mList;
    @BindView(R.id.abligation_refreshLayout)
    SmartRefreshLayout abligationRefreshLayout;
    List<TestObligation.DataBean.OrderStockListBean> list = new ArrayList<>();
    private ObligationAdapter adapter;
    private int num = 1;
    private BaseApp app;
    private TestObligation.DataBean data;
    private int index;
    private List<TestObligation.DataBean.CommodityBean> arrayList = new ArrayList<>();
    private String userId;
    private InventoryFragment parentFragment1;
    private TextView tvObligation;
    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
//        inventoryFragment = new InventoryFragment();
        super.initView(inflate);
        if (parentFragment1 == null) {
            setFragment();
        }
        initRecycleView(mList, abligationRefreshLayout);
        abligationRefreshLayout.setEnableLoadMore(false);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ObligationAdapter(arrayList, list, getActivity());
        mList.setAdapter(adapter);
//        mList.addItemDecoration(adapter);
//        货物名称	comName  爲空
//        mDaifuGcomName.setText(orderStockListBean.getPayerName());
//        货物单价	comPrice
//        货物图片	comImg
//        库存数量	comInvent  ory
//        最小购买数量comPurchaseNumMin
//                最大购买数量comPurchaseNumMax
//        库存合计数量	amount
    }

    private void setFragment() {
        Fragment parentFragment = getParentFragment();
        parentFragment1 = (InventoryFragment) parentFragment;//父 Fragment
//        if (isVisibleToUser ==true){//当前处于可见状态
        if (parentFragment instanceof InventoryFragment) {
            // 父 TestView
//            if (parentFragment1.getView().findViewById(R.id.inventory_allgamemoneys) != null) {
//                tvObligation = parentFragment1.getView().findViewById(R.id.inventory_allgamemoneys);
//            }
        }
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_GATHERING:
                //获取父Fragment控件
                TestObligation testObligation = (TestObligation) t[0];
                data = testObligation.getData();

                if (tvObligation != null) {
                    if (TextUtils.isEmpty(data.getAmount())) {
                        tvObligation.setText("游戏币库存合计：0");//库存  父 Fragment 顶部赋值
                    } else {
                        tvObligation.setText("游戏币库存合计：" + data.getAmount());//库存  父 Fragment 顶部赋值
                    }
                }
                if (testObligation.getCode() == 0) {
                    TestObligation.DataBean dataBean = testObligation.getData();
                    TestObligation.DataBean.CommodityBean commodity = testObligation.getData().getCommodity();
                    arrayList.add(commodity);
                    List<TestObligation.DataBean.OrderStockListBean> orderStockList = dataBean.getOrderStockList();
                    if (list != null && list.size() != 0) list.clear();//
                    list.addAll(orderStockList);
                    adapter.notifyDataSetChanged();
                }
                break;
            //取消售卖订单（不用）
//            case ApiConfig.TEST_CANCEL_ORDER_SALES:
//                TestCancelOrderStock testCancelOrderStock = (TestCancelOrderStock) t[0];
//                if (testCancelOrderStock.getCode()==0){
//                    ToastUtil.showLong(testCancelOrderStock.getMsg());
//                    //清空条目
//                    list.remove(index);
//                    adapter.notifyItemRemoved(index);
//                    ToastUtil.showLong(testCancelOrderStock.getMsg());
//                }else{
//                    ToastUtil.showLong(testCancelOrderStock.getMsg());
//                }
//                break;
        }
        abligationRefreshLayout.finishRefresh();//数据回来后一秒刷新
        abligationRefreshLayout.finishLoadMore();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(R.string.error+"");
    }
    @Override
    protected void initData() {
//        if (!list.isEmpty() || list!=null)list.clear();
        userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        int anInt = Integer.parseInt(userId);
        if (userId != null) {
            mPresenter.getData(ApiConfig.TEXT_GATHERING, anInt, num);//待付款
        }
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_obligation;
    }
    //懒加载加载数据
    @Override
    public void fetchData() {
        refresh();
    }

    @Override
    public void refresh() {
        super.refresh();
        //自动回弹
        abligationRefreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                abligationRefreshLayout.finishRefresh();

            }
        }, 200l);
        mList.scrollToPosition(0);
        //进入刷新
//        abligationRefreshLayout.autoRefresh();
        initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        //暂时不用
//        adapter.setAccountpaidsetOnclikListener(new ObligationAdapter.AccountpaidsetOnclikListener() {
//            @Overr
//            public void setonclik(int postion) {
//                index = postion;
//                int stockId = list.get(postion).getStockId();
//                //订单-取消售卖订单  無
//                mPresenter.getData(ApiConfig.TEST_CANCEL_ORDER_SALES, stockId);
//            }
//        });
        //跳转至确认信息
        adapter.setAccountpaidTosetOnclikListener(new ObligationAdapter.AccountpaidTosetOnclikListener() {
            @Override
            public void setonclik(int index) {
                Intent intent = new Intent(getActivity(), AffirmMessageActivity.class);
                String orderNumber = list.get(index).getOrderNumber();
//                Log.i("tag", "订单编号1: "+orderNumber);
                intent.putExtra("OrderNumber", orderNumber);
                startActivity(intent);
            }
        });
    }

    public ObligationFragment() {

    }

    //获取焦点时刷新
    @Override
    public void onResume() { //在最前端显示
        super.onResume();
//        Log.i("tag", "\"刷新数据1\"");
        //每次进入这个页面就刷新
        if (isRefresh) {
            if (!list.isEmpty()) {
                list.clear();
            }
            refresh();
            isRefresh = false;
        }

    }

    @Override
    public void onPause() {//不在最前端显示
        super.onPause();

        if (!isRefresh) isRefresh = true;

//        Log.i("tag", "\"刷新数据1.1\"");

    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    //接口回调
    private InventorysetOnclikListener inventorysetOnclikListener;

    public interface InventorysetOnclikListener {
        void setonclik(String amount);
    }

    public void setInventorysetOnclikListener(InventorysetOnclikListener inventorysetOnclikListener) {
        this.inventorysetOnclikListener = inventorysetOnclikListener;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}