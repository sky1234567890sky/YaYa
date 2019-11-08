package com.administrator.yaya.activity.inventory.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.home.AffirmMessageActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.bean.invite.TestObligation;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
public class ObligationAdapter extends RecyclerView.Adapter<ObligationAdapter.Vh>{
    private List<TestObligation.DataBean.CommodityBean> commodity;
    private Context context;
    private List<TestObligation.DataBean.OrderStockListBean> list;
    private final FragmentActivity activity;


    public ObligationAdapter(List<TestObligation.DataBean.CommodityBean> commodity, List<TestObligation.DataBean.OrderStockListBean> list, FragmentActivity activity) {
        this.commodity = commodity;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.obligation_item, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, final int i) {
//        list = data.getOrderStockList();
        TestObligation.DataBean.OrderStockListBean orderStockListBean = list.get(i);
        TestObligation.DataBean.CommodityBean commodityBean = commodity.get(0);

        String comImg = commodityBean.getComImg();
        String comName = commodityBean.getComName();
        double comPrice = commodityBean.getComPrice();
//
        Glide.with(context).load(comImg).placeholder(R.mipmap.icon).into(vh.mDaifuComImg);
        vh.mDaifuPirce.setText("单价￥："+comPrice);
        vh.mDaifuGcomName.setText(comName);

        vh.mDaifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());
//        进货订单集合	orderStockList
//        订单编号	orderNumber
//        下单时间	orderBuildTime
        vh.mDaifuOrderBuildTime.setText("下单时间" + orderStockListBean.getOrderBuildTime());
//        数量		commodityAmount
        vh.mDaifuCommodityAmount.setText("数量：" + orderStockListBean.getCommodityAmount());
//        应付金额	commodityPrice
        vh.mDaifuCommodityPrice.setText("应付金额：" + orderStockListBean.getCommodityPrice());

        vh.mDaifuGetGatheringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AffirmMessageActivity.class);
                intent.putExtra("OrderNumber",list.get(i).getOrderNumber());
                activity.startActivity(intent);
            }
        });

        vh.mDaifuCancelOrderform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取消进货订单
                if (accountpaidsetOnclikListener!=null){
                    accountpaidsetOnclikListener.setonclik(i);
                }
            }
        });
//        EventBus.getDefault().postSticky(amount);
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
    public class Vh extends RecyclerView.ViewHolder {
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
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private AccountpaidsetOnclikListener accountpaidsetOnclikListener;

    public interface AccountpaidsetOnclikListener {
        void setonclik(int postion);
    }
    public void setAccountpaidsetOnclikListener(AccountpaidsetOnclikListener accountpaidsetOnclikListener) {
        this.accountpaidsetOnclikListener = accountpaidsetOnclikListener;
    }
}
