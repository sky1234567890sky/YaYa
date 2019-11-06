package com.administrator.yaya.activity.orderform.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//已完成adapter
public class FinishAdapter extends RecyclerView.Adapter<FinishAdapter.Vh> {

    private List<TestAllOrderStock.DataBean.OrderSalesListBean> list;
    private FragmentActivity activity;

    public FinishAdapter(List<TestAllOrderStock.DataBean.OrderSalesListBean> list, FragmentActivity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.finish_item, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        TestAllOrderStock.DataBean.OrderSalesListBean orderStockListBean = list.get(i);
//        进货订单集合	orderSalesList
//        订单id		salesId
//        订单编号	orderNumber
        String orderNumber = orderStockListBean.getOrderNumber();
//        下单时间	salesBuildTime
//        数量		salesAmount
//        Object commodityAmount = orderStockListBean.getCommodityAmount();
//        应付金额	salesAmountMoney
//        收款方式	orderPayTpe		0无  1微信  2支付宝
//        状态		salesStatus		1售卖中 2 已完成 3已取消
//        操作时间	salesUpdateTime
        String orderBuildTime = orderStockListBean.getOrderNumber();
//        货物信息对象	commodity
//        货物名称	comName
//        货物单价	comPrice
//        货物图片	comImg
//        库存数量	comInventory
//        最小购买数量comPurchaseNumMin
//                最大购买数量comPurchaseNumMax
//        今日收款数		amount
//        vh.mFinishCommodityPrice.setText();
        vh.mFinishOrderNumber.setText("订单编号："+orderNumber);
        vh.mFinishOrderBuildTime.setText("收货时间："+orderBuildTime);
    }
    @Override
    public int getItemCount() {
        return list!=null ? list.size() : 0;
    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.finish_right_iv)
        ImageView mFinishRightIv;
        @BindView(R.id.finish_orderNumber)
        TextView mFinishOrderNumber;
        @BindView(R.id.finish_comImg)
        ImageView mFinishComImg;
        @BindView(R.id.finish_gcomName)
        TextView mFinishGcomName;
        @BindView(R.id.finish_commodityAmount)
        TextView mFinishCommodityAmount;
        @BindView(R.id.finish_commodityPrice)
        TextView mFinishCommodityPrice;
        @BindView(R.id.finish_orderBuildTime)
        TextView mFinishOrderBuildTime;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
