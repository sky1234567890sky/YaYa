package com.administrator.yaya.activity.orderform.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.Vh> {

    private  List<TestAllOrderStock.DataBean.OrderSalesListBean> listBean;
    private Context context;
    private TestAllOrderStock.DataBean data;

    public AllAdapter(List<TestAllOrderStock.DataBean.OrderSalesListBean> listBean) {

        this.listBean = listBean;
    }

    public void setData(TestAllOrderStock.DataBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();

        View inflate = LayoutInflater.from(context).inflate(R.layout.all_item, viewGroup, false);

        return new Vh(inflate);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, @SuppressLint("RecyclerView") final int i) {
        int itemViewType = getItemViewType(i);
//        TestAllOrderStock.DataBean.OrderSalesListBean orderSalesListBean1 = listBean.get(i);

        List<TestAllOrderStock.DataBean.OrderSalesListBean> orderSalesList = data.getOrderSalesList();

        TestAllOrderStock.DataBean.OrderSalesListBean orderSalesListBean1 = orderSalesList.get(i);

        TestAllOrderStock.DataBean.CommodityBean commodity1 = data.getCommodity();

        double comPrice = commodity1.getComPrice();
        String comImg1 = commodity1.getComImg();
        int orderPayTpe = orderSalesList.get(i).getOrderPayTpe();

        String orderNumber = orderSalesListBean1.getOrderNumber();

        String createTime = orderSalesListBean1.getCreateTime();

        int salesStatus = orderSalesListBean1.getSalesStatus();
//        收款方式 orderPayTpe  0无  1微信  2支付宝
//        状态  salesStatus  1售卖中 2 已完成 3已取消

//        进货订单集合	orderSalesList
//        订单id		salesId
//        订单编号	orderNumber
//        货物信息对象	commodity
//        货物名称	comName
        if (salesStatus==1){

            if (orderPayTpe == 0){
                vh.allOrderNumber.setVisibility(View.GONE);
            }else if (orderPayTpe==1){
                vh.allOrderNumber.setText("【微信】订单编号：" + orderNumber);
            }else if (orderPayTpe==2){
                vh.allOrderNumber.setText("【支付宝】订单编号：" + orderNumber);
            }
            Glide.with(context).load(comImg1).placeholder(R.mipmap.icon).into(vh.allComImg);
            vh.allCommodityAmount.setText("售卖数量:"+orderSalesListBean1.getSalesAmount());
            vh.allCommodityPrice.setText("售卖总价￥:"+orderSalesListBean1.getCommodityPrice());
            vh.allOrderBuildTime.setText("订单时间："+orderSalesListBean1.getSalesBuildTime());
            vh.allGcomName.setText(commodity1.getComName());
            vh.allIvFinish.setVisibility(View.GONE);//
            //确认收货
            vh.sellGetGatheringBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (accountpaidsetOnclikListener!=null){
                        accountpaidsetOnclikListener.setonclik(i);
                    }
                }
            });

            //未收货
            vh.sellCancelOrderform.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cancelsetOnclikListener!=null){
                        cancelsetOnclikListener.setonclik(i);
                    }
                }
            });
        }else if (salesStatus==2){

            if (orderPayTpe == 0){
                vh.allOrderNumber.setVisibility(View.GONE);
            }else if (orderPayTpe==1){
                vh.allOrderNumber.setText("【微信】订单编号：" + orderNumber);
            }else{
                vh.allOrderNumber.setText("【支付宝】订单编号：" + orderNumber);
            }
            Glide.with(context).load(comImg1).placeholder(R.mipmap.icon).into(vh.allComImg);
            vh.allCommodityAmount.setText("售卖数量:"+orderSalesListBean1.getSalesAmount());
            vh.allCommodityPrice.setText("售卖总价￥:"+orderSalesListBean1.getCommodityPrice());
            vh.allOrderBuildTime.setText("订单时间："+orderSalesListBean1.getSalesBuildTime());
            vh.allGcomName.setText(commodity1.getComName());
            vh.allIvFinish.setVisibility(View.GONE);//
            vh.sellZaiciQueren.setVisibility(View.VISIBLE);
            vh.sellGetGatheringBtn.setVisibility(View.GONE);
            vh.sellCancelOrderform.setVisibility(View.GONE);
            vh.sellZaiciQueren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (reconfirmOnclikListener!=null){
                        reconfirmOnclikListener.setonclik(i);
                    }
                }
            });

        }else if (salesStatus==3){
            if (orderPayTpe == 0){
                vh.allOrderNumber.setVisibility(View.GONE);
            }else if (orderPayTpe==1){
                vh.allOrderNumber.setText("【微信】订单编号：" + orderNumber);
            }else{
                vh.allOrderNumber.setText("【支付宝】订单编号：" + orderNumber);
            }
            Glide.with(context).load(comImg1).placeholder(R.mipmap.icon).into(vh.allComImg);
            vh.allCommodityAmount.setText("售卖数量:"+orderSalesListBean1.getSalesAmount());
            vh.allCommodityPrice.setText("售卖总价￥:"+orderSalesListBean1.getCommodityPrice());
            vh.allOrderBuildTime.setText("订单时间："+orderSalesListBean1.getSalesBuildTime());
            vh.allGcomName.setText(commodity1.getComName());
            vh.allIvFinish.setVisibility(View.GONE);//
            vh.allIvCancel.setVisibility(View.VISIBLE);//已取消显示
            vh.sellZaiciQueren.setVisibility(View.GONE);
            vh.sellGetGatheringBtn.setVisibility(View.GONE);
            vh.sellCancelOrderform.setVisibility(View.GONE);

        }else if (salesStatus==4){
            if (orderPayTpe == 0){
                vh.allOrderNumber.setVisibility(View.GONE);
            }else  if (orderPayTpe==1){
                vh.allOrderNumber.setText("【微信】订单编号：" + orderNumber);
            }else{
                vh.allOrderNumber.setText("【支付宝】订单编号：" + orderNumber);
            }
            Glide.with(context).load(comImg1).placeholder(R.mipmap.icon).into(vh.allComImg);
            vh.allCommodityAmount.setText("售卖数量:"+orderSalesListBean1.getSalesAmount());
            vh.allCommodityPrice.setText("售卖总价￥:"+orderSalesListBean1.getCommodityPrice());
            vh.allOrderBuildTime.setText("订单时间："+orderSalesListBean1.getSalesBuildTime());
            vh.allGcomName.setText(commodity1.getComName());
            vh.allIvFinish.setVisibility(View.VISIBLE);//
            vh.allIvCancel.setVisibility(View.GONE);//已取消显示
            vh.sellZaiciQueren.setVisibility(View.GONE);
            vh.sellGetGatheringBtn.setVisibility(View.GONE);
            vh.sellCancelOrderform.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return listBean != null ? listBean.size() : 0;
    }

