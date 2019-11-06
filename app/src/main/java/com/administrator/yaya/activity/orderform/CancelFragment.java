package com.administrator.yaya.activity.orderform;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.adapter.CanaelAdapter;
import com.administrator.yaya.activity.orderform.adapter.SellAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestCancel;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 已取消
 */
public class CancelFragment  extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.cancel_lv)
    RecyclerView mList;

    private List<TestCancel.DataBean.OrderSalesListBean> list;
    private CanaelAdapter adapter;

    public CancelFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_cancel, container, false);
//    }
@Override
public void onResponse(int whichApi, Object[] t) {
    switch (whichApi) {
        case ApiConfig.TEST_CANCEL://已取消
            TestCancel testCancel = (TestCancel) t[0];
            Log.i("tag", "已取消: "+testCancel.toString());
            if (testCancel.getCode()==0 && testCancel.getData()!=null && testCancel.getData().getOrderSalesList()!=null){
                TestCancel.DataBean data = testCancel.getData();
//                    进货订单集合	orderSalesList
                List<TestCancel.DataBean.OrderSalesListBean> orderStockList = data.getOrderSalesList();
                list.addAll(orderStockList);
                adapter.setData(testCancel.getData());
                adapter.notifyDataSetChanged();
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
//                    最大购买数量comPurchaseNumMax
//                    今日收款数		amount
//                    String amount = data.getAmount();
            }else{
                ToastUtil.showShort(testCancel.getMsg());
            }
            break;
    }
}
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new CanaelAdapter(list,getActivity());
        mList.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId!=null) {
            mPresenter.getData(ApiConfig.TEST_CANCEL, Integer.parseInt(userId), 3);
        }else{
            ToastUtil.showShort(R.string.networkerr+"");
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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cancel;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }


}
