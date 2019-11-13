package com.administrator.yaya.activity.orderform;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.adapter.FinishAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.base.convert.BaseLazyLoadFragment;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
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
 * A simple {@link Fragment} subclass.
 * 已完成
 */
public class FinishFragment  extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.finish_lv)
    RecyclerView mList;
    @BindView(R.id.finish_refreshLayout)
    SmartRefreshLayout finishRefresh;
    private FinishAdapter adapter;
    private List<TestAllOrderStock.DataBean.OrderSalesListBean> list;
    private List<TestAllOrderStock.DataBean.CommodityBean> listCommodityBean;
    private OrderFormkFragment parentFragment1;
    private TestAllOrderStock.DataBean data;
    private TextView tvObligation;

    public FinishFragment() {
        // Required empty public constructor
    }
    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    //判断是否展示—与ViewPager连用，进行左右切换
    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
            //不可见的时候关闭加载
        if (isVisibleToUser ==true){//当前处于可见状态
            if (finishRefresh != null)
                refresh();
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_finish;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        if(parentFragment1== null){
            getFragment();
        }

        list = new ArrayList<>();
        listCommodityBean = new ArrayList<>();
        initRecycleView(mList,finishRefresh);
        finishRefresh.setEnableLoadMore(false);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FinishAdapter(listCommodityBean,list,getActivity());
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

    @Override
    protected void initData() {
        super.initData();
        //已完成
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId != null) {
            mPresenter.getData(ApiConfig.TEST_ALL_ORDERSTOCK, Integer.parseInt(userId), 2);
        } else {
            ToastUtil.showShort(R.string.networkerr + "");
        }
    }

    @Override
    public void refresh() {
        super.refresh();

        finishRefresh.autoRefresh();

        initData();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALL_ORDERSTOCK://已完成
                if (list!=null&& !list.isEmpty())list.clear();
                TestAllOrderStock testFinish = (TestAllOrderStock) t[0];
                Log.i("tag", "已完成: " + testFinish.toString());

                if (testFinish.getCode() == 0 && testFinish.getData() != null && testFinish.getData().getOrderSalesList() != null) {
//                    进货订单集合	orderSalesList

                    data = testFinish.getData();
                    if (TextUtils.isEmpty(data.getAmount())) {
                        tvObligation.setText("今日所收游戏币：0");//库存  父 Fragment 顶部赋值
                    } else {
                        tvObligation.setText("今日所收游戏币：" +data.getAmount());//库存  父 Fragment 顶部赋值
                    }


                    String amount = data.getAmount();
                    List<TestAllOrderStock.DataBean.OrderSalesListBean> orderStockList = data.getOrderSalesList();
                    listCommodityBean.add(data.getCommodity());
                    list.addAll(orderStockList);
                    adapter.notifyDataSetChanged();

                    if(data.getAmount()!=null) {
                        EventBus.getDefault().postSticky(data.getAmount());
                    }
//                    EventBus.getDefault().postSticky(amount);
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
//                    String amount = data.getAmount();
                } else {
                    ToastUtil.showShort(testFinish.getMsg());
                }
                break;
        }
        finishRefresh.finishRefresh();
    }

    //获取焦点时刷新
    @Override
    public void onResume() {
        super.onResume();

        if (isRefresh) {

            if (!list.isEmpty()){

                list.clear();

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

}