package com.administrator.yaya.activity.inventory.adapter;

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
import com.administrator.yaya.bean.invite.TestInventory;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestInventoryAdapter extends RecyclerView.Adapter {
    private final ArrayList<TestInventory.DataBean.OrderStockListBean> list;
    private Context context;
    private TestInventory.DataBean.CommodityBean commodity;

    public TestInventoryAdapter(ArrayList<TestInventory.DataBean.OrderStockListBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        TestInventory.DataBean.OrderStockListBean orderStockListBean = list.get(i);
//        订单状态	orderStatus	1、待审核（待付款） 2、审核通过（已付款））
        RecyclerView.ViewHolder viewHolder = null;
        if (i==1){
            //待付款
            View view = LayoutInflater.from(context).inflate(R.layout.obligation_item, viewGroup,false);
             viewHolder = new ObligationItem(view);
        }else if(i==2){
            //已付款
            View view = LayoutInflater.from(context).inflate(R.layout.accountpaid_item, viewGroup,false);
            viewHolder = new AccountpaidItem(view);
        }
        return viewHolder;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        int itemViewType = getItemViewType(i);
        TestInventory.DataBean.OrderStockListBean orderStockListBean = list.get(i);
//        int orderStatus = orderStockListBean.getOrderStatus();
        if(viewHolder instanceof AccountpaidItem){//已付款
            AccountpaidItem accountpaidItem = (AccountpaidItem) viewHolder;
                accountpaidItem.mYifuCommodityAmount.setText("数量：" + orderStockListBean.getCommodityAmount());
                accountpaidItem.mYifuCommodityPrice.setText("应付金额：" + orderStockListBean.getCommodityPrice());
                accountpaidItem.mYifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());

                accountpaidItem.mYifuComPrice.setText("单价￥：" + commodity.getComPrice());
                accountpaidItem.mYifuGamemoney.setText(commodity.getComName());
                Glide.with(context).load(commodity.getComImg()).placeholder(R.mipmap.icon).into(accountpaidItem.mYifuComImg);

                accountpaidItem.mYifuUpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (accountpaidTosetOnclikListener != null) {
                            accountpaidTosetOnclikListener.setonclik(i);
                        }
                    }
                });
        }else if (viewHolder instanceof ObligationItem)//带付款
             {//待付款
                ObligationItem vh = (ObligationItem) viewHolder;
                String comImg = commodity.getComImg();
                String comName = commodity.getComName();
                double comPrice = commodity.getComPrice();
                Glide.with(context).load(comImg).placeholder(R.mipmap.icon).into(vh.mDaifuComImg);
                vh.mDaifuPirce.setText("单价￥：" + comPrice);
                vh.mDaifuGcomName.setText(comName);
                vh.mDaifuCommodityPrice.setText("应付金额￥："+orderStockListBean.getCommodityPrice());
                vh.mDaifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());
                vh.mDaifuOrderBuildTime.setText("下单时间" + orderStockListBean.getOrderBuildTime());
                int commodityAmount = orderStockListBean.getCommodityAmount();
                vh.mDaifuCommodityAmount.setText("数量：" + commodityAmount);
                vh.mDaifuGetGatheringBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (obligationTestOnclikListener != null) {
                            obligationTestOnclikListener.setonclik(i);
                        }
                    }
                });
        }
    }
    @Override
    public int getItemCount() {
        return list!=null ? list.size() :0;
    }
    @Override
    public int getItemViewType(int position) {

        TestInventory.DataBean.OrderStockListBean orderStockListBean = list.get(position);

        if (orderStockListBean.getOrderStatus()==1  ){//待付款

            return 1;

        }else if (orderStockListBean.getOrderStatus()==2){//已付款

            return 2;

        }

        return super.getItemViewType(position);
    }

    public void setData(TestInventory.DataBean.CommodityBean commodity) {
        this.commodity = commodity;
        notifyDataSetChanged();
    }
    //已付款
    public class AccountpaidItem extends RecyclerView.ViewHolder {
        @BindView(R.id.yifu_orderNumber)
        TextView mYifuOrderNumber;
        @BindView(R.id.yifu_comImg)
        ImageView mYifuComImg;
        @BindView(R.id.yifu_gamemoney)
        TextView mYifuGamemoney;
        @BindView(R.id.yifu_comPrice)
        TextView mYifuComPrice;
        @BindView(R.id.yifu_commodityAmount)
        TextView mYifuCommodityAmount;
        @BindView(R.id.yifu_commodityPrice)
        TextView mYifuCommodityPrice;
        @BindView(R.id.yifu_up_btn)
        TextView mYifuUpBtn;
        public AccountpaidItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //未付款
    public class ObligationItem extends RecyclerView.ViewHolder {
        @BindView(R.id.daifu_orderNumber)
        TextView mDaifuOrderNumber;
        @BindView(R.id.daifu_comImg)
        ImageView mDaifuComImg;
        @BindView(R.id.daifu_gcomName)
        TextView mDaifuGcomName;
        @BindView(R.id.daifu_pirce)
        TextView mDaifuPirce;
        @BindView(R.id.daifu_commodityAmount)
        TextView mDaifuCommodityAmount;
        @BindView(R.id.daifu_commodityPrice)
        TextView mDaifuCommodityPrice;
        @BindView(R.id.daifu_orderBuildTime)
        TextView mDaifuOrderBuildTime;
        @BindView(R.id.daifu_getGathering_btn)
        TextView mDaifuGetGatheringBtn;
        @BindView(R.id.daifu_cancel_orderform)
        TextView mDaifuCancelOrderform;
        public ObligationItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    //待付款
    private ObligationTestOnclikListener obligationTestOnclikListener;
    public interface ObligationTestOnclikListener{
        void  setonclik(int index);
    }
    public void setObligationTestOnclikListener(ObligationTestOnclikListener obligationTestOnclikListener) {
        this.obligationTestOnclikListener = obligationTestOnclikListener;
    }

    //跳转确认信息接口回调
    private AccountpaidTosetOnclikListener accountpaidTosetOnclikListener;
    public interface AccountpaidTosetOnclikListener{
        void  setonclik(int index);
    }
    public void setAccountpaidTosetOnclikListener(AccountpaidTosetOnclikListener accountpaidTosetOnclikListener) {
        this.accountpaidTosetOnclikListener = accountpaidTosetOnclikListener;
    }
}
