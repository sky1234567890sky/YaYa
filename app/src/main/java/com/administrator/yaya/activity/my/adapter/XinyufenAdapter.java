package com.administrator.yaya.activity.my.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//信誉分适配器
public class XinyufenAdapter extends RecyclerView.Adapter<XinyufenAdapter.Vh> {
    private Context context;

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.xinyufen_item, viewGroup, false);
        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.xinyufen_tv_add)//+3
        TextView mTvAdd;
        @BindView(R.id.xinyufen_tv_succeess)//成功确认  超时释放
        TextView mTvSucceess;
        @BindView(R.id.xinyufen_tv_orderform)//订单编号
        TextView mTvOrderform;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
