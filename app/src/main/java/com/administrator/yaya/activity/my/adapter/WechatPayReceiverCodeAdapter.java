package com.administrator.yaya.activity.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.bean.my.TestWechatReceiverCode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WechatPayReceiverCodeAdapter extends RecyclerView.Adapter<WechatPayReceiverCodeAdapter.Vh> implements View.OnClickListener {
    private final List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> list;

    private Context context;

    public WechatPayReceiverCodeAdapter(List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechatpayreceivercode_item, viewGroup, false);
        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        //1.图片的点击事件  点击图片选图
        vh.mWechatAddIv.setOnClickListener(this);
        //2.上传后等待审核  用 加载图片展示下

        //3.上传成功  展示图片

    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    //点击图片 拉起相册  选图

    @Override
    public void onClick(View v) {

    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.ImageView_url_wechat)
        ImageView mIvUrlWechat;
        @BindView(R.id.wechat_hint_unreviewed)
        TextView mLoadHnt;
        @BindView(R.id.wechatpay_add1_iv)
        ImageView mWechatAddIv;
        @BindView(R.id.wechat_getmenry_tv)
        TextView mWechatGetMoney;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //跳转确认信息接口回调
    private WechatPayReceiverCodesetOnclikListener wechatPayReceiverCodesetOnclikListener;
    public interface WechatPayReceiverCodesetOnclikListener{
        void  setonclik(int index);
    }
    public void setWechatPayReceiverCodesetOnclikListener(WechatPayReceiverCodesetOnclikListener wechatPayReceiverCodesetOnclikListener) {
        this.wechatPayReceiverCodesetOnclikListener = wechatPayReceiverCodesetOnclikListener;
    }
}
