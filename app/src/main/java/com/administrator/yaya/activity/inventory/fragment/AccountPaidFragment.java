package com.administrator.yaya.activity.inventory.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.administrator.yaya.base.convert.BaseLazyLoadFragment;
import com.administrator.yaya.bean.invite.TestAccountPaid;
import com.administrator.yaya.bean.invite.TestUpawaySingleGoods;
import com.administrator.yaya.fragment.InventoryFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * 已付款
 */
public class AccountPaidFragment extends BaseLazyLoadFragment<LoginModel> implements ICommonView {
    @BindView(R.id.accountpaid_list)
    RecyclerView mList;
    @BindView(R.id.account_refreshLayout)
    SmartRefreshLayout accountRefreshLayout;
    List<TestAccountPaid.DataBean.OrderStockListBean> list;
    List<TestAccountPaid.DataBean.CommodityBean> commodityBean;
    private AccountPaidAdapter adapter;
    private ImageView mCancelPopCloseIv;
    private TextView mPopupTvNumber;
    private TextView mPopupTvCancel;
    private TextView mPopupTvOk;
    private PopupWindow popupWindow;
    private int num = 2;
    private TestAccountPaid.DataBean data;
    private int index;
    private InventoryFragment parentFragment1;
    private String amount;
    private TextView inventory_allgamemoneys;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser==true){
             inventory_allgamemoneys = ((InventoryFragment) getParentFragment()).getView().findViewById(R.id.inventory_allgamemoneys);
            if (TextUtils.isEmpty(amount) ) {
                inventory_allgamemoneys.setText("游戏币库存合计：0");//库存  父 Fragment 顶部赋值
            } else {
                inventory_allgamemoneys.setText("游戏币库存合计：" + amount);//库存  父 Fragment 顶部赋值
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_paid;
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
//        inventoryFragment = new InventoryFragment();
        list = new ArrayList<>();
        commodityBean = new ArrayList<>();
        initRecycleView(mList, accountRefreshLayout);
        accountRefreshLayout.setEnableLoadMore(false);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AccountPaidAdapter(commodityBean, list, getActivity());
        mList.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        super.refresh();
        accountRefreshLayout.autoLoadMore();
        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        mPresenter.getData(ApiConfig.TEXT_GATHERING2, Integer.parseInt(userId), num);//已付款
    }

    @Override
    protected void initListener() {
        super.initListener();
        //上架
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
                if (!list.isEmpty() || list != null) {
                    list.clear();
                }

                TestAccountPaid testObligation = (TestAccountPaid) t[0];
                //获取父Fragment控件
//                TextView tv_money = parentFragment1.getView().findViewById(R.id.inventory_allgamemoneys);
                data = testObligation.getData();
                amount = data.getAmount();

//                if(data.getAmount()!=null) {
////                    inventoryFragment.updater(data.getAmount());
//                    EventBus.getDefault().postSticky(amount);
//                }

              /*  if(accountPaidsetOnclikListener!=null) {
                    accountPaidsetOnclikListener.setonclik(amount);
                }*/
//                if(data.getAmount()==null) {
//                    tv_money.setText("游戏币库存合计：0");
//                }else{
//                    tv_money.setText("游戏币库存合计：" + data.getAmount());
//                }
                if (testObligation.getCode() == 0 && testObligation.getData() != null) {
//                    Log.i("tag", "已付款。。。: "+testObligation.toString());
//                    if (amount==null) {
//                        inventory_allgamemoneys.setText("游戏币库存合计：0");//库存  父 Fragment 顶部赋值
//                    } else {
//                        inventory_allgamemoneys.setText("游戏币库存合计：" + amount);//库存  父 Fragment 顶部赋值
//                    }
                    commodityBean.add(testObligation.getData().getCommodity());
                    list.addAll(testObligation.getData().getOrderStockList());
                    adapter.notifyDataSetChanged();
                } else {
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
        accountRefreshLayout.finishRefresh();//网络请求玩才计时
    }

    @Override
    public void onError(int whichApi, Throwable e) {
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
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
        mPopupTvNumber.setText(amount + "");//库存数量

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
                mPresenter.getData(ApiConfig.TEST_UPAWAY_SINGLE_GOODS, list.get(index).getOrderNumber());//传入订单编号
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

    //获取焦点时刷新
    @Override
    public void onResume() {
        super.onResume();
//        if(accountPaidsetOnclikListener!=null) {
//            accountPaidsetOnclikListener.setonclik(amount);
//        }
        if (isRefresh) {
            if (!list.isEmpty()) {
                list.clear();
            }
            refresh();
            isRefresh = false;
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (!isRefresh) isRefresh = true;
    }

    //接口回调
    private AccountPaidsetOnclikListener accountPaidsetOnclikListener;

    //重写懒加载方法
    @Override
    public void fetchData() {
//        initData();
    }

    public interface AccountPaidsetOnclikListener {
        void setonclik(String amount);
    }

    public void setAccountPaidsetOnclikListener(AccountPaidsetOnclikListener accountPaidsetOnclikListener) {
        this.accountPaidsetOnclikListener = accountPaidsetOnclikListener;
    }
    /* public void setAccountPaidsetOnclikListener(AccountPaidsetOnclikListener accountPaidsetOnclikListener) {
        this.accountPaidsetOnclikListener = accountPaidsetOnclikListener;
    }*/
}
