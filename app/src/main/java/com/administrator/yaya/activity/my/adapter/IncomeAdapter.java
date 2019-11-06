package com.administrator.yaya.activity.my.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestMyEarnings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.Vh> {


    private List<TestMyEarnings.DataBean.UserEarningsListBean> list;
    private Context context;

    public IncomeAdapter(ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list) {

        this.list = list;
    }
    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.income_item, null);
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
            vh.mMyincomeEarningsAmount.setText("+"+earningsAmount);
            vh.mMyincomeOrderId.setText("订单："+orderId);
            vh.mMyincomeEarningsTime.setText(createTime);
            vh.mMyincomePutawaySalesAmount.setText("售卖数量："+salesAmount);
        }
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.myincome_orderId)
        TextView mMyincomeOrderId;
        @BindView(R.id.myincome_putaway_salesAmount)
        TextView mMyincomePutawaySalesAmount;
        @BindView(R.id.myincome_earningsAmount)
        TextView mMyincomeEarningsAmount;
        @BindView(R.id.myincome_earningsTime)
        TextView mMyincomeEarningsTime;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
