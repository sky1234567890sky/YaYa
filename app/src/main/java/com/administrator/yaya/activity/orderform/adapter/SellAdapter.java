package com.administrator.yaya.activity.orderform.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.SellFragment;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.utils.MyPermission;
import com.administrator.yaya.utils.ToastUtil;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SellAdapter extends RecyclerView.Adapter<SellAdapter.Vh>{
    private List<TestAllOrderStock.DataBean.OrderStockListBean> list;
    private final FragmentActivity activity;
    private Context context;

    public SellAdapter(List<TestAllOrderStock.DataBean.OrderStockListBean> list, FragmentActivity activity) {

        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.sell_item, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, @SuppressLint("RecyclerView") final int i) {
        TestAllOrderStock.DataBean.OrderStockListBean orderStockListBean = list.get(i);
//        进货订单集合	orderSalesList
//        订单id		salesId
//        订单编号	orderNumber
        String orderNumber = orderStockListBean.getOrderNumber();

        vh.mSellOrderNumber.setText("【微信】订单编号："+orderNumber);
//        下单时间	salesBuildTime
//        数量		salesAmount
//        应付金额	salesAmountMoney
//        收款方式	orderPayTpe		0无  1微信  2支付宝
//        状态		salesStatus		1售卖中 2 已完成 3已取消
//        操作时间	salesUpdateTime
//        货物信息对象	commodity
//        货物名称	comName
        vh.mSellGcomName.setText("");
//        vh.mSellGcomName.setText();
//        货物单价	comPrice
        vh.mSellCommodityPrice.setText("");
//        货物图片	comImg
//        库存数量	comInventory
        vh.mSellCommodityAmount.setText("售卖数量：");
//        最小购买数量comPurchaseNumMin
//                最大购买数量comPurchaseNumMax
//        今日收款数		amount
        //点击事件
        vh.mSellGetGatheringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort("这要解析数据啊"+i);
            }
        });//确认收货
        vh.mSellCancelOrderform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort("这要解析数据啊"+i);
            }
        });//取消售卖

    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.sell_orderNumber)
        TextView mSellOrderNumber;
        @BindView(R.id.sell_comImg)
        ImageView mSellComImg;
        @BindView(R.id.sell_gcomName)
        TextView mSellGcomName;
        @BindView(R.id.sell_commodityAmount)
        TextView mSellCommodityAmount;
        @BindView(R.id.sell_commodityPrice)
        TextView mSellCommodityPrice;
        @BindView(R.id.sell_getGathering_btn)
        TextView mSellGetGatheringBtn;
        @BindView(R.id.sell_cancel_orderform)
        TextView mSellCancelOrderform;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
