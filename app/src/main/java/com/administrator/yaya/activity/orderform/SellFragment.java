package com.administrator.yaya.activity.orderform;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.adapter.SellAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.TestCancelOrderStock;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestConfirmReceipt;
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
 * 售卖中
 */
public class SellFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.sell_lv)
    RecyclerView mList;
    @BindView(R.id.sell_refreshLayout)
    SmartRefreshLayout sellResh;
    private List<TestAllOrderStock.DataBean> list;
    private List<TestAllOrderStock.DataBean.OrderSalesListBean> listBean;
    private SellAdapter adapter;
    private int cancelIndex;
    private int num = 1;
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
        return R.layout.fragment_sell;
    }
    @Override
    public void onError(int whichApi, Throwable e) {

    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        listBean = new ArrayList<>();
        initRecycleView(mList,sellResh);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SellAdapter(listBean,list, getActivity());
        sellResh.setEnableLoadMore(false);
        mList.setAdapter(adapter);
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALL_ORDERSTOCK://售卖中
                if (listBean!=null && !listBean.isEmpty())listBean.clear();

                TestAllOrderStock testAllOrderStock = (TestAllOrderStock) t[0];
                if (testAllOrderStock.getCode() == 0 && testAllOrderStock.getData() != null && testAllOrderStock.getData().getCommodity() != null) {
                    TestAllOrderStock.DataBean data = testAllOrderStock.getData();
                    List<TestAllOrderStock.DataBean.OrderSalesListBean> orderSalesList = data.getOrderSalesList();
                    listBean.addAll(orderSalesList);
                    list.add(data);
                    String amount1 = data.getAmount();
                    adapter.notifyDataSetChanged();
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
                } else {
                    ToastUtil.showShort(testAllOrderStock.getMsg());
                }
                break;

            //取消进货订单
            case ApiConfig.TEST_CANCEL_ORDER_STOCK:
                TestCancelOrderStock testCancelOrderStock = (TestCancelOrderStock) t[0];

                if (testCancelOrderStock != null && testCancelOrderStock.getCode() == 0) {

                    ToastUtil.showShort(testCancelOrderStock.getMsg());

                    list.remove(cancelIndex);

                    adapter.notifyItemChanged(cancelIndex);//局部刷新
                } else {
                    ToastUtil.showShort(testCancelOrderStock.getMsg());
                }
                break;
            //确认收货
            case ApiConfig.TEST_CONFIRM_RECEIPT:
                TestConfirmReceipt testConfirmReceipt = (TestConfirmReceipt) t[0];
                if (testConfirmReceipt.getCode() == 0) {
                    ToastUtil.showShort(testConfirmReceipt.getMsg());

                } else {
                    ToastUtil.showShort(testConfirmReceipt.getMsg());
                }
                break;
        }
        sellResh.finishRefresh(2000);
    }

    @Override
    public void refresh() {
        super.refresh();
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
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId != null) {
            mPresenter.getData(ApiConfig.TEST_ALL_ORDERSTOCK, Integer.parseInt(userId), num);
        } else {

        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        //确认收款
        adapter.setAccountpaidsetOnclikListener(new SellAdapter.AccountpaidsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                mPresenter.getData(ApiConfig.TEST_CONFIRM_RECEIPT, listBean.get(postion).getSalesId());
            }
        });

        //取消進貨订单
        adapter.setCancelsetOnclikListener(new SellAdapter.CancelsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                cancelIndex =  postion;
                mPresenter.getData(ApiConfig.TEST_CANCEL_ORDER_STOCK, listBean.get(postion).getSalesId());
            }
        });
    }
}