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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.Vh> {


    private List<?> list;
    private Context context;

    public IncomeAdapter(ArrayList<?> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.income_item, null);
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
