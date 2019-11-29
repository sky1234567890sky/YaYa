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

public class AlipayReceiverCodeAdapter extends RecyclerView.Adapter<AlipayReceiverCodeAdapter.Vh> {
    private final List<TestWechatReceiverCode.DataBean> list;
    private Context context;

    public AlipayReceiverCodeAdapter(List<TestWechatReceiverCode.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AlipayReceiverCodeAdapter.Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(context).inflate(R.layout.wechatpayreceivercode_item, viewGroup, false);
        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh vh, final int i) {

        TestWechatReceiverCode.DataBean userCodeImgListBean = list.get(i);
        String imgUrl = userCodeImgListBean.getImage();
//        if (userCodeImgListBean.getImgConfigType() == 1) {//微信
        Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
        vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney() + "元");

        getimageStatus(vh, userCodeImgListBean);

////        TestWechatReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean  = null;
////        String imgUrl = null;
////        double imgMoney=0;
////        if (list.size() > 0) {
////            for (int j = 0; j < list.size(); j++) {
////                TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean1 = list.get(j);
////                imgUrl = userCodeImgListBean.getImgUrl();
////                imgMoney = userCodeImgListBean.getImgMoney();
////                if (userCodeImgListBean.getImgMoney()==1000 && i == 1){
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
////                }else  if (userCodeImgListBean.getImgMoney()==2000 && i == 2){
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
////                }else  if (userCodeImgListBean.getImgMoney()==3000 && i == 3){
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
////                }else  if (userCodeImgListBean.getImgMoney()==4000 && i == 4){
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
////                }else  if (userCodeImgListBean.getImgMoney()==5000 && i == 5){
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
////                }else{
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
////                }
////            }
////        }
////
////        if (i == 0) {
////            vh.mMoneyNumber.setText("任意收款金额");
////        }else if (i==1){
////            vh.mMoneyNumber.setText("1000.0元");
////        }else if (i==2){
////            vh.mMoneyNumber.setText("2000.0元");
////        }else if (i==3){
////            vh.mMoneyNumber.setText("3000.0元");
////        }else if (i==4){
////            vh.mMoneyNumber.setText("4000.0元");
////        }else if (i==5){
////            vh.mMoneyNumber.setText("5000.0元");
////        }
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alipayPayReceiverCodesetOnclikListener != null) {
                    alipayPayReceiverCodesetOnclikListener.setonclik(i, v);
                }
            }
        });
    }

    private Boolean getimageStatus(Vh vh, TestWechatReceiverCode.DataBean userCodeImgListBean1) {
        vh.mImageViewUrlWechat.setVisibility(View.INVISIBLE);
        vh.mWechatHint.setVisibility(View.INVISIBLE);
        vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);

        if (userCodeImgListBean1.getImgStatus() == 1) {
            //待审核  不能点击
            vh.itemView.setClickable(false);

            vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
            vh.mWechatHint.setVisibility(View.VISIBLE);
            vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
            Glide.with(context).load(userCodeImgListBean1.getImage()).into(vh.mImageViewUrlWechat);
            double imgMoney1 = userCodeImgListBean1.getImgConfigMoney();
            vh.mWechatGetmenryTv.setText(imgMoney1 + "元");
            return true;

        } else if (userCodeImgListBean1.getImgStatus() == 2) {
            //审核通过
            vh.itemView.setClickable(true);
            vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
            vh.mWechatHint.setVisibility(View.GONE);
            vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
            Glide.with(context).load(userCodeImgListBean1.getImage()).into(vh.mImageViewUrlWechat);
            double imgMoney1 = userCodeImgListBean1.getImgConfigMoney();
            vh.mWechatGetmenryTv.setText(imgMoney1 + "元");
            return true;
        } else if (userCodeImgListBean1.getImgStatus() == 3) {
            //未通过
            vh.itemView.setClickable(true);
            vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
            vh.mWechatNoShenhe.setVisibility(View.VISIBLE);
            vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);

            Glide.with(context).load(userCodeImgListBean1.getImage()).into(vh.mImageViewUrlWechat);
            double imgMoney1 = userCodeImgListBean1.getImgConfigMoney();

            vh.mWechatGetmenryTv.setText(imgMoney1 + "元");
            return true;
        }else {
            vh.mWechatpayItemLl.setVisibility(View.VISIBLE);
        }
        return false;
    }


    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.ImageView_url_wechat)//图片显示
                ImageView mImageViewUrlWechat;
        @BindView(R.id.wechat_hint_unreviewed)//审核通过显示
                TextView mWechatHint;

        @BindView(R.id.wechat_no_shenhe)//审核不通过显示
                TextView mWechatNoShenhe;
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
    private AlipayPayReceiverCodesetOnclikListener alipayPayReceiverCodesetOnclikListener;

    public interface AlipayPayReceiverCodesetOnclikListener {
        void setonclik(int index, View view);
    }

    public void setAlipayPayReceiverCodesetOnclikListener(AlipayPayReceiverCodesetOnclikListener alipayPayReceiverCodesetOnclikListener) {
        this.alipayPayReceiverCodesetOnclikListener = alipayPayReceiverCodesetOnclikListener;
    }
}
