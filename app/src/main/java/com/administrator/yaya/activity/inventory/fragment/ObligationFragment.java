package com.administrator.yaya.activity.inventory.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.AffirmMessageActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.TestCancelOrderStock;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * 待付款
 */
public class ObligationFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.daifu_orderNumber)
    TextView mDaifuOrderNumber;
    @BindView(R.id.daifu_comImg)
    ImageView mDaifuComImg;
    @BindView(R.id.daifu_gcomName)
    TextView mDaifuGcomName;
    @BindView(R.id.daifu_pirce)
    TextView mDaifuPirce;
    @BindView(R.id.daifu_commodityAmount)
    TextView mDaifuCommodityAmount;
    @BindView(R.id.daifu_commodityPrice)
    TextView mDaifuCommodityPrice;
    @BindView(R.id.daifu_orderBuildTime)
    TextView mDaifuOrderBuildTime;
    @BindView(R.id.daifu_getGathering_btn)
    TextView mDaifuGetGatheringBtn;
    @BindView(R.id.daifu_cancel_orderform)
    TextView mDaifuCancelOrderform;

    private List<TestObligation.DataBean.OrderStockListBean> orderStockList;
    private TestObligation testObligation;
    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
//        货物名称	comName  爲空
//        mDaifuGcomName.setText(orderStockListBean.getPayerName());
//        货物单价	comPrice
//        货物图片	comImg
//        库存数量	comInventory
//        最小购买数量comPurchaseNumMin
//                最大购买数量comPurchaseNumMax
//        库存合计数量	amount
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_GATHERING:
                //待付款
                testObligation = (TestObligation) t[0];
                if (testObligation.getCode() == 0 && testObligation.getData() != null) {
                    TestObligation.DataBean data = testObligation.getData();
                    orderStockList = data.getOrderStockList();
                    TestObligation.DataBean.OrderStockListBean orderStockListBean = orderStockList.get(1);
                    String amount = testObligation.getData().getAmount();
                    mDaifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());
//        进货订单集合	orderStockList
//        订单编号	orderNumber
//        下单时间	orderBuildTime
                    mDaifuOrderBuildTime.setText("下单时间" + orderStockListBean.getOrderBuildTime());
//        数量		commodityAmount
                    mDaifuCommodityAmount.setText("数量：" + orderStockListBean.getCommodityAmount());
//        应付金额	commodityPrice
                    mDaifuCommodityPrice.setText("应付金额：" + orderStockListBean.getCommodityPrice());
                } else {
                    ToastUtil.showShort(testObligation.getMsg());
                }
                break;
                //取消进货订单
            case ApiConfig.TEST_CANCEL_ORDER_STOCK:
                TestCancelOrderStock testCancelOrderStock = (TestCancelOrderStock) t[0];
                if (testCancelOrderStock!=null && testCancelOrderStock.getCode() == 0){
                    ToastUtil.showShort(testCancelOrderStock.getMsg());
                }else{
                    ToastUtil.showShort(testCancelOrderStock.getMsg());
                }
                break;
        }
    }
    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId!=null)mPresenter.getData(ApiConfig.TEXT_GATHERING, Integer.parseInt(userId), 1);//待付款
    }
    @OnClick({R.id.daifu_getGathering_btn, R.id.daifu_cancel_orderform})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.daifu_getGathering_btn:
                Intent intent = new Intent(getActivity(), AffirmMessageActivity.class);
                intent.putExtra("orderNumber",testObligation.getData().getOrderStockList().get(1).getOrderNumber());
                startActivity(intent);
                break;
            case R.id.daifu_cancel_orderform:
                //取消进货订单
                if (testObligation.getData().getOrderStockList().get(1).getOrderNumber()!=null){
                    int stockId = testObligation.getData().getOrderStockList().get(1).getStockId();
                    mPresenter.getData(ApiConfig.TEST_CANCEL_ORDER_STOCK,stockId);///取消进货订单
                }
                break;
        }
    }

    public ObligationFragment() {
        // Required empty public constructor
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_obligation;
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return getPresenter();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

}
