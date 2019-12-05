package com.administrator.yaya.activity.my.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestXinyufenJilu;

import java.util.ArrayList;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;

//信誉分适配器
public class XinyufenAdapter extends RecyclerView.Adapter<XinyufenAdapter.Vh> {
    private final ArrayList<TestXinyufenJilu.DataBean.ListBean> list;
    private Context context;
    public XinyufenAdapter(ArrayList<TestXinyufenJilu.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.xinyufen_item, viewGroup, false);
        return new Vh(inflate);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {

        TestXinyufenJilu.DataBean.ListBean listBean = list.get(i);
        int id = listBean.getId();
        int creditType = listBean.getCreditType();
//
//        userCredit 用户信誉分
//        creditContentType 内容类型 1.成功确认      2.超时释放
//        creditType   类型1.增加2.减少
//        creditPart   分值
        int creditContentType = listBean.getCreditContentType();
        int creditPart = listBean.getCreditPart();

        String creditContent = listBean.getCreditContent();//订单

        vh.mTvOrderform.setText("订单："+creditContent);//订单
        if (creditContentType == 1) {
            if (creditType == 1) {
                vh.mTvAdd.setText("+" + creditPart);
            }
            //成功确认
            vh.mTvSucceess.setText("成功确认");
        } else {//超时释放
            vh.mTvAdd.setTextColor(context.getResources().getColor(R.color.c_000000));
            if (creditType == 2) {
                vh.mTvAdd.setText("-" + creditPart);
            }
            vh.mTvSucceess.setText("超时释放");
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
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
