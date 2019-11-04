package com.administrator.yaya.activity.my.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpendAdapter extends RecyclerView.Adapter<ExpendAdapter.Vh> {
    private final ArrayList<?> list;
    private Context context;
    public ExpendAdapter(ArrayList<?> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.expend_item, null);
        return new Vh(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {

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
