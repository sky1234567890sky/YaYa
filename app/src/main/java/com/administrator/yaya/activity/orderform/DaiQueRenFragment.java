package com.administrator.yaya.activity.orderform;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.orderform.adapter.DaiQueRenAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestConfirmReceipt;
import com.administrator.yaya.bean.orderform.TestFinish;
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
 * 待确认
 */
public class DaiQueRenFragment extends BaseMvpFragment<LoginModel> implements ICommonView {


    @BindView(R.id.weishouhuo_list)
    RecyclerView mList;
    @BindView(R.id.weishouhuo_refreshLayout)
    SmartRefreshLayout mRefresh;
    private String userId;
    private String token;
    private OrderFormkFragment parentFragment1;
    private TextView tvObligation;
    private DaiQueRenAdapter adapter;
    private TestFinish.DataBean data;
    private List<TestFinish.DataBean.OrderSalesListBean> list = new ArrayList<>();
    private int reconfirmIndex;
    private int noReceiverIndex;

    public DaiQueRenFragment() {

    }
    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //不可见的时候关闭加载
        if (isVisibleToUser ==true){//当前处于可见状态
            if (mRefresh != null)
                refresh();
        }
    }
    @Override
    public void refresh() {
        super.refresh();
        //自动回弹
        mRefresh.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefresh.finishRefresh();

            }
        }, 200l);
        mList.scrollToPosition(0);
//        mRefresh.autoRefresh();
        initData();
    }

    @Override
    public void loadMore() {
        super.loadMore();
        mRefresh.finishLoadMoreWithNoMoreData();

        mRefresh.setEnableScrollContentWhenLoaded(true);//设置是否在全部加载结束之后Footer跟随内容
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        if (parentFragment1 == null) {
            getFragment();
        }
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        initRecycleView(mList,mRefresh);
//        mRefresh.setEnableLoadMore(false);
        adapter = new DaiQueRenAdapter(list);
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
    protected void initListener() {
        super.initListener();

        //确认收货
        adapter.setAccountpaidsetOnclikListener(new DaiQueRenAdapter.AccountpaidsetOnclikListener() {
            @Override
            public void setonclik(int postion) {

                reconfirmIndex = postion;

                int salesId = list.get(postion).getSalesId();

                mPresenter.getData(ApiConfig.TEST_CONFIRM_RECEIPT, salesId, Integer.parseInt(userId), token);

            }
        });

        //未收货（不用）
        adapter.setCancelsetOnclikListener(new DaiQueRenAdapter.CancelsetOnclikListener() {
            @Override
            public void setonclik(int postion) {
                noReceiverIndex = postion;
                int salesId = list.get(postion).getSalesId();
//                mPresenter.getData(ApiConfig.TEST_NO_RECEIVER_GOODS, salesId, Integer.parseInt(userId), token);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
//        showLoadingDialog();

        userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getContext(), NormalConfig.TOKEN);

        mPresenter.getData(ApiConfig.TEST_FINISH,Integer.parseInt(userId),token,1);//待确认
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dai_que_ren;
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        ToastUtil.showLong( getResources().getString(R.string.error));
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
//        hideLoadingDialog();
        switch (whichApi) {
            case ApiConfig.TEST_FINISH:
                list.clear();

                TestFinish testFinish = (TestFinish) t[0];

                if (testFinish.getMsg().equals(SignOut)){

                    Toast.makeText(getActivity(), R.string.username_login_hint+"", Toast.LENGTH_SHORT).show();

                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();
                }else if (testFinish.getCode()==0 && !testFinish.getMsg().equals(SignOut)){

                    data = testFinish.getData();

                    if (tvObligation != null) {
                        if (TextUtils.isEmpty(data.getAmount())) {
                            tvObligation.setText("今日收款：0");//库存  父 Fragment 顶部赋值
                        } else {
                            tvObligation.setText("今日收款：" + data.getAmount());//库存  父 Fragment 顶部赋值
                        }
                    }

                    List<TestFinish.DataBean.OrderSalesListBean> orderSalesList = data.getOrderSalesList();
                    TestFinish.DataBean.CommodityBean commodity = data.getCommodity();
                    list.addAll(orderSalesList);
                    adapter.setData(commodity);
                    adapter.notifyDataSetChanged();
                }
                break;
                //确认收货
            case ApiConfig.TEST_CONFIRM_RECEIPT:
                TestConfirmReceipt testConfirmReceipt = (TestConfirmReceipt) t[0];

                if (testConfirmReceipt.getMsg().equals(SignOut)) {
                    ToastUtil.showLong( getResources().getString(R.string.username_login_hint));
                    Intent login = new Intent(getActivity(), LoginActivity.class);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");
                    startActivity(login);
                    getActivity().finish();
                }

                if (testConfirmReceipt.getCode() == 0 && !testConfirmReceipt.getMsg().equals(SignOut)) {
                    ToastUtil.showShort(testConfirmReceipt.getMsg());
                    list.remove(reconfirmIndex);
                    adapter.notifyItemChanged(reconfirmIndex);
                }
                //刷新
                refresh();
                break;
                //未收货
            case ApiConfig.TEST_NO_RECEIVER_GOODS:
                TestNoReceipt testNoReceipt = (TestNoReceipt) t[0];
                if (testNoReceipt.getMsg().equals(SignOut)) {
                    ToastUtil.showLong( getResources().getString(R.string.username_login_hint));
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");
                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");
                    startActivity(intent);
                    getActivity().finish();
                }
                if (!testNoReceipt.getMsg().equals(SignOut) && testNoReceipt.getCode() == 0) {
                    ToastUtil.showLong(testNoReceipt.getMsg());
                    //Weishouho
                    list.remove(noReceiverIndex);

                    adapter.notifyItemChanged(noReceiverIndex);
                }
                refresh();
                break;
        }
        mRefresh.finishRefresh();
        mRefresh.finishLoadMore();
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }
//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        if (getActivity()!=null &&!hidden ){
//            if (mRefresh!=null){
//                refresh();
//            }
//        }
//    }

}