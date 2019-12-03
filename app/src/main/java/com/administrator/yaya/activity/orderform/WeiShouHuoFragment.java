package com.administrator.yaya.activity.orderform;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.orderform.adapter.WeiShouHuoAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestCancel;
import com.administrator.yaya.bean.orderform.TestConfirmReceipt;
import com.administrator.yaya.bean.orderform.TestNoReceipt;
import com.administrator.yaya.fragment.OrderFormkFragment;
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
 * 未收货
 */
public class WeiShouHuoFragment extends BaseMvpFragment<LoginModel> implements ICommonView {
    @BindView(R.id.cancel_lv)
    RecyclerView mList;
    @BindView(R.id.cancel_refreshLayout)
    SmartRefreshLayout cacelRefreshLayout;
    private WeiShouHuoAdapter adapter;
    private OrderFormkFragment parentFragment1;
    private TestCancel.DataBean data;
    private TextView tvObligation;
    private String userId;
    private String token;
    private List<TestCancel.DataBean.OrderSalesListBean> list = new ArrayList<>();
    private int noReceiverIndex;

    public WeiShouHuoFragment() {
        // Required empty public constructor
    }

    //判断是否展示—与ViewPager连用，进行左右切换
    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //不可见的时候关闭加载
        if (isVisibleToUser == true) {//当前处于可见状态
            if (cacelRefreshLayout !=null)
                refresh();
        }
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
//        hideLoadingDialog();
        switch (whichApi) {
            case ApiConfig.TEST_CANCEL://未收货
                list.clear();
                TestCancel testCancel = (TestCancel) t[0];
                if (testCancel.getMsg().equals(SignOut)) {
                    Toast.makeText(getActivity(), R.string.username_login_hint + "", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");
                    startActivity(intent);
                    getActivity().finish();

                }else if (testCancel.getCode() == 0 && !testCancel.getMsg().equals(SignOut)) {
                    data = testCancel.getData();
//                    进货订单集合	orderSalesList
                    if (TextUtils.isEmpty(data.getAmount())) {

                        tvObligation.setText("今日收款：0");//库存  父 Fragment 顶部赋值

                    } else {

                        tvObligation.setText("今日收款：" + data.getAmount());//库存  父 Fragment 顶部赋值

                    }
                    List<TestCancel.DataBean.OrderSalesListBean> orderStockList = data.getOrderSalesList();
                    list.addAll(orderStockList);
                    adapter.setData(data.getCommodity());
                    adapter.notifyDataSetChanged();
                }
                break;
                //再次确认(确认收货的接口)
            case ApiConfig.TEST_CONFIRM_RECEIPT:
                TestConfirmReceipt testConfirmReceipt = (TestConfirmReceipt) t[0];

                if (testConfirmReceipt.getMsg().equals(SignOut)) {
                    ToastUtil.showLong(R.string.username_login_hint + "");
                    Intent login = new Intent(getActivity(), LoginActivity.class);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");
                    startActivity(login);
                    getActivity().finish();
                }
                if (testConfirmReceipt.getCode() == 0 && !testConfirmReceipt.getMsg().equals(SignOut)) {
                    ToastUtil.showShort(testConfirmReceipt.getMsg());
//                    listBean.remove(reconfirmIndex);
//                    adapter.notifyItemChanged(reconfirmIndex);
                    adapter.notifyDataSetChanged();
                }
                //刷新
                refresh();

//            case ApiConfig.TEST_NO_RECEIVER_GOODS:
//                TestNoReceipt testNoReceipt = (TestNoReceipt) t[0];
//                if (testNoReceipt.getMsg().equals(SignOut)) {
//                    Toast.makeText(getActivity(), "您的当前账户已在其他设备登陆，为安全起见，请及时修改密码或重新登陆！", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");
//                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");
//                    startActivity(intent);
//                    getActivity().finish();
//                } else if (!testNoReceipt.getMsg().equals(SignOut) && testNoReceipt.getCode() == 0) {
//                    ToastUtil.showLong(testNoReceipt.getMsg());
//                    adapter.notifyDataSetChanged();
////                    refresh();
//                }
//
//                break;
        }
        cacelRefreshLayout.finishRefresh();
        cacelRefreshLayout.finishLoadMore();
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        if (parentFragment1 == null) {
            getFragment();
        }
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        initRecycleView(mList, cacelRefreshLayout);
        adapter = new WeiShouHuoAdapter(list, getActivity());
//        cacelRefreshLayout.setEnableLoadMore(false);
        mList.setAdapter(adapter);
    }

    private void getFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof OrderFormkFragment) {
            parentFragment1 = (OrderFormkFragment) parentFragment;//父 Fragment
            // 父 TestView
            if (parentFragment1.getView().findViewById(R.id.orderform_inventory_money) != null) {
                tvObligation = parentFragment1.getView().findViewById(R.id.orderform_inventory_money);
            }
        }
    }
    @Override
    protected void initData() {
        super.initData();
//        showLoadingDialog();
        userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getContext(), NormalConfig.TOKEN);
        //未收货
        mPresenter.getData(ApiConfig.TEST_CANCEL, Integer.parseInt(userId), token);//otherOrderSales
    }

    @Override
    protected void initListener() {
        super.initListener();
        //再次确认（走确认收货的接口）
        adapter.setCancelsetOnclikListener(new WeiShouHuoAdapter.CancelsetOnclikListener() {
            @Override
            public void setonclik(int postion) {

                noReceiverIndex = postion;

                int salesId = list.get(postion).getSalesId();

//                mPresenter.getData(ApiConfig.TEST_NO_RECEIVER_GOODS, salesId, Integer.parseInt(userId), token);

                mPresenter.getData(ApiConfig.TEST_CONFIRM_RECEIPT, salesId, Integer.parseInt(userId), token);
            }
        });
    }
    @Override
    public void refresh() {
        super.refresh();

        //自动回弹
        cacelRefreshLayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                cacelRefreshLayout.finishRefresh();

            }
        }, 200l);

        mList.scrollToPosition(0);//回到列表顶部

//        cacelRefreshLayout.autoRefresh();//自动刷新

        initData();//刷新
    }
    @Override
    public void loadMore() {
        super.loadMore();

        cacelRefreshLayout.finishLoadMoreWithNoMoreData();

        cacelRefreshLayout.setEnableScrollContentWhenLoaded(true);//设置是否在全部加载结束之后Footer跟随内容
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
    protected int getLayoutId() {
        return R.layout.fragment_cancel;
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong(R.string.error+"");
    }

//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        if (!hidden && getActivity() != null) {
//            if (cacelRefreshLayout != null)
//                refresh();
//        }
//    }
}
