package com.administrator.yaya.activity.my.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestMyEarnings;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RebateAdapter extends RecyclerView.Adapter<RebateAdapter.Vh> {
    private final ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list;

    private Context context;

    public RebateAdapter(ArrayList<TestMyEarnings.DataBean.UserEarningsListBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.rebate_item, null);
        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        //        orderId	订单编号
//        salesAmount	售卖数量
//        earningsAmount	收益数量
//        earningsType	收益类型--1收入-2支出-3返利
//        earningsTime	收益日期
//        userId			用户id
//        userName		用户昵称
        TestMyEarnings.DataBean.UserEarningsListBean userEarningsListBean = list.get(i);
        String orderId = userEarningsListBean.getOrderId();
        int salesAmount = userEarningsListBean.getSalesAmount();
        int earningsAmount = userEarningsListBean.getEarningsAmount();
        int earningsType = userEarningsListBean.getEarningsType();
        String createTime = userEarningsListBean.getEarningsTime();
        int userId = userEarningsListBean.getUserId();
        String userName = userEarningsListBean.getUserName();
        if (earningsType==1){//返利记录
            vh.mReabateUserNickName.setText("用户昵称(用户ID："+orderId+")");
            vh.mRebateEarningsTime.setText(createTime);
            vh.mRebateSalesAmount.setText("+"+salesAmount);
//            Glide.with(context).load()
        }
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.rebate_name_headleriv)
        ImageView mRebateNameHeadleriv;
        @BindView(R.id.reabate_userNickName)
        TextView mReabateUserNickName;
        @BindView(R.id.rebate_earningsTime)
        TextView mRebateEarningsTime;
        @BindView(R.id.rebate_salesAmount)
        TextView mRebateSalesAmount;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
