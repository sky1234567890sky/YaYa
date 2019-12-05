package com.administrator.yaya.activity.orderform;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.orderform.adapter.FinishAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestFinish;
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
 * 已完成
 */

public class FinishFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.finish_lv)
    RecyclerView mList;
    @BindView(R.id.finish_refreshLayout)
    SmartRefreshLayout finishRefresh;
    private List<TestFinish.DataBean.OrderSalesListBean> list = new ArrayList<TestFinish.DataBean.OrderSalesListBean>();
    private OrderFormkFragment parentFragment1;
    private TextView tvObligation;
    private String token;
    private String userId;
    private FinishAdapter adapter;

    public FinishFragment() {
    }
    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    //判断是否展示—与ViewPager连用，进行左右切换
    @SuppressLint("SetTextI18n")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //不可见的时候关闭加载
        if (isVisibleToUser == true) {//当前处于可见状态
            if (finishRefresh != null)
                refresh();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_finish;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        if (parentFragment1 == null) {
            getFragment();
        }
        initRecycleView(mList, finishRefresh);
//        finishRefresh.setEnableLoadMore(false);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FinishAdapter(list);
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
        //已完成
        userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getContext(), NormalConfig.TOKEN);
        mPresenter.getData(ApiConfig.TEST_FINISH, Integer.parseInt(userId), token, 2);//已完成
    }

    @Override
    public void refresh() {
        super.refresh();
        //自动回弹
        finishRefresh.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishRefresh.finishRefresh();

            }
        }, 200l);
        mList.scrollToPosition(0);
//        finishRefresh.autoRefresh();
        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();


        finishRefresh.finishLoadMoreWithNoMoreData();

        finishRefresh.setEnableScrollContentWhenLoaded(true);//设置是否在全部加载结束之后Footer跟随内容

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
            case ApiConfig.TEST_FINISH://已完成
                list.clear();

                TestFinish testFinish = (TestFinish) t[0];

                if (testFinish.getMsg().equals(SignOut)) {

                    ToastUtil.showLong( getResources().getString(R.string.username_login_hint));

                    Intent login = new Intent(getActivity(), LoginActivity.class);

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.USER_ID, "");

                    SharedPrefrenceUtils.saveString(getActivity(), NormalConfig.TOKEN, "");

                    startActivity(login);

                    getActivity().finish();
                }

                if (testFinish.getCode() == 0
                        && testFinish.getData() != null
                        && testFinish.getData().getOrderSalesList() != null
                        && !testFinish.getMsg().equals(SignOut)
                        && testFinish.getData().getCommodity() != null) {
//                    进货订单集合	orderSalesList

                    TestFinish.DataBean data = testFinish.getData();

                    if (TextUtils.isEmpty(data.getAmount())) {

                        tvObligation.setText("今日收款：0");//库存  父 Fragment 顶部赋值
                    } else {

                        tvObligation.setText("今日收款：" + data.getAmount());//库存  父 Fragment 顶部赋值
                    }
                    List<TestFinish.DataBean.OrderSalesListBean> orderSalesList = data.getOrderSalesList();
                    list.addAll(orderSalesList);
                    adapter.setData(data.getCommodity());
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        finishRefresh.finishRefresh();
        finishRefresh.finishLoadMore();
    }

//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        if (!hidden && getActivity()!=null){
//            if (finishRefresh != null)
//                refresh();
//        }
//    }
}