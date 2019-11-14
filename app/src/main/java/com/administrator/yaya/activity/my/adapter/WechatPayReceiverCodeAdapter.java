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
import com.administrator.yaya.bean.my.TestWechatReceiverCode;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WechatPayReceiverCodeAdapter extends RecyclerView.Adapter<WechatPayReceiverCodeAdapter.Vh>{
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, final int i) {

        //1.图片的点击事件  点击图片选图
        //2.上传后等待审核  用 加载图片展示下

        //3.上传成功  展示图片
        TestWechatReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean  = null;
        String imgUrl = null;
        double imgMoney=0;

        if (list.size() > 0) {

            for (int j = 0; j < list.size(); j++) {
                userCodeImgListBean = list.get(j);
                imgUrl = userCodeImgListBean.getImgUrl();
                imgMoney = userCodeImgListBean.getImgMoney();
                if (userCodeImgListBean.getImgMoney()==1000 && i == 1){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }else  if (userCodeImgListBean.getImgMoney()==2000 && i == 2){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }else  if (userCodeImgListBean.getImgMoney()==3000 && i == 3){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }else  if (userCodeImgListBean.getImgMoney()==4000 && i == 4){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }else  if (userCodeImgListBean.getImgMoney()==5000 && i == 5){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }else{
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }
            }

        }


        if (i == 0) {
            vh.mWechatGetmenryTv.setText("任意收款金额");
        }else if (i==1){
            vh.mWechatGetmenryTv.setText(imgMoney+"元");
        }else if (i==2){
            vh.mWechatGetmenryTv.setText(imgMoney+"元");
        }else if (i==3){
            vh.mWechatGetmenryTv.setText(imgMoney+"元");
        }else if (i==4){
            vh.mWechatGetmenryTv.setText(imgMoney+"元");
        }else if (i==5){
            vh.mWechatGetmenryTv.setText(imgMoney+"元");
        }

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wechatPayReceiverCodesetOnclikListener!=null){
                    wechatPayReceiverCodesetOnclikListener.setonclik(i,v);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    //点击图片 拉起相册  选图
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.ImageView_url_wechat)//图片显示
        ImageView mImageViewUrlWechat;
        @BindView(R.id.wechat_hint_unreviewed)//审核显示
        TextView mWechatHintUnreviewed;
        @BindView(R.id.wechatpay_add1_iv)
        ImageView mWechatpayAdd1Iv;
        @BindView(R.id.wechatpay_item_ll)//点击点用相机
        LinearLayout mWechatpayItemLl;
        @BindView(R.id.wechat_getmenry_tv)//金额显示
        TextView mWechatGetmenryTv;

        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //跳转确认信息接口回调
    private WechatPayReceiverCodesetOnclikListener wechatPayReceiverCodesetOnclikListener;

    public interface WechatPayReceiverCodesetOnclikListener {
        void setonclik(int index,View view);
    }

    public void setWechatPayReceiverCodesetOnclikListener(WechatPayReceiverCodesetOnclikListener wechatPayReceiverCodesetOnclikListener) {
        this.wechatPayReceiverCodesetOnclikListener = wechatPayReceiverCodesetOnclikListener;
    }
}
