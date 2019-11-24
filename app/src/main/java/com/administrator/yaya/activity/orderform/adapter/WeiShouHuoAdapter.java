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

public class WeiShouHuoAdapter extends RecyclerView.Adapter<WeiShouHuoAdapter.Vh> {

    private final List<TestCancel.DataBean.OrderSalesListBean> list;
    private final FragmentActivity activity;

    private TestCancel.DataBean data;
    private Context context;

    public WeiShouHuoAdapter(List<TestCancel.DataBean.OrderSalesListBean> list, FragmentActivity activity) {
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
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.weishouhuo_item, viewGroup, false);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, final int i) {
        TestCancel.DataBean.OrderSalesListBean orderStockListBean = list.get(i);
        TestCancel.DataBean.CommodityBean commodityBean = data.getCommodity();
        int salesStatus = orderStockListBean.getSalesStatus();
        if (salesStatus==2){
            int orderPayTpe = orderStockListBean.getOrderPayTpe();
            if (orderPayTpe == 1) {
                vh.weishouhuoOrderNumber.setText("【微信】订单编号：" + orderStockListBean.getOrderNumber());
            } else if (orderPayTpe == 2) {
                vh.weishouhuoOrderNumber.setText("【支付宝】订单编号：" + orderStockListBean.getOrderNumber());
            }
            double salesAmountMoney = orderStockListBean.getSalesAmountMoney();
            String salesBuildTime = orderStockListBean.getSalesBuildTime();
            vh.weishouhuoOrderBuildTime.setText("订单时间：" + salesBuildTime);
            vh.weishouhuoCommodityPrice.setText("售卖总价￥：" + salesAmountMoney);
            vh.weishouhuoGcomName.setText(commodityBean.getComName());
            String comImg = commodityBean.getComImg();
            Glide.with(activity).load(comImg).into(vh.weishouhuoComImg);
            int salesAmount = orderStockListBean.getSalesAmount();
            vh.weishouhuoCommodityAmount.setText("售卖数量：" + salesAmount);

            vh.weishouhuoZaiciQueren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cancelsetOnclikListener != null) {
                        cancelsetOnclikListener.setonclik(i);
                    }
                }
            });
        }else if (salesStatus==3){
            int orderPayTpe = orderStockListBean.getOrderPayTpe();
            if (orderPayTpe == 0){
                vh.weishouhuoOrderNumber.setVisibility(View.GONE);
            }else if (orderPayTpe == 1) {
                vh.weishouhuoOrderNumber.setText("【微信】订单编号：" + orderStockListBean.getOrderNumber());
            } else if (orderPayTpe == 2) {
                vh.weishouhuoOrderNumber.setText("【支付宝】订单编号：" + orderStockListBean.getOrderNumber());
            }
            double salesAmountMoney = orderStockListBean.getSalesAmountMoney();
            String salesBuildTime = orderStockListBean.getSalesBuildTime();
            vh.weishouhuoOrderBuildTime.setText("订单时间：" + salesBuildTime);
            vh.weishouhuoCommodityPrice.setText("售卖总价￥：" + salesAmountMoney);
            vh.weishouhuoGcomName.setText(commodityBean.getComName());
            String comImg = commodityBean.getComImg();
            Glide.with(activity).load(comImg).into(vh.weishouhuoComImg);
            int salesAmount = orderStockListBean.getSalesAmount();
            vh.weishouhuoCommodityAmount.setText("售卖数量：" + salesAmount);
            vh.weishouhuoRightIv.setVisibility(View.VISIBLE);
            vh.weishouhuoZaiciQueren.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
//    @Override
//    public int getItemViewType(int position) {
//
//        if (salesStatus == 2) {
//            return 2;
//        } else if (salesStatus == 3) {
//            return 3;
//        }
//        return super.getItemViewType(position);
//    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.weishouhuo_orderNumber)
        TextView weishouhuoOrderNumber;
        @BindView(R.id.weishouhuo_right_iv)
        ImageView weishouhuoRightIv;
        @BindView(R.id.weishouhuo_comImg)
        ImageView weishouhuoComImg;
        @BindView(R.id.weishouhuo_gcomName)
        TextView weishouhuoGcomName;
        @BindView(R.id.weishouhuo_commodityAmount)
        TextView weishouhuoCommodityAmount;
        @BindView(R.id.weishouhuo_commodityPrice)
        TextView weishouhuoCommodityPrice;
        @BindView(R.id.weishouhuo_orderBuildTime)
        TextView weishouhuoOrderBuildTime;
        @BindView(R.id.weishouhuo_zaici_queren)
        TextView weishouhuoZaiciQueren;

        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //未收货
    private CancelsetOnclikListener cancelsetOnclikListener;

    public interface CancelsetOnclikListener {
        void setonclik(int postion);
    }

    public void setCancelsetOnclikListener(CancelsetOnclikListener cancelsetOnclikListener) {
        this.cancelsetOnclikListener = cancelsetOnclikListener;
    }
}
