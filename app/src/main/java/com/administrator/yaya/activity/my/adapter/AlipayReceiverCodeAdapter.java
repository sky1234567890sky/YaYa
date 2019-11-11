package com.administrator.yaya.activity.my.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestAlipayReceiverCode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlipayReceiverCodeAdapter extends RecyclerView.Adapter<AlipayReceiverCodeAdapter.Vh> {
    private final List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> list;

    private Context context;

    public AlipayReceiverCodeAdapter(List<TestAlipayReceiverCode.DataBean.UserCodeImgListBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(context).inflate(R.layout.alipayreceivercode_item, null);
        return new Vh(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {

        TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean = list.get(i);
        int imgMoney = userCodeImgListBean.getImgMoney();
        String imgUrl = userCodeImgListBean.getImgUrl();
        if (i==0){
            vh.mMoneyNumber.setText("任意收款金额");
        }else{
            vh.mMoneyNumber.setText(imgMoney+"元");
        }

//        vh.mApliayLl.
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;

    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.alipay_item_ll)//点击调用相机
        LinearLayout mApliayLl;
        @BindView(R.id.get_menry)
        TextView mMoneyNumber;//金额显示
        @BindView(R.id.ImageView_url_alipay)
        ImageView mImageViewUrl;//图片显示
        @BindView(R.id.hint_unreviewed)
        TextView mHintUnreviewed;//待审核显示
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
