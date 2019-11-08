package com.administrator.yaya.activity.inventory.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.activity.inventory.adapter.AccountPaidAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.bean.invite.TestUpawaySingleGoods;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 已付款
 */
public class AccountPaidFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
//    @BindView(R.id.yifu_orderNumber)
//    TextView mYifuOrderNumber;
//    @BindView(R.id.yifu_comImg)
//    ImageView mYifuComImg;
//    @BindView(R.id.yifu_gamemoney)
//    TextView mYifuGamemoney;
//    @BindView(R.id.yifu_comPrice)
//    TextView mYifuComPrice;
//    @BindView(R.id.yifu_commodityAmount)
//    TextView mYifuCommodityAmount;
//    @BindView(R.id.yifu_commodityPrice)
//    TextView mYifuCommodityPrice;
//    @BindView(R.id.yifu_up_btn)
//    TextView mYifuUpBtn;

        @BindView(R.id.accountpaid_list)
        RecyclerView mList;
        @BindView(R.id.account_refreshLayout)
        SmartRefreshLayout accountRefreshLayout;
        List<TestAccountPaid.DataBean.OrderStockListBean> list ;
        List<TestAccountPaid.DataBean.CommodityBean> commodityBean;

        private AccountPaidAdapter adapter;
        private ImageView mCancelPopCloseIv;
    private TextView mPopupTvNumber;
    private TextView mPopupTvCancel;
    private TextView mPopupTvOk;
    private PopupWindow popupWindow;

    private String inventoryNumber;//库存数量

    private int num = 2;
    private TestAccountPaid.DataBean data;
    private int index;
    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        commodityBean = new ArrayList<>();
        initRecycleView(mList,accountRefreshLayout);
        accountRefreshLayout.setEnableLoadMore(false);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mList.setNestedScrollingEnabled(false);
        adapter = new AccountPaidAdapter(commodityBean,list,getActivity());
        mList.setAdapter(adapter);
    }
    @Override
    public void refresh() {
        super.refresh();
//        InventoryFragment ben = new InventoryFragment();
//        ben.initData();
        List<Fragment> fragments = (List<Fragment>)AccountPaidFragment.this.getFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            if (fragment!=null && fragment instanceof InventoryFragment){
                ((InventoryFragment)fragment).initData();
                break;
            }
        }
        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();
    }

    @Override
    protected void initListener() {
        super.initListener();

        adapter.setAccountpaidsetOnclikListener(new AccountPaidAdapter.AccountpaidsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                index = postion;
                String amount = data.getAmount();//库存数量
                putAway(amount);
            }
        });
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEXT_GATHERING2:
                list.clear();
                TestAccountPaid testObligation = (TestAccountPaid) t[0];
                data = testObligation.getData();
                List<TestAccountPaid.DataBean.OrderStockListBean> orderStockList = data.getOrderStockList();
                if (testObligation.getCode() == 0 && testObligation.getData() != null) {
                    Log.i("tag", "已付款。。。: "+testObligation.toString());
                    commodityBean.add(testObligation.getData().getCommodity());
                    list.addAll(testObligation.getData().getOrderStockList());
                    adapter.notifyDataSetChanged();
                }else{
                    ToastUtil.showShort(testObligation.getMsg());
                }
                break;
            case ApiConfig.TEST_UPAWAY_SINGLE_GOODS://上架单个货物
                TestUpawaySingleGoods testUpawaySingleGoods = (TestUpawaySingleGoods) t[0];
                if (testUpawaySingleGoods.getCode() == 0 && testUpawaySingleGoods.getMsg() != null) {
                    ToastUtil.showShort(testUpawaySingleGoods.getMsg());
                } else {
                    ToastUtil.showShort(testUpawaySingleGoods.getMsg());
                }
                break;
        }
        accountRefreshLayout.finishRefresh(2000);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initData() {
        super.initData();

        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        mPresenter.getData(ApiConfig.TEXT_GATHERING2, Integer.parseInt(userId), num);//已付款
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
    }
    @SuppressLint("SetTextI18n")
    private void putAway(String amount) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_putaway, null);
        //显示营业游戏币数量
        mCancelPopCloseIv = inflate.findViewById(R.id.cancel_pop_close_iv);
        mPopupTvNumber = inflate.findViewById(R.id.popup_tv_number);
        mPopupTvCancel = inflate.findViewById(R.id.popup_tv_cancel);
        mPopupTvOk = inflate.findViewById(R.id.popup_tv_ok);
        mPopupTvNumber.setText(amount+"");//库存数量

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
//                String orderNumber = orderStockListBean.getOrderNumber();
                //上架单个货物（请求网络数据）
                mPresenter.getData(ApiConfig.TEST_UPAWAY_SINGLE_GOODS,list.get(index).getOrderNumber());//传入订单编号
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
