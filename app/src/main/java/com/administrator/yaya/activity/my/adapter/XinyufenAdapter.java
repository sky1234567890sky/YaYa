package com.administrator.yaya.activity.my.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.yaya.R;

public class XinyufenAdapter extends RecyclerView.Adapter<XinyufenAdapter.Vh> {

    private Context context;

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechatpayreceivercode_item, viewGroup, false);
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
        public Vh(@NonNull View itemView) {
            super(itemView);
        }
    }
}
