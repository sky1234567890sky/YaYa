package com.administrator.yaya.activity.orderform;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.orderform.adapter.SellAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.convert.BaseLazyLoadFragment;
import com.administrator.yaya.bean.TestCancelOrderStock;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestConfirmReceipt;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.fragment.OrderFormkFragment;
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
 * 全部
 */
public class AllFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.sell_lv)
    RecyclerView mList;
    @BindView(R.id.sell_refreshLayout)
    SmartRefreshLayout sellResh;

    private List<TestAllOrderStock.DataBean> list;
    private List<TestAllOrderStock.DataBean.OrderSalesListBean> listBean;
    private SellAdapter adapter;
    private int cancelIndex;
    private int num = 1;
    private OrderFormkFragment parentFragment1;
    private TestAllOrderStock.DataBean data;
    private TextView tvObligation;
    private String token;
    private String userId;

    //判断是否展示—与ViewPager连用，进行左右切换

    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser == true) {//当前处于可见状态
            if (sellResh != null)
                refresh();
        }
    }

    //处于可见
    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof OrderFormkFragment) {
            parentFragment1 = (OrderFormkFragment) parentFragment;
        }
        return R.layout.fragment_sell;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        if (parentFragment1 == null) {
            getFragment();
        }
        list = new ArrayList<>();
        listBean = new ArrayList<>();
        initRecycleView(mList, sellResh);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SellAdapter(listBean, list, getActivity());
        sellResh.setEnableLoadMore(false);
        mList.setAdapter(adapter);

    }

    private void getFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof OrderFormkFragment) {
            parentFragment1 = (OrderFormkFragment) parentFragment;//父 Fragment
            // 父 TestView
            if (parentFragment1.getView().findViewById(R.id.orderform_inventory_money) != null) {
                tvObligation = parentFragment1.getView().findViewById(R.id.orderform_inventory_money);
            }
        }
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALL_ORDERSTOCK://售卖中
                if (listBean != null && !listBean.isEmpty()) listBean.clear();

                TestAllOrderStock testAllOrderStock = (TestAllOrderStock) t[0];

//                TextView tv_order_money = parentFragment1.getView().findViewById(R.id.orderform_inventory_money);
//                tv_order_money.setText(testAllOrderStock.getData().getAmount());
                if (testAllOrderStock.getCode() == 0 && testAllOrderStock.getData() != null && testAllOrderStock.getData().getCommodity() != null) {
                    //登陆状态其他设备登陆该账号就不能用了得重新登陆
                    if (testAllOrderStock.getMsg().equals(SignOut)) {
                        ToastUtil.showLong(R.string.username_login_hint + "");
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    } else {
                        data = testAllOrderStock.getData();
                        if (tvObligation != null) {

                            if (TextUtils.isEmpty(data.getAmount())) {
                                tvObligation.setText("今日所收游戏币：0");//库存  父 Fragment 顶部赋值
                            } else {
                                tvObligation.setText("今日所收游戏币：" + data.getAmount());//库存  父 Fragment 顶部赋值
                            }
                        }
                        List<TestAllOrderStock.DataBean.OrderSalesListBean> orderSalesList = data.getOrderSalesList();
                        listBean.addAll(orderSalesList);
                        list.add(data);
                        String amount1 = data.getAmount();
                        adapter.notifyDataSetChanged();
//                    if(data.getAmount()!=null) {
//                        EventBus.getDefault().postSticky(data.getAmount());
//                    }

//                    进货订单集合	orderSalesList
//                    EventBus.getDefault().postSticky(amount1);
//                    订单id		salesId
//                    订单编号	orderNumber
//                    下单时间	salesBuildTime
//                    数量		salesAmount
//                    应付金额	salesAmountMoney
//                    收款方式	orderPayTpe		0无  1微信  2支付宝
//                    状态		salesStatus		1售卖中 2 已完成 3已取消
//                    操作时间	salesUpdateTime
//                    货物信息对象	commodity
//                    Object commodity = data.getCommodity();
//                    货物名称	comName
//                    货物单价	comPrice
//                    货物图片	comImg
//                    库存数量	comInventory
//                    最小购买数量comPurchaseNumMin
//                            最大购买数量comPurchaseNumMax
//                    今日收款数		amount
                    }
                }
                break;
            //取消进货订单
            case ApiConfig.TEST_CANCEL_ORDER_SALES:
                TestCancelOrderStock testCancelOrderStock = (TestCancelOrderStock) t[0];

                if (testCancelOrderStock.getMsg()==SignOut){
                    ToastUtil.showLong(R.string.username_login_hint+"");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    return;
                }

                if (testCancelOrderStock.getCode() == 0) {
                    ToastUtil.showLong(testCancelOrderStock.getMsg());
                    refresh();
                }

                break;
            //确认收货(确认收款)
            case ApiConfig.TEST_CONFIRM_RECEIPT:
                TestConfirmReceipt testConfirmReceipt = (TestConfirmReceipt) t[0];

                if (testConfirmReceipt.getMsg()==SignOut){
                    ToastUtil.showLong(R.string.username_login_hint+"");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    return;
                }

                if (testConfirmReceipt.getCode() == 0) {
                    ToastUtil.showShort(testConfirmReceipt.getMsg());
                } else {
                    ToastUtil.showShort(testConfirmReceipt.getMsg());
                }

                //刷新
                refresh();

                break;
        }
        sellResh.finishRefresh();
    }

    @Override
    public void refresh() {
        super.refresh();
        //加载
        sellResh.autoRefresh();

        initData();

    }

    @Override
    public void loadMore() {
        super.loadMore();

    }
    @Override
    protected void initData() {
        super.initData();
        //售賣中
            userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
            token = SharedPrefrenceUtils.getString(getActivity(), NormalConfig.TOKEN);
            mPresenter.getData(ApiConfig.TEST_ALL_ORDERSTOCK, Integer.parseInt(userId),num,token);
    }
    @Override
    protected void initListener() {
        super.initListener();
        //确认收款
        adapter.setAccountpaidsetOnclikListener(new SellAdapter.AccountpaidsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                mPresenter.getData(ApiConfig.TEST_CONFIRM_RECEIPT, listBean.get(postion).getSalesId(),Integer.parseInt(userId),token);
            }
        });
        //取消進貨订单
        adapter.setCancelsetOnclikListener(new SellAdapter.CancelsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                cancelIndex = postion;
                mPresenter.getData(ApiConfig.TEST_CANCEL_ORDER_SALES, listBean.get(postion).getSalesId());
            }
        });
    }
    //获取焦点时刷新
    @Override
    public void onResume() {
        super.onResume();
        if (isRefresh) {
            if (!listBean.isEmpty()) {
                listBean.clear();
            }
            refresh();
            isRefresh = false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (!isRefresh) isRefresh = true;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && getActivity()!=null){
            if (sellResh != null)
                refresh();
        }
    }
}