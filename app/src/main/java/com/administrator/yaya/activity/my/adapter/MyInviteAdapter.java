package com.administrator.yaya.activity.my.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestMyInviteAll;
import com.bumptech.glide.Glide;

import java.lang.invoke.CallSite;
import java.util.List;

public class MyInviteAdapter extends RecyclerView.Adapter<MyInviteAdapter.Vh> {
    private final List<TestMyInviteAll.DataBean.ListBean> list;
    private Context context;
    private double profit;

    public MyInviteAdapter(List<TestMyInviteAll.DataBean.ListBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.myinvite_item, viewGroup, false);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, @SuppressLint("RecyclerView") final int i) {
        TestMyInviteAll.DataBean.ListBean listBean = list.get(i);
//        list    邀请码集合
//        lvName   级别名称
//        codeName  邀请码
//        lvProfit  返利比例（分配）

        vh.fenpeiBaifen.setText("分配" + listBean.getLvProfit() + "%");

        vh.jieliuBaifen.setText("截留" + (profit - listBean.getLvProfit()) + "%");

        vh.yaoqingItemBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myInviteOnClickListener != null) {
                    myInviteOnClickListener.nviteOnClickListeneri(i);
                }
            }
        });

        String[] jibie = {"黄金", "铂金", "钻石", "王者", "星耀"};
        int[] iv = {R.mipmap.icon_huangjin, R.mipmap.icon_bojin, R.mipmap.icon_zuanshi, R.mipmap.icon_wangzhe, R.mipmap.icon_xingyao};
        String userLevelName = listBean.getLvName();
        if (jibie[0].equals(userLevelName)) {
            Glide.with(context).load(iv[0]).placeholder(R.mipmap.icon).into(vh.dengji_iv);
        } else if (jibie[1].equals(userLevelName)) {
            Glide.with(context).load(iv[1]).placeholder(R.mipmap.icon).into(vh.dengji_iv);
        } else if (jibie[2].equals(userLevelName)) {
            Glide.with(context).load(iv[2]).placeholder(R.mipmap.icon).into(vh.dengji_iv);
        } else if (jibie[3].equals(userLevelName)) {
            Glide.with(context).load(iv[3]).placeholder(R.mipmap.icon).into(vh.dengji_iv);
        } else if (jibie[4].equals(userLevelName)) {
            Glide.with(context).load(iv[4]).placeholder(R.mipmap.icon).into(vh.dengji_iv);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setData(double profit) {

        this.profit = profit;
        notifyDataSetChanged();
    }

    public class Vh extends RecyclerView.ViewHolder {
        private TextView fenpeiBaifen;
        private TextView jieliuBaifen;
        private TextView yaoqingItemBtn1;
        private ImageView dengji_iv;

        public Vh(@NonNull View itemView) {
            super(itemView);
            fenpeiBaifen = (TextView) itemView.findViewById(R.id.fenpei_baifen);
            dengji_iv = (ImageView) itemView.findViewById(R.id.dengji_iv);
            jieliuBaifen = (TextView) itemView.findViewById(R.id.jieliu_baifen);
            yaoqingItemBtn1 = (TextView) itemView.findViewById(R.id.yaoqing_item_btn1);
        }
    }

    private MyInviteOnClickListener myInviteOnClickListener;

    public interface MyInviteOnClickListener {
        void nviteOnClickListeneri(int i);
    }

    public void setMyInviteOnClickListener(MyInviteOnClickListener myInviteOnClickListener) {
        this.myInviteOnClickListener = myInviteOnClickListener;
    }
}
