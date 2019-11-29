package com.administrator.yaya.activity.my;

import android.content.Intent;
import android.content.SyncAdapterType;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.activity.LoginActivity;
import com.administrator.yaya.activity.my.adapter.SystemMessagesAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpActivity;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.my.TestNotificationInfo;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.administrator.yaya.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 系统消息
 */
public class SystemMessagesActivity extends BaseMvpActivity<LoginModel> implements ICommonView {

    @BindView(R.id.system_msg_back_iv)
    ImageView systemMsgBackIv;

    @BindView(R.id.system_msg_recyclerView)
    RecyclerView mList;
    @BindView(R.id.system_msg_refreshLayout)
    SmartRefreshLayout mRefresh;

//    @BindView(R.id.system_msg_refreshLayout)
//    SmartRefreshLayout systemMsgRefreshLayout;
    private List<TestNotificationInfo.DataBean> list;
    private SystemMessagesAdapter adapter;
    private String userId;
    private String token;


    //    recycleview
    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_messages;
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
    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        initRecycleView(mList,mRefresh);//
        mList.setLayoutManager(new LinearLayoutManager(this));
        //禁止加载
        mRefresh.setEnableLoadMore(false);
        adapter = new SystemMessagesAdapter(list);
        mList.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        super.refresh();
        mList.scrollToPosition(0);
//        mRefresh.autoRefresh();
        //走一遍数据加载
        initData();
    }
    @Override
    protected void initData() {
        super.initData();
//        showLoadingDialog();

        userId = SharedPrefrenceUtils.getString(this, NormalConfig.USER_ID);
        token = SharedPrefrenceUtils.getString(this, NormalConfig.TOKEN);

        mPresenter.getData(ApiConfig.TEST_NOTIFICATION_INFO,Integer.parseInt(userId),token);

    }
    @Override
    public void onResponse(int whichApi, Object[] t) {
//        hideLoadingDialog();
        switch (whichApi) {
            case ApiConfig.TEST_NOTIFICATION_INFO:

                if(!list.isEmpty() || list!=null){
                    list.clear();
                }
                TestNotificationInfo testNotificationInfos  = (TestNotificationInfo) t[0];

                if (testNotificationInfos.getMsg()==mApplication.SignOut){

                    Intent intent = new Intent(this, LoginActivity.class);

                    startActivity(intent);

                    finish();
                }else if (testNotificationInfos.getCode()==0 && testNotificationInfos.getData()!=null){
//                Log.i("tag", "通知消息: "+testNotificationInfos.getData().toString());
                List<TestNotificationInfo.DataBean> data = testNotificationInfos.getData();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }
                break;
        }
        mRefresh.finishRefresh();
    }
    @OnClick({R.id.system_msg_back_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.system_msg_back_iv:
//                if (changeValueCallBack!=null){
//                    //注册接口
//                    changeValueCallBack.changevalue();
//                }
//
                SystemMessagesActivity.this.finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();

        //获取MainActivity的红点控件  返回时 将其隐藏
//        LayoutInflater factory = LayoutInflater.from(SystemMessagesActivity.this);
//        View layout = factory.inflate(R.layout.activity_main, null);
//        TextView textview = (TextView) layout.findViewById(R.id.hongdian);
//
//        Log.i("tag", "红点显示隐藏====>: "+textview.getVisibility());
//
//        if (textview.getVisibility()==View.VISIBLE){//如果现显示的话  隐藏掉
//            textview.setVisibility(View.GONE);
//        }
//
    }
    @Override
    protected void onPause() {
        super.onPause();
//        Log.i("tag", "========> onPause");
    }


    private ChangeValueCallBack changeValueCallBack;
    public interface ChangeValueCallBack {
        void changevalue();
    }
    //提供方法实例化接口
    public void setChangeValueCallBack(ChangeValueCallBack changeValueCallBack){
        this.changeValueCallBack=changeValueCallBack;
    }
}
