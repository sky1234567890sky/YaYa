package com.administrator.yaya.activity.my.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestMyEarnings;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpendAdapter extends RecyclerView.Adapter<ExpendAdapter.Vh> {
    private final ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;
    private Context context;
    public ExpendAdapter(ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(context).inflate(R.layout.expend_item, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
//        orderId	订单编号
//        salesAmount	售卖数量
//        earningsAmount	收益数量
//        earningsType	收益类型--1收入-2支出-3返利
//        earningsTime	收益日期
        TestMyEarnings.DataBean.UserEarningsListBean userEarningsListBean = list.get(i);
        String orderId = userEarningsListBean.getOrderId();
        int salesAmount = userEarningsListBean.getSalesAmount();
        int earningsAmount = userEarningsListBean.getEarningsAmount();
        int earningsType = userEarningsListBean.getEarningsType();
        String createTime = userEarningsListBean.getEarningsTime();
        if (earningsType==1){
            vh.mExpendEarningsAmount.setText("+"+earningsAmount);
            vh.mExpendOrderId.setText("订单："+orderId);
            vh.mExpendEarningsTime.setText(createTime);
            vh.mExpendPutawaySalesAmount.setText("售卖数量："+salesAmount);
        }
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.expend_orderId)
        TextView mExpendOrderId;
        @BindView(R.id.expend_putaway_salesAmount)
        TextView mExpendPutawaySalesAmount;
        @BindView(R.id.expend_earningsAmount)
        TextView mExpendEarningsAmount;
        @BindView(R.id.expend_earningsTime)
        TextView mExpendEarningsTime;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