//    @Override
//    public int getItemViewType(int position) {
//        int salesStatus = listBean.get(position).getSalesStatus();
//
//        if (listBean.size() > 0 || !listBean.isEmpty()) {
//
////待确认1 已完成2  已取消3   未收款（未收货）4
//
////状态  salesStatus  1售卖中（待确认） 2 已完成 3已取消
//            if (salesStatus == 1) {
//                return 1;
//            } else if (salesStatus == 2) {
//                return 2;
//            } else if (salesStatus == 3) {
//                return 3;
//            } else {
//                return 4;
//            }
//        }
//        return super.getItemViewType(position);
//    }


    public class Vh extends RecyclerView.ViewHolder {

        @BindView(R.id.all_iv_finish)
        ImageView allIvFinish;
        @BindView(R.id.all_iv_cancel)
        ImageView allIvCancel;
        @BindView(R.id.all_orderNumber)
        TextView allOrderNumber;
        @BindView(R.id.all_comImg)
        ImageView allComImg;
        @BindView(R.id.all_gcomName)
        TextView allGcomName;
        @BindView(R.id.all_commodityAmount)
        TextView allCommodityAmount;
        @BindView(R.id.all_commodityPrice)
        TextView allCommodityPrice;
        @BindView(R.id.all_orderBuildTime)
        TextView allOrderBuildTime;
        @BindView(R.id.sell_getGathering_btn)
        TextView sellGetGatheringBtn;
        @BindView(R.id.sell_zaici_queren)
        TextView sellZaiciQueren;
        @BindView(R.id.sell_cancel_orderform)
        TextView sellCancelOrderform;

        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
//    //再次确认
    private ReconfirmOnclikListener reconfirmOnclikListener;
    public interface ReconfirmOnclikListener{
        void setonclik(int postion);
    }
    public void setReconfirmOnclikListener(ReconfirmOnclikListener reconfirmOnclikListener) {
        this.reconfirmOnclikListener = reconfirmOnclikListener;
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
