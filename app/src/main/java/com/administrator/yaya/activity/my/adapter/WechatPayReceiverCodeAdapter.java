package com.administrator.yaya.activity.my.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private final List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> list;
    private Context context;
    private View inflate;

    public WechatPayReceiverCodeAdapter(List<TestWechatReceiverCode.DataBean.UserCodeImgListBean> list) {
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
    public void onBindViewHolder(@NonNull Vh vh, final int i) {
        TestWechatReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean = null;
        String imgUrl = null;
//        double imgMoney = 0.00;

        for (int j = 0; j < list.size(); j++) {
            TestWechatReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean1 = list.get(j);
            if (userCodeImgListBean1.getImgType() == 1) {//微信
                if (userCodeImgListBean1.getImgMoney() == 1000.00 && i == 1) {
//                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
//                    if (userCodeImgListBean.getImgStatus() == 1) {
////                    //待审核  不能点击
//                        vh.itemView.setClickable(false);
//                        vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
//                        vh.mWechatHint.setVisibility(View.VISIBLE);
                        Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//                        vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
//                    }
                } else if (userCodeImgListBean1.getImgMoney() == 2000.00 && i == 2) {
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                } else if (userCodeImgListBean1.getImgMoney() == 3000.00 && i == 3) {
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                } else if (userCodeImgListBean1.getImgMoney() == 4000.00 && i == 4) {
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                } else if (userCodeImgListBean1.getImgMoney() == 5000.00 && i == 5) {
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                } else {
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
                }
                if (getimageStatus(vh,userCodeImgListBean1)) break;
            }
            }
//        if (list.size() > 0) {
//            for (int j = 0; j < list.size(); j++) {
//                userCodeImgListBean = list.get(j);
//                imgUrl = userCodeImgListBean.getImgUrl();
//
//                imgMoney = userCodeImgListBean.getImgMoney();
//                //                    imgStatus   二维码状态
////                    二维码状态 1待审核 2审核完成  3审核不通过
//                //1.
////                if (userCodeImgListBean.getImgStatus() == 1) {
////                    //待审核  不能点击
//////                    vh.itemView.setOnClickListener();
//////                    vh.itemView.
////                    vh.itemView.setClickable(false);
////                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
////                    vh.mWechatHint.setVisibility(View.VISIBLE);
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
////                    vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
////                } else if (userCodeImgListBean.getImgStatus() == 2) {//审核完成
//////                    if (userCodeImgListBean.getImgMoney() == 1000.00 && i == 1) {
////                        vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
////                        vh.mWechatHint.setVisibility(View.GONE);
////                        vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
////                        Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
//////                    }
////                } else if (userCodeImgListBean.getImgStatus() == 3) {//审核不通过
////                    vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
////                    vh.mWechatNoShenhe.setVisibility(View.VISIBLE);
////                    vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);
////                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrlWechat);
////                }
//
//
            if (i == 0) {
                vh.mWechatGetmenryTv.setText("任意收款金额");
            } else if (i == 1) {
                vh.mWechatGetmenryTv.setText("1000.00元");
            } else if (i == 2) {
                vh.mWechatGetmenryTv.setText("2000.00元");
            } else if (i == 3) {
                vh.mWechatGetmenryTv.setText("3000.00元");
            } else if (i == 4) {
                vh.mWechatGetmenryTv.setText("4000.00元");
            } else if (i == 5) {
                vh.mWechatGetmenryTv.setText("5000.00元");
            }

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wechatPayReceiverCodesetOnclikListener != null) {
                    wechatPayReceiverCodesetOnclikListener.setonclik(i, v);
                }
            }
        });
    }

    private boolean getimageStatus(Vh vh, TestWechatReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean1) {
        if (userCodeImgListBean1.getImgStatus() == 1) {
            //待审核  不能点击
            vh.itemView.setClickable(false);
            vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
            vh.mWechatHint.setVisibility(View.VISIBLE);
            vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);

            Glide.with(context).load(userCodeImgListBean1.getImgUrl()).into(vh.mImageViewUrlWechat);
            double imgMoney1 = userCodeImgListBean1.getImgMoney();
            vh.mWechatGetmenryTv.setText(imgMoney1 + "元");
            return true;

        }else if (userCodeImgListBean1.getImgStatus() == 2) {
            //审核通过
            vh.itemView.setClickable(true);
            vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
            vh.mWechatHint.setVisibility(View.GONE);
            vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);

            Glide.with(context).load(userCodeImgListBean1.getImgUrl()).into(vh.mImageViewUrlWechat);
            double imgMoney1 = userCodeImgListBean1.getImgMoney();
            vh.mWechatGetmenryTv.setText(imgMoney1 + "元");
            return true;
        }else if (userCodeImgListBean1.getImgStatus() == 3) {
            //待审核  不能点击
            vh.itemView.setClickable(true);
            vh.mImageViewUrlWechat.setVisibility(View.VISIBLE);
            vh.mWechatNoShenhe.setVisibility(View.VISIBLE);
            vh.mWechatpayItemLl.setVisibility(View.INVISIBLE);

            Glide.with(context).load(userCodeImgListBean1.getImgUrl()).into(vh.mImageViewUrlWechat);
            double imgMoney1 = userCodeImgListBean1.getImgMoney();
            vh.mWechatGetmenryTv.setText(imgMoney1 + "元");
            return true;
        }
        return false;
    }


    @Override
    public int getItemCount() {
        return 6;
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
