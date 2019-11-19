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
import com.administrator.yaya.bean.my.TestWechatReceiverCode;
import com.bumptech.glide.Glide;

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
    int imgMoney;
    String imgUrl;
    @Override
    public void onBindViewHolder(@NonNull Vh vh, final int i) {
        TestWechatReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean  = null;
        String imgUrl = null;
        double imgMoney=0;
        if (list.size() > 0) {
            for (int j = 0; j < list.size(); j++) {
                TestAlipayReceiverCode.DataBean.UserCodeImgListBean userCodeImgListBean1 = list.get(j);
                imgUrl = userCodeImgListBean.getImgUrl();
                imgMoney = userCodeImgListBean.getImgMoney();
                if (userCodeImgListBean.getImgMoney()==1000 && i == 1){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
                }else  if (userCodeImgListBean.getImgMoney()==2000 && i == 2){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
                }else  if (userCodeImgListBean.getImgMoney()==3000 && i == 3){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
                }else  if (userCodeImgListBean.getImgMoney()==4000 && i == 4){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
                }else  if (userCodeImgListBean.getImgMoney()==5000 && i == 5){
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
                }else{
                    Glide.with(context).load(imgUrl).into(vh.mImageViewUrl);
                }
            }
        }

        if (i == 0) {
            vh.mMoneyNumber.setText("任意收款金额");
        }else if (i==1){
            vh.mMoneyNumber.setText("1000.0元");
        }else if (i==2){
            vh.mMoneyNumber.setText("2000.0元");
        }else if (i==3){
            vh.mMoneyNumber.setText("3000.0元");
        }else if (i==4){
            vh.mMoneyNumber.setText("4000.0元");
        }else if (i==5){
            vh.mMoneyNumber.setText("5000.0元");
        }
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alipayPayReceiverCodesetOnclikListener!=null){
                    alipayPayReceiverCodesetOnclikListener.setonclik(i,v);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return 6;
    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.alipay_item_ll)//点击调用相机
        LinearLayout mApliayLl;
        @BindView(R.id.get_menry)
        TextView mMoneyNumber;//金额显示
        @BindView(R.id.ImageView_url_alipay)
        ImageView mImageViewUrl;//图片显示
        @BindView(R.id.hint_unreviewed)//hint_unreviewed
        TextView mHintUnreviewed;//待审核显示
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //跳转确认信息接口回调
    private AlipayPayReceiverCodesetOnclikListener alipayPayReceiverCodesetOnclikListener;
    public interface AlipayPayReceiverCodesetOnclikListener {
        void setonclik(int index,View view);
    }
    public void setAlipayPayReceiverCodesetOnclikListener(AlipayPayReceiverCodesetOnclikListener alipayPayReceiverCodesetOnclikListener) {
        this.alipayPayReceiverCodesetOnclikListener = alipayPayReceiverCodesetOnclikListener;
    }
}
