package com.administrator.yaya.base;
import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.MainActivity;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.utils.ToastUtil;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.ButterKnife;
import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;
public abstract class BaseActivity extends AppCompatActivity {
    protected BaseApp mApplication;
    protected LinearLayoutManager mManager;
    private long lastClickTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BaseApp) getApplication();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.from_right, R.anim.no_slide);//划入
        //沉浸式状态栏
        initMvp();
        initView();
        initData();
        initListener();
    }

    private void setTextViewStyles(TextView textView) {
        LinearGradient mLinearGradient = new LinearGradient(0, 0, textView.getPaint().getTextSize() * textView.getText().length(), 0, Color.parseColor("#FF076BF0"), Color.parseColor("#FF35A6FF"), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(mLinearGradient);
        textView.invalidate();
    }

    private void getPermission() {
        XXPermissions.with(this)
                .constantRequest()//可设置被拒绝后继续申请，直到用户授权或者永久拒绝
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
//                XXPermissions.gotoPermissionSettings(this);//跳转到权限设置页面

    }
    protected abstract int getLayoutId();

    protected void initListener() {

    }

    protected void initData() {
    }

    protected void initView() {

    }

    protected void initMvp() {

    }

    public void initRecycleView(RecyclerView recyclerView, RefreshLayout refreshLayout) {
        mManager = new LinearLayoutManager(this);
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
    protected void onDestroy() {
        super.onDestroy();

    }

    protected int getLoadType(Object[] t) {

        return (int) ((Object[]) t[1])[0];
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_slide, R.anim.out_right);//划出
    }
    /**
     * android 快速点击两次出现两个重复界面
     * 在父类activity中重写事件分发的方法dispatchTouchEvent()
     * 当在activity中快速点击某个控件，时间间隔不超过300ms，此时activity拦截click事件，这是点击的view将得不到响应
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isFastDoubleClick()) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    public boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        lastClickTime = time;
        return timeD <= 300;
    }
}
