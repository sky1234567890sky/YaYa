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

public class WechatPayReceiverCodeAdapter extends RecyclerView.Adapter<WechatPayReceiverCodeAdapter.Vh> {
    private final List<TestWechatReceiverCode.DataBean> list;
    private Context context;
    private View inflate;
    private double imgMoney;
    public WechatPayReceiverCodeAdapter(List<TestWechatReceiverCode.DataBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        inflate = LayoutInflater.from(context).inflate(R.layout.wechatpayreceivercode_item, viewGroup, false);
        return new Vh(inflate);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, @SuppressLint("RecyclerView") final int i) {

        TestWechatReceiverCode.DataBean userCodeImgListBean = list.get(i);
        String imgUrl = userCodeImgListBean.getImage();
//        if (userCodeImgListBean.getImgConfigType() == 1) {//微信
            Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
            vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney() + "元");
            getimageStatus(vh, userCodeImgListBean);
//                if (userCodeImgListBean1.getImgConfigMoney() == 1000.00 && i == 0) {
////                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
////                    if (userCodeImgListBean.getImgStatus() == 1) {
//////                    //待审核  不能点击
////                        vh.itemView.setClickable(false);
////                        vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
////                        vh.mWechatHint.setVisibility(View.VISIBLE);
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
////                        vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
////                    }
//                } else if (userCodeImgListBean1.getImgConfigMoney() == 2000.00 && i == 1) {
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                } else if (userCodeImgListBean1.getImgConfigMoney() == 3000.00 && i == 2) {
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                } else if (userCodeImgListBean1.getImgConfigMoney() == 4000.00 && i == 3) {
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                } else if (userCodeImgListBean1.getImgConfigMoney() == 5000.00 && i == 4){
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                }
//                if (getimageStatus(vh, userCodeImgListBean1)) break;
//            }
//        }
////             else if (userCodeImgListBean1.getImgConfigMoney() == 5000.00 && i == 5) {
////            Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
////        }
//
//        if (list.size() > 0) {
//            for (int j = 0; j < list.size(); j++) {
//                userCodeImgListBean = list.get(j);
//                imgUrl = userCodeImgListBean.getImage();
//                imgMoney = userCodeImgListBean.getImgConfigMoney();
////                                    imgStatus   二维码状态
////                    二维码状态 1待审核 2审核完成  3审核不通过
////                1.
//                if (userCodeImgListBean.getImgConfigType() == 1) {
//                    //待审核  不能点击
////                    vh.itemView.setOnClickListener();
////                    vh.itemView.
//                    vh.itemView.setClickable(false);
//                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    vh.mWechatHint.setVisibility(View.VISIBLE);
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                    vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
//                } else if (userCodeImgListBean.getImgConfigType() == 2) {//审核完成
////                    if (userCodeImgListBean.getImgMoney() == 1000.00 && i == 1) {
//                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    vh.mWechatHint.setVisibility(View.GONE);
//                    vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
////                    }
//                } else if (userCodeImgListBean.getImgConfigType() == 3) {//审核不通过
//                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    vh.mWechatNoShenhe.setVisibility(View.VISIBLE);
//                    vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
//                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                }
////        if (i == 0) {
////            vh.mWechatGetmenryTv.setText("任意收款金额");
////        } else
//                if (i == 0) {
//                    vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney()+"元");
//                } else if (i == 1) {
//                    vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney()+"元");
//                } else if (i == 2) {
//                    vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney()+"元");
//                } else if (i == 3) {
//                    vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney()+"元");
//                } else if (i == 4) {
//                    vh.mWechatGetmenryTv.setText(userCodeImgListBean.getImgConfigMoney()+"元");
//                }
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (wechatPayReceiverCodesetOnclikListener != null) {
                        wechatPayReceiverCodesetOnclikListener.setonclik(i, v);
                    }
                }
            });
//        }
    }
    @SuppressLint("SetTextI18n")
    private boolean getimageStatus(Vh vh, TestWechatReceiverCode.DataBean userCodeImgListBean1) {
//、、二维码状态 1待审核 2审核完成  3审核不通过
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

    //点击图片 拉起相册  选图
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
    private WechatPayReceiverCodesetOnclikListener wechatPayReceiverCodesetOnclikListener;

    public interface WechatPayReceiverCodesetOnclikListener {
        void setonclik(int index, View view);
    }
    public void setWechatPayReceiverCodesetOnclikListener(WechatPayReceiverCodesetOnclikListener wechatPayReceiverCodesetOnclikListener) {
        this.wechatPayReceiverCodesetOnclikListener = wechatPayReceiverCodesetOnclikListener;
    }
}
