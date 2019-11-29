package com.administrator.yaya.activity.orderform.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.bean.orderform.TestFinish;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaiQueRenAdapter extends RecyclerView.Adapter<DaiQueRenAdapter.Vh> {
    private Context context;
    private List<TestFinish.DataBean.OrderSalesListBean> list;
    private TestFinish.DataBean.CommodityBean commodity;

    public DaiQueRenAdapter(List<TestFinish.DataBean.OrderSalesListBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new Vh(LayoutInflater.from(context).inflate(R.layout.daiqueren_item, viewGroup, false));
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, final int i) {

        TestFinish.DataBean.OrderSalesListBean orderSalesListBean = list.get(i);
        int orderPayTpe = orderSalesListBean.getOrderPayTpe();

        if (orderPayTpe == 0){
            vh.daiqurenOrderNumber.setVisibility(View.GONE);
        }else if (orderPayTpe==1){
            vh.daiqurenOrderNumber.setText("【微信】订单编号：" + orderSalesListBean.getOrderNumber());
        }else if (orderPayTpe==2){
            vh.daiqurenOrderNumber.setText("【支付宝】订单编号：" + orderSalesListBean.getOrderNumber());
        }

        vh.daiqurenCommodityAmount.setText("售卖数量:"+orderSalesListBean.getSalesAmount());
        vh.daiqurenCommodityPrice.setText("售卖总价:￥"+orderSalesListBean.getSalesAmountMoney());
        vh.daiqurenOrderBuildTime.setText("订单时间："+orderSalesListBean.getSalesBuildTime());

        if (commodity!=null){
            Glide.with(context).load(commodity.getComImg()).placeholder(R.mipmap.icon).into(vh.daiqurenComImg);
            vh.daiqurenGcomName.setText(commodity.getComName());
        }

        //确认收货
        vh.daiqurenGetGatheringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (accountpaidsetOnclikListener!=null){
                    accountpaidsetOnclikListener.setonclik(i);
                }
            }
        });
        //未收货
        vh.daiqurenCancelOrderform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelsetOnclikListener!=null){
                    cancelsetOnclikListener.setonclik(i);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
    public void setData(TestFinish.DataBean.CommodityBean commodity) {
        this.commodity = commodity;
        notifyDataSetChanged();
    }
    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.daiquren_orderNumber)
        TextView daiqurenOrderNumber;
        @BindView(R.id.daiquren_comImg)
        ImageView daiqurenComImg;
        @BindView(R.id.daiquren_gcomName)
        TextView daiqurenGcomName;
        @BindView(R.id.daiquren_commodityAmount)
        TextView daiqurenCommodityAmount;
        @BindView(R.id.daiquren_commodityPrice)
        TextView daiqurenCommodityPrice;
        @BindView(R.id.daiquren_orderBuildTime)
        TextView daiqurenOrderBuildTime;
        @BindView(R.id.daiquren_getGathering_btn)
        TextView daiqurenGetGatheringBtn;
        @BindView(R.id.daiquren_cancel_orderform)
        TextView daiqurenCancelOrderform;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    //确认收货
    private AccountpaidsetOnclikListener accountpaidsetOnclikListener;
    public interface AccountpaidsetOnclikListener {
        void setonclik(int postion);
    }
    public void setAccountpaidsetOnclikListener(AccountpaidsetOnclikListener accountpaidsetOnclikListener) {
        this.accountpaidsetOnclikListener = accountpaidsetOnclikListener;
    }

    //未收货
    private CancelsetOnclikListener cancelsetOnclikListener;

    public interface CancelsetOnclikListener {
        void setonclik(int postion);
    }

    public void setCancelsetOnclikListener(CancelsetOnclikListener cancelsetOnclikListener) {
        this.cancelsetOnclikListener = cancelsetOnclikListener;
    }
}
