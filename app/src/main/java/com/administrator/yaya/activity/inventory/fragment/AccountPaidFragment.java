package com.administrator.yaya.activity.inventory.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.BR;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.bean.invite.TestUpawaySingleGoods;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.FragmentUtils;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * 已付款
 */
public class AccountPaidFragment extends BaseMvpFragment<LoginModel> implements ICommonView{

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
    //    @BindView(R.id.accountpaid_list)
//    RecyclerView mList;
    List<TestAccountPaid.DataBean.OrderStockListBean> list;
    private AccountPaidAdapter adapter;
    private ImageView mCancelPopCloseIv;
    private TextView mPopupTvNumber;
    private TextView mPopupTvCancel;
    private TextView mPopupTvOk;
    private PopupWindow popupWindow;
    private String amount;
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
//        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mList.setNestedScrollingEnabled(false);
//        adapter = new AccountPaidAdapter(list, getActivity());
//        mList.setAdapter(adapter);
//        if (list==null){
//            TestAccountPaid.DataBean.OrderStockListBean orderStockList = list.get(0);
//            mYifuCommodityAmount.setText("数量：" + orderStockList.getCommodityAmount());
//            mYifuCommodityPrice.setText("付款金额：" + orderStockList.getCommodityPrice());
//            mYifuComPrice.setText("单价￥：" + orderStockList.getCommodityPrice());
////        accountpaidItem.mYifuGamemoney.setText("");
//            mYifuOrderNumber.setText("订单编号：" + orderStockList.getOrderNumber());
//        }
    }
    @Override
    protected void initListener() {
        super.initListener();
        mYifuUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putAway();
            }
        });
//        adapter.setAccountpaidsetOnclikListener(new AccountPaidAdapter.AccountpaidsetOnclikListener() {
//            @Override
//            public void setonclik(int postion) {
//            }
//        });

    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_GATHERING2://已付款
                TestAccountPaid testAccountPaid = (TestAccountPaid) t[0];
                if (testAccountPaid.getCode() == 0 && testAccountPaid.getData()!= null) {
                    //库存合计数量	amount
                    amount = testAccountPaid.getData().getAmount();
                    TestAccountPaid.DataBean data = testAccountPaid.getData();
                    List<TestAccountPaid.DataBean.OrderStockListBean> orderStockList = data.getOrderStockList();
                    list.addAll(orderStockList);
                    Log.i("tag", "已付款：: "+testAccountPaid.toString());
                    if (orderStockList .size()>0){
                        TestAccountPaid.DataBean.OrderStockListBean orderStockListBean = orderStockList.get(0);
                        mYifuCommodityAmount.setText("数量：" + orderStockListBean.getCommodityAmount());
                        mYifuCommodityPrice.setText("付款金额：" + orderStockListBean.getCommodityPrice());
                        mYifuComPrice.setText("单价￥：" + orderStockListBean.getCommodityPrice());
//                      accountpaidItem.mYifuGamemoney.setText("");
                        mYifuOrderNumber.setText("订单编号：" + orderStockListBean.getOrderNumber());
                    }else{
                        return;
                    }
//                    adapter.notifyDataSetChanged();
//                    adapter.setData(orderStockList);
//                    adapter.notifyDataSetChanged();
//                    mYifuOrderNumber.setText("订单编号:"+);
//                    Glide.with(this).load(comImg).into(nowBuGamemoneyIv);
                } else {
                    ToastUtil.showShort(testAccountPaid.getMsg());
                }
                break;
            case ApiConfig.TEST_UPAWAY_SINGLE_GOODS://上架单个货物
                TestUpawaySingleGoods testUpawaySingleGoods = (TestUpawaySingleGoods)t[0];
                if (testUpawaySingleGoods.getCode()==0 && testUpawaySingleGoods.getMsg()!=null){
                    ToastUtil.showShort(testUpawaySingleGoods.getMsg());
                }else{
                    ToastUtil.showShort(testUpawaySingleGoods.getMsg());
                }
                break;

        }
    }
    @SuppressLint("CheckResult")
    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId != null) mPresenter.getData(ApiConfig.TEXT_GATHERING2, Integer.parseInt(userId), 2);//已付款
//        Rx2AndroidNetworking.post("http://192.168.0.198:8080/yayaApp/comBuy/allOrderStock?userId=1&orderStatus=2")
//                .build()
//                .getStringObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                });
    }
    private AccountpaidOnclikListener accountpaidOnclikListener;
    public interface  AccountpaidOnclikListener{
        void setonclik(String amount);
    }
    public void setAccountpaidOnclikListener(AccountpaidOnclikListener accountpaidOnclikListener) {
        this.accountpaidOnclikListener = accountpaidOnclikListener;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_paid;
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }
    public AccountPaidFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    private void putAway() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_putaway, null);
        //显示营业游戏币数量
        mCancelPopCloseIv = inflate.findViewById(R.id.cancel_pop_close_iv);
        mPopupTvNumber = inflate.findViewById(R.id.popup_tv_number);
        mPopupTvCancel = inflate.findViewById(R.id.popup_tv_cancel);
        mPopupTvOk = inflate.findViewById(R.id.popup_tv_ok);

        mPopupTvNumber.setText(amount+"");

//        if (orderStockList.size()>0) {
//            mPopupTvNumber.setText(orderStockList.get(0).getCommodityAmount());//数量
//        } else{
//            return;
//        }
        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        getActivity().getWindow().setAttributes(lp);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                getActivity().getWindow().setAttributes(lp);
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
                //上架单个货物（请求网络数据）
                mPresenter.getData(ApiConfig.TEST_UPAWAY_SINGLE_GOODS,"191104104823647");//传入订单编号
//                直接营业
//                FragmentTransaction fragmentTransaction = new FragmentManager().beginTransaction();
//                FragmentUtils.addFragment(getChildFragmentManager(),new OrderFormkFragment().getClass(), R.id.home_fragment);
//                startActivity(new Intent(MainActivity.this,UpGameMoneyActivity.class));
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("orderform", 4);
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        popupWindow.setOutsideTouchable(false);
    }

}
