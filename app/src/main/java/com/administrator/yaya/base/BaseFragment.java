package com.administrator.yaya.base;

import android.Manifest;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
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

import com.administrator.yaya.utils.ToastUtil;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        bind = ButterKnife.bind(this, inflate);
        initMvp();
        initView(inflate);
        initData();
        initListener();
        return inflate;

    }

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

    private void loadMore() {

    }

    private void refresh() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) bind.unbind();
    }

    public void getPermission() {//是否打开询问开启权限
        XXPermissions.with(getActivity())
//                .constantRequest()//可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                .constantRequest(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES)//支持请求 6.0 悬浮窗权限 8.0 请求安装权限
                .permission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }
                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (denied.size() != 0) ToastUtil.showLong("拒绝权限影响您正常使用");
                    }
                });
//        跳转到设置页面
//        if (XXPermissions.isHasPermission(getContext(), Permission.Group.STORAGE)) {
//            XXPermissions.gotoPermissionSettings(getContext());//跳转到权限设置页面
//        }
    }
}