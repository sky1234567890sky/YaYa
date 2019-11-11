package com.administrator.yaya.base;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;

public abstract class BaseFragment extends Fragment {
    private Unbinder bind;

    private LinearLayoutManager mManager;
    public boolean isRefresh = false;//刷新用到
//    private boolean isCreate = false;
//    private boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
//      isCreate = true;
        bind = ButterKnife.bind(this, inflate);
        initMvp();
        initData();
        initView(inflate);
        initListener();
        return inflate;

    }
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser &&  isCreate) {
//            isCreate = false;
//        } else {
//            isCreate = true;
//            isVisible = true;
//        }
//    }
    protected abstract int getLayoutId();
    protected void initData() {

    }

    protected void initListener() {

    }
    protected void initView(View inflate) {

    }
    protected void initMvp() {

    }
    public void initRecycleView(RecyclerView recyclerView, RefreshLayout refreshLayout) {
        mManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mManager);
        if (refreshLayout != null) {
            refreshLayout.setHeaderHeight(px2dp(120));
            refreshLayout.setFooterHeight(px2dp(100));
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refresh();
                }
            });
            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    loadMore();
                }
            });
        }
    }
    public void loadMore() {
    }
    public  void refresh() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) bind.unbind();
    }
}