package com.administrator.yaya.activity.orderform;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.fragment.OrderFormkFragment;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
    private View tvObligation;

    public DaiQueRenFragment() {
        // Required empty public constructor
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
        mRefresh.autoRefresh();
        initData();
    }
    @Override
    public void loadMore() {
        super.loadMore();

    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        if (parentFragment1 == null) {
            if (parentFragment1.getView().findViewById(R.id.orderform_inventory_money) != null) {
                tvObligation = parentFragment1.getView().findViewById(R.id.orderform_inventory_money);
            }
        }
    }
    @Override
    protected void initData() {
        super.initData();
        userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(getContext(), NormalConfig.TOKEN);
    }
    @Override
    protected int getLayoutId() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof OrderFormkFragment) {
            parentFragment1 = (OrderFormkFragment) parentFragment;
        }
        return R.layout.fragment_dai_que_ren;
    }
    @Override
    public void onError(int whichApi, Throwable e) {
    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
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
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (getActivity()!=null &&!hidden ){
            if (mRefresh!=null){
                refresh();
            }

        }
    }
}
