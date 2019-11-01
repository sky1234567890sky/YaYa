package com.administrator.yaya.activity.inventory.fragment;

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
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.utils.FragmentUtils;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountPaidAdapter extends RecyclerView.Adapter<AccountPaidAdapter.AccountpaidItem> implements View.OnClickListener {

    private List<TestAccountPaid.DataBean.OrderStockListBean> list;
    private final FragmentActivity fragmentActivity;
    private Context context;
    private PopupWindow popupWindow;
    private ImageView mCancelPopCloseIv;
    private TextView mPopupTvNumber;
    private TextView mPopupTvCancel;
    private TextView mPopupTvOk;
    private TestAccountPaid.DataBean.OrderStockListBean orderStockListBean;

    public AccountPaidAdapter(List<TestAccountPaid.DataBean.OrderStockListBean> orderStockList, FragmentActivity fragmentActivity) {
        this.list = orderStockList;
        this.fragmentActivity = fragmentActivity;
    }
    public void setData(List<TestAccountPaid.DataBean.OrderStockListBean> list) {
        this.list = list;
        AccountPaidAdapter.this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AccountpaidItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new AccountpaidItem(View.inflate(context, R.layout.accountpaid_item, null));
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AccountpaidItem accountpaidItem, @SuppressLint("RecyclerView") final int i) {
        orderStockListBean = list.get(i);
        accountpaidItem.mYifuCommodityAmount.setText("数量："+ orderStockListBean.getCommodityAmount());
        accountpaidItem.mYifuCommodityPrice.setText("付款金额：" + orderStockListBean.getCommodityPrice());
        accountpaidItem.mYifuComPrice.setText("单价￥：" + orderStockListBean.getCommodityPrice());
//        accountpaidItem.mYifuGamemoney.setText("");
        accountpaidItem.mYifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());
//        Glide.with(context).load().into(accountpaidItem.mYifuComImg)

        accountpaidItem.itemView.setOnClickListener(this);

        accountpaidItem.itemView.setOnClickListener(new View.OnClickListener() {
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

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yifu_up_btn://上架
                pupAway();
                break;
        }
    }
    private void pupAway() {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_putaway, null);
        //显示营业游戏币数量
        mCancelPopCloseIv = inflate.findViewById(R.id.cancel_pop_close_iv);
        mPopupTvNumber = inflate.findViewById(R.id.popup_tv_number);
        mPopupTvCancel = inflate.findViewById(R.id.popup_tv_cancel);
        mPopupTvOk = inflate.findViewById(R.id.popup_tv_ok);

        mPopupTvNumber.setText(orderStockListBean.getCommodityAmount());//数量

        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = new MainActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        new MainActivity().getWindow().setAttributes(lp);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = new MainActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                new Activity().getWindow().setAttributes(lp);
            }
        });
//        mCancelPopCloseIv.setOnClickListener(this);
//        mPopupTvCancel.setOnClickListener(this);
//        mPopupTvOk.setOnClickListener(this);

        mCancelPopCloseIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        mPopupTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        mPopupTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                直接营业
//                FragmentTransaction fragmentTransaction = new FragmentManager().beginTransaction();
                FragmentUtils.addFragment(fragmentActivity.getSupportFragmentManager(),new OrderFormkFragment().getClass(), R.id.home_fragment);
//                startActivity(new Intent(MainActivity.this,UpGameMoneyActivity.class));
                popupWindow.dismiss();
            }
        });
        popupWindow.setOutsideTouchable(false);
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
