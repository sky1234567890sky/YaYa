package com.administrator.yaya.activity.orderform;


import android.os.Bundle;
import android.security.AttestedKeyPair;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.adapter.FinishAdapter;
import com.administrator.yaya.activity.orderform.adapter.SellAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestFinish;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

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

    private FinishAdapter adapter;
    private List<TestAllOrderStock.DataBean.OrderStockListBean> list;

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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_finish;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new FinishAdapter(list,getActivity());
        mList.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId!=null) {
            mPresenter.getData(ApiConfig.TEST_FINISH, Integer.parseInt(userId), 2);
        }else{
            ToastUtil.showShort(R.string.networkerr+"");
        }
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_FINISH://已完成
                TestFinish testFinish = (TestFinish) t[0];
                Log.i("tag", "已完成: "+testFinish.toString());
                if (testFinish.getCode()==0 && testFinish.getData()!=null && testFinish.getData().getOrderStockList()!=null){
                    TestFinish.DataBean data = testFinish.getData();
//                    进货订单集合	orderSalesList
                    List<?> orderStockList = data.getOrderStockList();
//                    list.addAll(orderStockList);
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
//                            最大购买数量comPurchaseNumMax
//                    今日收款数		amount
//                    String amount = data.getAmount();
                }else{
                    ToastUtil.showShort(testFinish.getMsg());
                }
                break;
        }
    }
}
