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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RebateAdapter extends RecyclerView.Adapter<RebateAdapter.Vh> {
    private final ArrayList<?> list;

    private Context context;

    public RebateAdapter(ArrayList<?> list) {

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
