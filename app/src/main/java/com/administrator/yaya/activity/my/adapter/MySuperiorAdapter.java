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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MySuperiorAdapter extends RecyclerView.Adapter<MySuperiorAdapter.Vh> {
    private Context context;

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        //我的下級佈局
        View inflate = LayoutInflater.from(context).inflate(R.layout.mysuperior_item, null);
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
        @BindView(R.id.mysuperior_headleriv)
        ImageView mMysuperiorHeadleriv;
        @BindView(R.id.mysuperior_rabaterecord_name)
        TextView mMysuperiorRabaterecordName;
        @BindView(R.id.mysuperior_junior)
        TextView mMysuperiorJunior;
        @BindView(R.id.mysuperior_putaway_number_tv)
        TextView mMysuperiorPutawayNumberTv;
        @BindView(R.id.mysuperior_userContributeTotal)
        TextView mMysuperiorUserContributeTotal;
        @BindView(R.id.mysuperior_add_number)
        TextView mMysuperiorAddNumber;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
