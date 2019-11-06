package com.administrator.yaya.activity.orderform.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.orderform.TestCancel;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CanaelAdapter extends RecyclerView.Adapter<CanaelAdapter.Vh> {
    private final List<TestCancel.DataBean.OrderSalesListBean> list;
    private final FragmentActivity activity;
    private TestCancel.DataBean data;

    public CanaelAdapter(List<TestCancel.DataBean.OrderSalesListBean> list, FragmentActivity activity) {
        this.list = list;
        this.activity = activity;
    }

    public void setData(TestCancel.DataBean data) {

        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.cancel_item, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        TestCancel.DataBean.OrderSalesListBean orderStockListBean = list.get(i);
        TestCancel.DataBean.CommodityBean commodity = data.getCommodity();
//        结果:
//        进货订单集合	orderSalesList
//        订单id		salesId
//        订单编号	orderNumber
//        下单时间	salesBuildTime
//        数量		salesAmount
//        应付金额	salesAmountMoney
//        收款方式	orderPayTpe		0无  1微信  2支付宝
//        状态		salesStatus		1售卖中 2 已完成 3已取消
//        操作时间	salesUpdateTime
//        货物信息对象	commodity
//        货物名称	comName
//        货物单价	comPrice
//        货物图片	comImg
//        库存数量	comInventory
//        最小购买数量comPurchaseNumMin
//                最大购买数量comPurchaseNumMax
//        今日收款数		amoun
        int salesStatus = orderStockListBean.getSalesStatus();
        if (salesStatus ==3 ||  orderStockListBean!=null) {//1售卖中 2 已完成 3已取消
            String salesUpdateTime = orderStockListBean.getSalesUpdateTime();
            String orderNumber = orderStockListBean.getOrderNumber();
            Object salesAmount = orderStockListBean.getSalesAmount();
            vh.mCancelOrderBuildTime.setText("取消时间：" + salesUpdateTime);
            int commodityPrice = orderStockListBean.getCommodityPrice();
            int orderPayTpe = orderStockListBean.getOrderPayTpe();
            int salesAmountMoney = orderStockListBean.getSalesAmountMoney();
            String salesBuildTime = orderStockListBean.getSalesBuildTime();
            vh.mCancelCommodityPrice.setText("售卖总价￥："+salesAmountMoney);
            String amount = data.getAmount();
            vh.mCancelGcomName.setText(amount);
            String comImg = commodity.getComImg();
            Glide.with(activity).load(comImg).into(vh.mCancelComImg);
            int comInventory = commodity.getComInventory();

        }
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


    public class Vh extends RecyclerView.ViewHolder{
        @BindView(R.id.cancel_right_iv)
        ImageView mCancelRightIv;
        @BindView(R.id.cancel_comImg)
        ImageView mCancelComImg;
        @BindView(R.id.cancel_gcomName)
        TextView mCancelGcomName;
        @BindView(R.id.cancel_commodityAmount)
        TextView mCancelCommodityAmount;
        @BindView(R.id.cancel_commodityPrice)
        TextView mCancelCommodityPrice;
        @BindView(R.id.cancel_orderBuildTime)
        TextView mCancelOrderBuildTime;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
