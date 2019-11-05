package com.administrator.yaya.activity.inventory.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.bean.invite.TestObligation;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.utils.FragmentUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountPaidAdapter extends RecyclerView.Adapter<AccountPaidAdapter.AccountpaidItem> {

    private final List<TestObligation.DataBean.OrderStockListBean> list;
    private final FragmentActivity fragmentActivity;
    private Context context;
    private PopupWindow popupWindow;
    private ImageView mCancelPopCloseIv;
    private TextView mPopupTvNumber;
    private TextView mPopupTvCancel;
    private TextView mPopupTvOk;

    public AccountPaidAdapter(List<TestObligation.DataBean.OrderStockListBean> list, FragmentActivity activity) {
        this.list = list;
        fragmentActivity = activity;
    }

    @NonNull
    @Override
    public AccountpaidItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.accountpaid_item, null);
        return new AccountpaidItem(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AccountpaidItem accountpaidItem, @SuppressLint("RecyclerView") final int i) {
        final TestObligation.DataBean.OrderStockListBean orderStockListBean = list.get(i);
        accountpaidItem.mYifuCommodityAmount.setText("数量："+ orderStockListBean.getCommodityAmount());
        accountpaidItem.mYifuCommodityPrice.setText("付款金额：" + orderStockListBean.getCommodityPrice());
        accountpaidItem.mYifuComPrice.setText("单价￥：" + orderStockListBean.getCommodityPrice());
//        accountpaidItem.mYifuGamemoney.setText("");
        accountpaidItem.mYifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());
//        Glide.with(context).load().into(accountpaidItem.mYifuComImg)

        accountpaidItem.mYifuUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (accountpaidsetOnclikListener != null) {
                    accountpaidsetOnclikListener.setonclik(i);
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

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

    private AccountpaidsetOnclikListener accountpaidsetOnclikListener;

    public interface AccountpaidsetOnclikListener {
        void setonclik(int postion);
    }
    public void setAccountpaidsetOnclikListener(AccountpaidsetOnclikListener accountpaidsetOnclikListener) {
        this.accountpaidsetOnclikListener = accountpaidsetOnclikListener;
    }
}
