package com.administrator.yaya.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.yaya.R;
import com.administrator.yaya.broadcast.NetBroadcastReceiver;
import com.administrator.yaya.broadcast.NetStatusBroadCast;
import com.administrator.yaya.utils.ToastUtil;
import com.administrator.yaya.utils.dialogutils.LoadingDialogWithContent;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.haha.perflib.Main;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import cn.ycbjie.ycstatusbarlib.bar.YCAppBar;
import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;
public abstract class BaseActivity extends AppCompatActivity {
    protected BaseApp mApplication;
    protected LinearLayoutManager mManager;
    private long lastClickTime;
    private static final int REQ_PERMISSION_CODE = 0x100;
    private NetStatusBroadCast mNetStatusBroadCast;
    public Activity activity;
    private NetBroadcastReceiver netWorkChangReceiver;
    public LoadingDialogWithContent mDialog;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = new LoadingDialogWithContent(this, getString(R.string.loading));
        mApplication = (BaseApp) getApplication();
        initExit();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.from_right, R.anim.no_slide);//划入
        //沉浸式状态栏
        setStatusBar();
        initMvp();
        initView();
        initData();
        initListener();
        getPermission();
    }
    private void getPermission() {//是否打开询问开启权限
        XXPermissions.with(this)
//                .constantRequest()//可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                .constantRequest(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES)//支持请求 6.0 悬浮窗权限 8.0 请求安装权限
                .permission(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.READ_PHONE_STATE
                )
//                <!-- 读取手机IMEI的设备权限 -->
//    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
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
    protected void setStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.c_000000));

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }

//        YCAppBar.translucentStatusBar(this, true);
//        YCAppBar.setStatusBarLightMode(this,true);

        //设置状态栏为黑色
//        YCAppBar.setStatusBarColor(this,
//                ContextCompat.getColor(this,
//                        R.color.c_000000));
    }

    protected void initExit() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setTextViewStyles(TextView textView) {
        LinearGradient mLinearGradient = new LinearGradient(0, 0, textView.getPaint().getTextSize() * textView.getText().length(), 0, Color.parseColor("#FF076BF0"), Color.parseColor("#FF35A6FF"), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(mLinearGradient);
        textView.invalidate();
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



    public void showLoadingDialog() {
        if (!mDialog.isShowing()) mDialog.show();
    }

    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String content) {

        Toast.makeText(this, content, Toast.LENGTH_LONG).show();

    }
    public void hideLoadingDialog() {
        if (mDialog.isShowing()) mDialog.dismiss();
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
    public void loadMore() {

    }
    public void refresh() {

    }
//    public void registerNetWorkStatus() {
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        mNetStatusBroadCast = new NetStatusBroadCast();
//        mNetStatusBroadCast.setNetStatusListener();
//        registerReceiver(mNetStatusBroadCast, filter);
//    }

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
     *
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

    /**
     * 在Android 7.0之静态注册广播的方式被取消了，所以这里采用动态注册的方式
     * 注册网络状态监听广播
     */
    public void MonitorNetWorkChange() {
        netWorkChangReceiver = new NetBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkChangReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (netWorkChangReceiver != null) {
            this.unregisterReceiver(netWorkChangReceiver);
        }

        if (mDialog != null){
            if (mDialog.isShowing())mDialog.cancel();
        }
    }


    /**
     *     * getPermission 动态获取权限方法
     * <p>
     *     *
     * <p>
     *     * @param context 上下文
     * <p>
     *     * @param isAsk  是否开启权限询问      (Android6.0以下用户可以不开启,所有权限自动可以获得；6.0以上用户若不开启，获取不到某权限时将默认跳过)
     * <p>
     *     * @param isHandOpen  是否询问用户被引导手动开启权限界面  (用户永久禁用某权限时是否引导让用户手动授权权限)
     * <p>
     *    
     */

    public void getPermission(Context context, boolean isAsk, final boolean isHandOpen) {
        if (!isAsk) return;
        if (XXPermissions.isHasPermission(context,
//所需危险权限可以在此处添加：
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA,
                Permission.WRITE_EXTERNAL_STORAGE)) {
            ToastUtil.showLong("已经获得所需所有权限");
        } else {
            XXPermissions.with((Activity) context).permission(
//同时在此处添加：
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Permission.READ_PHONE_STATE,
                    Manifest.permission.CAMERA,
                    Permission.WRITE_EXTERNAL_STORAGE
            ).request(new OnPermission() {

                @Override

                public void noPermission(List<String> denied, boolean quick) {

                    if (quick) {

                        ToastUtil.showLong("被永久拒绝授权，请手动授予权限");

//如果是被永久拒绝就跳转到应用权限系统设置页面

                        if (isHandOpen) {

                            final AlertDialog.Builder normalDialog =

                                    new AlertDialog.Builder(mApplication);

                            normalDialog.setTitle("开启权限引导");

                            normalDialog.setMessage("被您永久禁用的权限为应用必要权限，是否需要引导您去手动开启权限呢？");

                            normalDialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface arg0, int arg1) {

                                    XXPermissions.gotoPermissionSettings(mApplication);

                                }

                            });

                            normalDialog.setNegativeButton("下一次", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface arg0, int arg1) {

                                }

                            });

                            normalDialog.show();

                        }

                    } else {

                        ToastUtil.showLong("获取权限失败");

                    }

                }

                @Override

                public void hasPermission(List<String> granted, boolean isAll) {

                    if (isAll) {

                        ToastUtil.showLong("获取权限成功");

                    } else {

                        ToastUtil.showLong("获取权限成功，部分权限未正常授予");

                    }

                }

            });

        }

    }

    /**
     * 禁止EditText输入空格
     *
     * @param editText
     */
    public static void setEditTextInhibitInputSpaChat(EditText editText) {
        InputFilter filter_space = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" "))
                    return "";
                else
                    return null;
            }
        };
        InputFilter filter_speChat = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
                String speChat = "[`~!@#_$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）— +|{}【】‘；：”“’。，、？]";
                Pattern pattern = Pattern.compile(speChat);
                Matcher matcher = pattern.matcher(charSequence.toString());
                if (matcher.find()) return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter_space, filter_speChat});
    }
    /**
     *EditText动态限制字数
     */
    public static void setEditTextLengthLimit( EditText editText, int length) {
        editText.setFilters( new InputFilter[]{new InputFilter.LengthFilter(length)});
    }

    //沉浸式状态栏
    @SuppressLint("ObsoleteSdkInt")
    public static void makeStatusBarTransparent(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
